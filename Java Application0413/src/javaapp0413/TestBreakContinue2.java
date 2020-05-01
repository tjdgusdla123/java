package javaapp0413;

import java.util.Scanner;

public class TestBreakContinue2 {

	public static void main(String[] args) {
		//root가 아닌 데이터를 입력할 때까지
		//계속 입력받기
		Scanner sc = new Scanner(System.in);
		
		//무한반복
		while(true) {
			System.out.print("아이디 입력:");
			String id = sc.nextLine();
			//id가 root 가 아니면 종료
			if(id.equals("root") == false) {
				break;
			}
			System.out.println("존재하는 아이디");
		}
		
		System.out.println("사용 가능한 아이디");
		
		//스캐너 사용 종료
		//sc.close();
	}

}



