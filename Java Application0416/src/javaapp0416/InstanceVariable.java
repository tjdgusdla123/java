package javaapp0416;

public class InstanceVariable {

	public static void main(String[] args) {
		//Student1 클래스의 인스턴스를 생성
		Student1 obj1 = new Student1();
		//인스턴스를 이용해서 프로퍼티 접근
		obj1.num = 1;
		obj1.name = "신예은";
		
		//다른 인스턴스 생성
		Student1 obj2 = new Student1();
		obj2.num = 2;
		obj2.name = "배주현";
		
		//클래스 안에 static 없이 만들어진 변수는
		//인스턴스마다 별도로 생성 - 프로퍼티라고 합니다.
		System.out.println(obj1.name);
		System.out.println(obj2.name);

	}

}
