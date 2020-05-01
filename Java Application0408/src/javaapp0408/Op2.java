package javaapp0408;

public class Op2 {
	public static void main(String[] args) {
		int idx = 0;
		while(true) {
			//mod는 idx를 2로 나눈 나머지
			int mod = idx % 2;
			if(mod==0)
				System.out.println("빨강");
			else if(mod==1)
				System.out.println("파랑");
			try {
				//2초대기
				Thread.sleep(2000);
			}catch(Exception e) {}
			
			idx++;
		}

	}
}
