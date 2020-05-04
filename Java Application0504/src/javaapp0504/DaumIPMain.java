package javaapp0504;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DaumIPMain {

	public static void main(String[] args) {
		try {
		//hostName에는 프로토콜이 포함되지 않습니다.
			InetAddress[] daum = 
				InetAddress.getAllByName(
					"www.naver.com");
			for(InetAddress imsi:daum) {
				System.out.println(imsi);
			}
			
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		

	}

}
