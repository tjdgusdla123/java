package javaapp0413;

import java.util.Scanner;

public class Toggle {

	public static void main(String[] args) {
		//Toggle(교번) - 2개의 상태를 번갈아가면서 변경
		//2로 나눈 나머지를 이용해도 되고
		//변수를 하나 만들어서 변수의 상태변화를 이용하기도 합니다.
		
		//Enter를 누를 때 마다 ON 과 OFF를 수행하는 처리
		Scanner sc = new Scanner(System.in);
		int flag = 1;
		while(true) {
			System.out.print("Enter를 누르세요:");
			sc.nextLine();
			//System.out.println("Enter 누름");
			if(flag > 0) {
				System.out.println("ON");
			}else {
				System.out.println("OFF");
			}
			flag = -flag;
		}

	}

}


