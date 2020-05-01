package javaapp0501;

import java.io.FileReader;
import java.io.FileWriter;

public class CharacterFileInOut {

	public static void main(String[] args) {
		// 문자 단위로 기록하기
		// ()안에서 만든 것은 close()를 호출하지 않아도 자동종료
		// {}안에서 만든것은 close()를 호출해야 종료가 됩니다.
		// close()를 호출하지 않으면 파일이 읽기 전용이 될 수있습니다.
		try (FileWriter fw = new FileWriter("./ch.txt")){
			//기록하고자 하는 문자열 생성
			String msg ="문자 단위로 기록하기";
			fw.write(msg);
			fw.flush();

		} catch (Exception e) {
			// 예외 내용을 출력
			System.out.println(e.getMessage());
			// 예외 발생 지점을 역추적
			e.printStackTrace();
		}
		try(FileReader fr =new FileReader("./ch.txt")){
			char[]buf =new char [512];
			fr.read(buf);
			System.out.println(new String (buf));
			} catch (Exception e) {
			// 예외 내용을 출력
			System.out.println(e.getMessage());
			// 예외 발생 지점을 역추적
			e.printStackTrace();
		}
	}

}
