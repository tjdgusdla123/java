
public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		try {
			for(int i=0; i<10; i=i+1) {
				Thread.sleep(1000);
				System.out.println("별도의 클래스 생성");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
