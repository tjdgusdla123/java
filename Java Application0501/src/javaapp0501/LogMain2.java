package javaapp0501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LogMain2 {

	public static void main(String[] args) {
		try(BufferedReader br = 
			new BufferedReader(
				new InputStreamReader(
					new FileInputStream(
						"C:\\Users\\30410\\Downloads\\log.txt")))){
			//System.out.println(br);
			
			int total = 0;
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				//System.out.println(line);
				
				String [] data = line.split(" ");
				//System.out.println(data[9]);
				//정수로 변환이 안되는 데이터가 있는 경우
				//계속 작업을 수행하기 위해서 예외처리
				try {
				total = total + Integer.parseInt(data[9]);
				}catch(Exception e) {}
			}
			
			System.out.println("트래픽 합계:" + total);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
