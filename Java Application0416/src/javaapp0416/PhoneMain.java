package javaapp0416;

public class PhoneMain {

	public static void main(String[] args) {
		String str = new String("Hello Java");
		String result = str.substring(4);
		System.out.println(result);
		
		//Phone 클래스의 인스턴스를 생성
		Phone obj1 = new Phone();
		//인스턴스를 이용해서 데이터 대입
		obj1.setNum(1);
		obj1.setName("제니");
		obj1.setPhoneNumber("01000001111");
		obj1.setEmail("aaa@bbb.ccc");
		//name을 가져와서 출력
		System.out.println("이름:" + obj1.getName());
		//변수에 직접 접근하는 것은 안됩니다.
		
		//Phone 클래스에 만든 static 메소드 호출
		//static 메소드는 클래스이름으로 호출
		Phone.staticMethod();
		

	}

}



