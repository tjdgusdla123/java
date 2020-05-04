package javaapp0504;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.URL;
import java.util.Scanner;

public class NaverHTML {

	public static void main(String[] args) {
		try {
			// html을 다운로드 받을 주소 만들기
			URL url = new URL("http://www.naver.com");
			// 연결 객체 만들기
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// 연결옵션 만들기
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			
			//문자열을 만들기 위한 스트림 생성
			BufferedReader br =new BufferedReader(new InputStreamReader( con.getInputStream()));
			
			//문자열 읽어오기
			String html ="";
			while(true) {
				String line =br.readLine();
				if(line==null) {
					break;
				}
				html =html+line+"\n";
			}
			
			//정리 작업
			br.close();
			con.disconnect();
			//데이터확인
			System.out.println(html);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

			
		}
	}
}
