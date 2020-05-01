package javaapp0423;

import java.io.IOException;

public class SystemMain {

	public static void main(String[] args) {
		//Hello Java를 10만 번 출력하는데 걸리는 시간
		//Hello Java를 10만 번 출력
		//시간을 측정 - 테스트를 해주는 프로그램을 이용하기도 함
		
		//현재 시간을 가져오는 메소드를 호출해서 결과를 저장
		long start = System.nanoTime();	
		for(int i=0; i<100000; i=i+1) {
			System.out.println("Hello Java");
		}
		//현재 시간을 가져오는 메소드를 호출
		long end = System.nanoTime();
		System.out.println("걸린시간:" + (end-start));
		
		String javaVersion = 
				System.getProperty("java.version");
		System.out.println(javaVersion);
		
		//프로세스 실행과 관련된 클래스의 인스턴스를 생성
		Runtime r = Runtime.getRuntime();
		try {
			r.exec("notepad.exe "
					+ "C:\\hybrid\\Java\\Java Application\\0422.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//MAC : r.exec(
		//"open /System/Applications/TextEdit.app");
	}
}





