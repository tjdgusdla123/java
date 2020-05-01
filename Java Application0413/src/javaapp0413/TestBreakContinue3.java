package javaapp0413;

import java.util.Scanner;

public class TestBreakContinue3 {
	public static void main(String [] args) {
		//1~45 사이의 숫자를 6번 입력받기
		Scanner sc = new Scanner(System.in);
			
		for(int idx=0; idx<6; idx=idx+1) {
			System.out.print("1~45 숫자 입력:");
			int su = sc.nextInt();
			//1보다 작거나 45보다 큰 경우
			if(su < 1 || su > 45) {
				System.out.println(
						"1~45 사이의 숫자를 입력하세요!!");
				idx = idx - 1;
				continue;
			}
			System.out.println(idx + "번째:" + su);
		}
		System.out.println("종료");
		
	}
}
