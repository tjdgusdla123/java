package javaapp0413;

public class TestFor1 {

	public static void main(String[] args) {
		//1부터 10까지 반복문을 이용해서 출력
		/*
		for(int idx = 1; idx < 11; idx = idx + 1) {
			System.out.println(idx);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		*/
		//1-5까지 반복
		/*
		for(int idx = 1; idx < 6; idx = idx + 1) {
			System.out.println(idx);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		*/
		
		//0,2,4,6,8 을 출력
		/*
		for(int idx = 0; idx < 10; idx = idx + 2) {
			System.out.println(idx);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		*/
		
		//9,8,7,...0
		/*
		for(int idx = 1; idx < 11; idx = idx + 1) {
			System.out.println(10-idx);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		*/
		
		//0,1 반복
		/*
		for(int idx = 1; idx < 11; idx = idx + 1){
			//나머지를 구하면 값이 제한이 됩니다.
			int nmg = idx % 2;
			System.out.println(nmg);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		*/
		
		//0,0,1,1 반복
				for(int idx = 0; idx < 10; idx = idx + 1){
					int mok = idx / 2;
					//나머지를 구하면 값이 제한이 됩니다.
					int nmg = mok % 2;
					System.out.println(nmg);
					try {
						Thread.sleep(1000);
					}catch(Exception e) {}
				}
		
	}

}





