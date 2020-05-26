package xmlparsing;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherXMLParsing {

	public static void main(String[] args) {
		// Anonymous Class를 이용해서
		// Thread 클래스로부터 상속받는 클래스의 인스턴스를 생성
		Thread th = new Thread() {
			public void run() {
				// run 메소드 안에서 예외가 발생했을 때
				// return 하도록 만들면 스레드를 중지시킬 수 있습니다.
				try {
					String weatherString = null;
					try {
						// URL만들기
						String addr = " http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
						URL url = new URL(addr);

						// 2.연결 객체 만들기 - header 추가 여부 확인
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setConnectTimeout(30000);
						con.setUseCaches(false);
						// 스트림을 ㅅ생성하고 줄 단위로 읽어서 저장하기
						StringBuilder sb = new StringBuilder();
						BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
						while (true) {
							String line = br.readLine();
							if (line == null) {
								break;
							}
							sb.append(line + "\n");
						}

						weatherString = sb.toString();
						br.close();
						con.disconnect();

					} catch (Exception e) {
						System.out.println("다운로드 예외");
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
					// 데이터 확인
					// System.out.println(weatherString);
					List<Map<String, Object>> list = new ArrayList<>();
					if (weatherString != null && weatherString.trim().length() > 0) {
						// xml 문자열에서 루트 태그 찾아오기
						DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
						DocumentBuilder builder = factory.newDocumentBuilder();
						Document document = builder.parse(new ByteArrayInputStream(weatherString.getBytes()));
						Element root = document.getDocumentElement();

						// 도시이름 찾아오기
						List<String> cities = new ArrayList<>();
						NodeList cityList = root.getElementsByTagName("city");
						for (int i = 0; i < cityList.getLength(); i = i + 1) {
							Node node = cityList.item(i);
							Node citi = node.getFirstChild();
							cities.add(citi.getNodeValue());
							
						} 
						//System.out.println(cities);
						
						//날짜 ,날씨, 최고온도 , 최저온도를 가져오기
						NodeList dateList = root.getElementsByTagName("tmEf");
						NodeList wfList = root.getElementsByTagName("wf");
						NodeList tmxList = root.getElementsByTagName("tmx");
						NodeList tmnList = root.getElementsByTagName("tmn");
						//날짜 ,날씨, 최고온도 , 최저온도를 저장할 임시 리스트
						List<String> list1 = new ArrayList<>();
						List<String> list2 = new ArrayList<>();
						List<String> list3 = new ArrayList<>();
						List<String> list4 = new ArrayList<>();
						for (int i = 0; i < dateList.getLength(); i++) {
							//날짜를 list1에 저장하기
							
							Node node = dateList.item(i);
							Node temp = node.getFirstChild();
							list1.add(temp.getNodeValue());
							//날씨를 list2에저장하기
							//wf 만 초기데이터가 1개 더 있어서 하나 뒤의 데이터 가져오기
						     node = wfList.item(i+1);
							 temp = node.getFirstChild();
							list2.add(temp.getNodeValue());
							//최고온도를 list3에 저장하기
							 node = tmxList.item(i);
							 temp = node.getFirstChild();
							list3.add(temp.getNodeValue());
							//최저온도를 list4에 저장하기
							 node = tmnList.item(i);
							 temp = node.getFirstChild();
							list4.add(temp.getNodeValue());
							
							
						}
						/*System.out.println(cities);
						System.out.println(list1);
						System.out.println(list2);
						System.out.println(list3);
						System.out.println(list4);*/
						
						//cities 와 list,list1,list2,list3,list4
						//의 데이터를 모아서 하나의 List로 만들기
						//citi 1개에 각 데이터가 13개씩 존재
						//i:0 -> j:0-12
						//i:1 -> j:13-25
						
						for (int i = 0; i < cities.size(); i++) {
							//도시이름 1개 가져오기
							String city =cities.get(i);
							//도시이름 1개당
							//13개의 날짜 ,날씨, 최고온도, 최저온도를 가져오기
							for (int j = 0; j < 13; j++) {
								String date =list1.get(i*13+j);
								String wf =list2.get(i*13+j);
								String tmx =list3.get(i*13+j);
								String tmn =list4.get(i*13+j);
								//맵 생성
								Map<String,Object> map = new HashMap<>();
								map.put("city",city);
								map.put("date",date);
								map.put("wf",wf);
								map.put("tmx",tmx);
								map.put("tmn",tmn);
								list.add(map);
								
							}
						}
						
					} else {
						System.out.println("읽어온 데이터가 없습니다.");
					}
			
					/*System.out.println(list);
					city의 값이 목포인 경우만 출력
					for(Map<String,Object> map : list) {
						if(((String)map.get("city")).equals("서울")) {
							System.out.println(map);
						}
					}*/
					
					//MySQL저장
					try {
						//드라이버 클래스 로드
						Class.forName("com.mysql.cj.jdbc.Driver");
						//데이터베이스 연결
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample"
								+ "?useUnicode=true&characterEncoding=utf8" + "&serverTimezone=UTC", "root", "8989450a");
						//SQL 실행
						for(Map<String,Object>map: list) {
							PreparedStatement pstmt = con.prepareStatement(" insert into weather(weathercity,weatherdate,weatherwf,weathertmx,weathertmn) "+" values(?,?,?,?,?) ");
							pstmt.setString(1,(String)map.get("city"));                            
							pstmt.setString(2,(String)map.get("date"));
							pstmt.setString(3,(String)map.get("wf"));
							pstmt.setString(4,(String)map.get("tmx"));
							pstmt.setString(5,(String)map.get("tmn"));
							
						pstmt.executeUpdate();
						pstmt.close();
						}
						
						//사용한 객체 정리
						con.close();
						
					} catch (Exception e) {
						System.out.println("데이터 저장 실패");
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				} catch (Exception e) {

					return;
				}
			}
		};
		// 스레드 시작
		th.start();

	}

}
