package anonymous1;

public class Main {

	public static void main(String[] args) {
		Annony1Ex obj = new Annony1Ex();
		obj.method();
		
		//Anony1 클래스를 상속받는 Anonymous class
		Anony1 obj1 = new Anony1() {
			@Override
			public void method() {
				System.out.println(
					"anonymous를 이용한 상속 구현");
			}
		};
		
		obj1.method();
	}

}
