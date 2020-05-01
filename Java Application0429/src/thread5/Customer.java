package thread5;

public class Customer extends Thread {
	// 공유자원을 소비하는 메소드
	public synchronized void get() {
		if (ShareData.list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 첫번째 데이터 삭제
		String msg = ShareData.list.remove(0);
		System.out.println(msg + " 소비");
	}

	// 스레드로 동작할 메소드
	public void run() {
		for (int i = 0; i < 10; i = i + 1) {
			get();
		}
	}
}
