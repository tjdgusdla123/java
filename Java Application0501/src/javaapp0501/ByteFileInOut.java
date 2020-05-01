package javaapp0501;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileInOut {

	public static void main(String[] args) {
		// 파일에 기록할 스트림 변수
		FileOutputStream fos = null;

		try {
			// 예외가 발생할 가능성이 있는 코드
			// 파일에 바이트 단위로 기록할 스트림 생성
			fos = new FileOutputStream("./test.txt");

			String msg = "임성현";
			fos.write(msg.getBytes());
			fos.flush();

		} catch (Exception e) {
			// 예외가 발생했을 때 수행할 코드
			System.out.println(e.getMessage());
			// 예외 발생 지점을 역추적
			e.printStackTrace();
			
		} finally {
			// 무조건 수행되는 코드
			try {
				fos.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}

		}
		//파일의 내용을 바이트 단위로 읽기
		//try~resources
		//try()안에서 생성한 것은 close를 호출하지 않아도 자동으로 close를 합니다.
		try(FileInputStream fis =new FileInputStream("./test.txt")) {
			
			//파일의 내용을 바이트 단위로 읽기
			byte [] b =new byte [1024];
			int len =fis.read(b);
			if(len==-1) {
				System.out.println("읽은 데이터가 없음");
			}else {
				System.out.println(new String(b));
			}
			
			
		}catch (Exception e) {
				// 예외가 발생했을 때 수행할 코드
				System.out.println(e.getMessage());
				// 예외 발생 지점을 역추적
				e.printStackTrace();
		}
	}

}
