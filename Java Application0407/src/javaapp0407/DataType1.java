package javaapp0407;

public class DataType1 {

	public static void main(String[] args) {
		//나이를 Main Memory에 저장
		int age = 50;
		//키를 저장 - 키는 소수 첫째자리까지 저장
		double height = 167.5;
		//어떤 변수에 true를 저장
		//boolean은 다른 것과 구분하기 위해서
		//이름 앞에 is를 붙이는 것을 권장
		boolean isPass = true;
		
		//하나의 영역({ })안에서 동일한 이름의
		//변수를 2번 만들면 안됩니다.
		//int age = 49;
		
		age = 49;//age에 49를 대입
		
		//age에 저장한 값을 출력
		System.out.println("나이는 " + age + "세");
		
		//char는 숫자를 저장하고 있다가
		//출력할 때만 숫자에 해당하는 문자를 출력
		char ch = 65;
		int i = 65;
		System.out.println(ch);
		System.out.println(i);

	}

}
