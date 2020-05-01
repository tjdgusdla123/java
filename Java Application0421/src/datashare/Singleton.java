package datashare;

public class Singleton {
	//싱글톤 패턴을 위한 코드
	//1. 생성자를 private 으로 생성
	private Singleton() {}
	
	//2.private static으로 자신의 타입 변수를 선언
	private static Singleton obj;
	
	//3.인스턴스를 생성해서 리턴하는 static 메소드 생성
	public static Singleton sharedInstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}
	
	//공유 변수
	public String sharedVariable;
}




