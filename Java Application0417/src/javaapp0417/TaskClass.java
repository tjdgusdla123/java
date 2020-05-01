package javaapp0417;

public class TaskClass {

	//재귀를 이용하지 않고 n번째 피보나치 수열의 값을
	//리턴해주는 메소드
	public static int noRecuresionFibo(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}else {
			//현재 계산 값의 2번째 전의 항의 데이터를 저장할 변수
			int f2 = 1;
			//현재 계산 값의 1번째 전의 항의 데이터를 저장할 변수
			int f1 = 1;
			//현재 위치의 피보나치 수열의 값
			int fibo = -1;
			//앞의 2번은 제외를 해야 해서 3부터 시작
			for(int i=3; i<=n; i=i+1) {
				fibo = f1 + f2;
				f2 = f1;
				f1 = fibo;
			}
			return fibo;
		}
	}
	//재귀를 이용한 피보나치 수열의 값
	//첫번째와 두번째는 1
	//그 이외의 경우는 n-1 번째와 n-2 번째의 합
	public int recursiveFibo(int n){
		if(n==1 || n==2){
			return 1;
		}else{
			return
			recursiveFibo(n-1) + recursiveFibo(n-2);
		}
	}
	
}




