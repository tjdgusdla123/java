package javaapp0413;

public class TestBreakContinue1 {

	public static void main(String[] args) {
		for(int i=1; i<=10; i=i+1) {
			if(i % 3 == 0) {
				//3의 배수를 만나면 반복문이 종료
				//break;
				
				//3의 배수가 되면 아래로 내려가지 않고
				//다음 반복을 수행
				//1,2, 4,5, 7,8, 10
				continue;
			}
			System.out.println(i);
		}

	}

}
