package javaapp0428;

import java.util.HashMap;

public class MapMain2 {

	public static void main(String[] args) {
		//2차원 배열 - 배열의 배열
		//프로야구 선수들의 팀별 선수 명단을 데이터로 작성
		String [] kia = {"김선빈", "김윤동", "김주찬", "최형우"};
		String [] dusan = {"정수빈", "박치국"};
		String [] lg = {"이형종", "임찬규"};
		String [] hanhwa = {"이용규"};
		
		//이차원 배열 생성
		//배열에는 비교가 가능한 데이터만 저장하기 때문에
		//데이터이외의 정보를 저장하지 못해서
		//이차원 배열을 이용하는 경우 배열의 특성을 출력할 수 없습니다.
		String [][] players = {kia, dusan, lg, hanhwa};
		
		//데이터 출력
		for(int i=0; i<players.length; i=i+1) {
			//팀 이름을 출력
			if(i==0) {
				System.out.printf("%5s", "기아:");
			}else if(i==1) {
				System.out.printf("%5s", "두산:");
			}else if(i==2) {
				System.out.printf("%5s", "엘지:");
			}
			//각 팀의 선수명단
			String [] temp = players[i];
			for(String imsi : temp) {
				System.out.printf("%7s", imsi);
			}
			System.out.printf("\n");
			}
		
		//배열들을 하나로 묶어 줄 때는 Map을 만들어서 
		//배열의 특징과 데이터를 저장하고 Map의 배열을 만들어주는 
		//것이 좋습니다.
		HashMap<String, Object> map1 = 
			new HashMap<String, Object>();
		map1.put("team", "기아");
		map1.put("player", kia);
		
		HashMap<String, Object> map2 = 
				new HashMap<String, Object>();
		map2.put("team", "두산");
		map2.put("player", dusan);
		
		HashMap<String, Object> map3 = 
				new HashMap<String, Object>();
		map3.put("team", "엘지");
		map3.put("player", lg);
		
		HashMap<String, Object> map4 = 
				new HashMap<String, Object>();
		map4.put("team", "한화");
		map4.put("player", hanhwa);
		
		HashMap [] kbo = 
			{map1, map2, map3, map4};
		
		//출력하는 부분
		for(HashMap map : kbo) {
			System.out.printf("%5s", map.get("team"));
			//출력 이외의 작업을 할 때는 원래 자료형으로 형 변환해서
			//사용해야 합니다.
			String [] player =
					(String [])map.get("player");
			for(String p : player) {
				System.out.printf("%7s", p);
			}
			System.out.printf("\n");
			
		}

	}

}
