package datashare;

public class Main {

	public static void main(String[] args) {
		//클래스의 인스턴스 2개 생성
		Tjoeun temp1 = new Tjoeun();
		Tjoeun temp2 = new Tjoeun();
		
		//noShare는 인스턴스 프로퍼티이므로 변경해도
		//다른 인스턴스에는 아무런 영향이 없습니다.
		temp1.noShare = "안녕 temp2";
		
		System.out.println(temp2.noShare);
		
		temp1.msg = "이번엔 공유가능";
		System.out.println(temp2.msg);
		
		temp1.globalChange();
		
		System.out.println(GlobalClass.globalMsg);
		
		Singleton s1 = Singleton.sharedInstance();
		Singleton s2 = Singleton.sharedInstance();
		
		//2개의 인스턴스가 동일한 지 확인은 해시코드를 이용
		System.out.println(
			System.identityHashCode(s1));
		System.out.println(
			System.identityHashCode(s2));
		
		Singleton.sharedInstance()
			.sharedVariable = "Singleton";

		Parent p = new Parent();
		
		System.out.println(Thread.MAX_PRIORITY);
		
		int result = Math.max(20, 30);
		System.out.println(result);
	}

}
