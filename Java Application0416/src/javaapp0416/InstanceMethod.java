package javaapp0416;

public class InstanceMethod {

	public static void main(String[] args) {
		Student3 obj = new Student3();
		obj.num = 1;
		obj.name = "지수";
		//매개변수가 정수 3개인 메소드 호출
		obj.set(98, 88, 93);
		
		//위의 내용을 출력하는 메소드를 호출
		obj.disp();
		
		//정수를 리턴하는 메소드를 호출
		//메소드의 호출 결과를 다른 변수에 저장
		int tot = obj.sum();
		double avg = tot / 3.0;
		System.out.println(
			"합계:" + tot + " 평균:" + avg);
	}

}




