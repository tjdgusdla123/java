package javaapp0417;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		//년월일을 입력받아서 무슨 요일인지 출력
		Scanner sc = new Scanner(System.in);
		
		//년월일 입력받기
		System.out.print("년도 입력:");
		int year = sc.nextInt();
		
		System.out.print("월 입력:");
		int month = sc.nextInt();
		
		System.out.print("일 입력:");
		int day = sc.nextInt();
		
		sc.close();
		
		//입력받은 년도 이전까지 지나온 날들을 전부 더합니다.
		int tot = 0;
		//윤년이면 366을 더하고 그렇지 않으면 365를 더합니다.
		for(int i=1; i<year; i=i+1) {
			if(i%4==0 && i%100!=0 || i%400==0) {
				tot = tot + 366;
			}else {
				tot = tot + 365;
			}
		}
		
		//각 월의 날짜 수를 갖는 배열을 생성
		int [] nalsu = {
			0, 31, 28, 31, 30, 31, 30, 
			31, 31, 30, 31, 30, 31};
		//입력한 년도가 윤년이면 2월은 29일 까지
		if(year%4==0 && year%100!=0 || year%400==0) {
			nalsu[2] = 29;
		}
		//입력한 월 이전 까지의 날 수를 전부 더합니다.
		for(int i=0; i<month; i=i+1) {
			tot = tot + nalsu[i];
		}
		
		//입력받은 일을 더함
		tot = tot + day - 1;
		
		//요일은 7번마다 1번씩 돌아오므로 7로 나눈 나머지 계산
		int result = tot % 7;
		
		String [] weekday = 
			{"월요일", "화요일", "수요일", "목요일",
					"금요일", "토요일", "일요일"
			};
		System.out.println(weekday[result]);
		
		/*
		 ***
		  **
		   *
		  **
		 ***
		 */
		
		//전부 5줄
		//3번째 줄을 기준으로 규칙이 변경
		//각 줄은 공백과 별을 함께 출력
		for(int i=0; i<5; i=i+1) {
			if(i < 3) {
				//공백 : 0, 1, 2
				for(int j=0; j<i; j=j+1) {
					System.out.print(" ");
				}
				//* : 3, 2, 1
				for(int j=0; j<3-i; j=j+1) {
					System.out.print("*");
				}
			}else {
				//공백 : 1, 0
				for(int j=0; j<4-i; j=j+1) {
					System.out.print(" ");
				}
				//* : 2, 3
				for(int j=0; j<i-1; j=j+1) {
					System.out.print("*");
				}
			}
			
			System.out.print("\n");
		}

	}

}
