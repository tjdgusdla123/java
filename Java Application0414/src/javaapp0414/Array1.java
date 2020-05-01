package javaapp0414;

public class Array1 {

	public static void main(String[] args) {
		//사람이름(String) 배열을 생성
		//초기값을 가지고 생성
		String [] programmers = 
			{"데니스 리치히", "제임스 고슬링",
					"반 귀도 로썸"};
		//배열이름을 출력 - 해시코드가 출력
		System.out.println("programmers:" + 
				programmers);
		//첫번째 요소를 출력
		System.out.println(programmers[0]);
		//배열 요소 전체를 출력
		for(int i=0; i<3; i=i+1) {
			System.out.println(programmers[i]);
		}
		
		//인덱스를 잘못 사용한 경우
		//ArrayIndexOutOfBoundsException 발생
		//System.out.println(programmers[3]);
		
		//배열이 생성되기 전에 속성을 호출
		//NullPointerException
		//int [] ar = null;
		//System.out.println(ar.length);
	}

}
