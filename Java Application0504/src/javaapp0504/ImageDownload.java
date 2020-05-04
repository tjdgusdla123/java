package javaapp0504;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageDownload {

	public static void main(String[] args) {
		// 파일의 존재 여부 확인
		File f = new File("./2.jpg");
		if (f.exists() == true) {
			System.out.println("파일이 이미 존재합니다.");
			System.exit(0);
		} else {
			System.out.println("파일이 존재하지 않아서 다운로드를 받습니다.");
		}

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

			// 바이트 단위로 데이터를 전송받을 스트림을 생성
			BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

			// 바이트 배열을 저장할 파일 출력 스트림 생성
			PrintStream ps = new PrintStream("./2.jpg");

			while (true) {
				// 데이터를 읽어서 b에 저장하고 읽은 개수를
				// len에 저장
				byte[] b = new byte[512];
				// 읽은 데이터가 없으면 종료
				int len = bis.read(b);
				if (len <= 0) {
					// b배열에서 읽은 개수만큼만 기록
					break;
				}
				ps.write(b, 0, len);
			}
			// 버퍼를 이용하기 때문에 모아서 출력을 합니다.
			// 종료할 때는 혹시 버퍼에 내용이 남아있을 수 있기
			// 때문에 flush를 호출해서 남은 내용을 출력
			ps.flush();
			// 정리 작업
			ps.close();
			bis.close();
			con.disconnect();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
