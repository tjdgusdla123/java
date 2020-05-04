package javaapp0504;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownload {

	public static void main(String[] args) {
		try {
			// 다운로드 받을 URL을생성
			URL url = new URL(
					"http://thumbnail.10x10.co.kr/webimage/image/basic/153/B001530018.jpg?cmd=thumb&w=500&h=500&fit=true&ws=false");
			// 연결 객체 생성 하고 옵셥 설정
			// 연결 객체 만들기
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 연결옵션 만들기
			con.setConnectTimeout(30000);
			con.setUseCaches(false);

			//바이트 단위로 데이터를 전송받을 스트림을 생성
			BufferedInputStream bis =new BufferedInputStream( con.getInputStream());
			
			//바이트 배열을 저장할 파일 출력 스트림 생성
			PrintStream ps = new PrintStream("./2.jpg");
			
			while(true) {
				//데이터를 읽어서 b에 저장하고 읽은 개수를
				//len에 저장
				byte[] b =new byte[512];
				//읽은 데이터가 없으면 종료
				int len =bis.read(b);
				if(len<=0) {
					
				}
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
