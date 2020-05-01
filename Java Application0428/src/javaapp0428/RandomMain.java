package javaapp0428;

import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		
		String [] monster = {
			"라투", "오미크론", "다크스펙터", "나즈",
			"오미크론","오미크론","다크스펙터","다크스펙터"};
		Random r = new Random();
		//위의 배열의 데이터를 1초마다 랜덤하게 출력
		//10번만 수행
		for(int i=0; i<10; i=i+1) {
			try {
				//Thread.sleep(1000);
				System.out.println(
					monster[r.nextInt(monster.length)]);
			} catch (Exception e) {}
		}
		
		String [] slot = {"!", "?", "*", "%"};
		String msg = "";
		for(int i=0; i<3;i=i+1) {
			msg = msg + slot[r.nextInt(slot.length)];
		}
		System.out.println(msg);
		if(msg.charAt(0) == msg.charAt(1) 
				&& msg.charAt(1) == msg.charAt(2)) {
			System.out.println("축하합니다. !!!!");
		}else {
			System.out.println("꽝");
		}
		
		
		
		
		
		
		
		
		
		
	}
}




