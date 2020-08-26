
public class Main {

	public static void main(String[] args) {
		//별도의 클래스를 만들어서 스레드를 사용
		Thread th1 = new Thread(new RunnableImpl());
		th1.start();
		
		//anonymous class를 이용하는 방법
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=0; i<10; i=i+1) {
						Thread.sleep(1000);
						System.out.println("익명 클래스 생성");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}).start();
		
		new Thread(()-> {
			try {
				for(int i=0; i<10; i=i+1) {
					Thread.sleep(1000);
					System.out.println("람다 이용");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}).start();

	}
}
