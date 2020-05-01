package javaapp0408;

public class DoublePloblem {

	public static void main(String[] args) {
		double sum = 0;
		int idx=0;
		//실수를 가지고 산술연산을 하면
		//잘못된 결과가 나올 수 있음
		while(idx<1000) {
			sum = sum + 0.1;
			idx++;
		}
		System.out.println(sum);
		
		System.out.println((1.0-0.8) == 0.2);

	}

}
