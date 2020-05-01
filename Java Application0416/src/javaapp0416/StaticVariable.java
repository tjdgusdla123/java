package javaapp0416;

public class StaticVariable {

	public static void main(String[] args) {
		Student2 obj1 = new Student2();
		Student2 obj2 = new Student2();
		obj1.name = "조이";
		obj2.name = "아이린";
		
		//static 변수를 인스턴스를 이용해서 접근하면 경고
		//되도록이면 클래스이름으로 접근
		//obj1.schoolName = "JYP";
		//obj2.schoolName = "Kakao";
		
		Student2.schoolName = "SM";
		
		
		System.out.println(
				obj1.schoolName + ":" + obj1.name);
		System.out.println(
				obj2.schoolName + ":" + obj2.name);

	}

}
