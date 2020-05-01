package javaapp0424;

import java.util.Arrays;

public class SearchMain {

	public static void main(String[] args) {
		String [] soccers = 
			{"반바스텐", "베르캄프", "조지웨아",
				"크루이프", "호나우두", "기린샤",
				"펠레","마라도나", "차범근", "굴리트"
			};
		//데이터 정렬
		Arrays.sort(soccers);
		//호날두가 있는지 검색
		System.out.println(
			Arrays.binarySearch(soccers, "호날두"));
		System.out.println(
			Arrays.binarySearch(soccers, "차범근"));
		
		String [] alphabets = 
			{
				"Ronaldo", "cha", "Park"	
			};
		//영문 배열과 동일한 크기의 배열을 생성
		//원본을 변경하면 안되기 때문에 복사본을 저장할 배열을 생성
		String [] imsi = new String[alphabets.length];
		//데이터 복사
		for(int i=0; i<imsi.length; i=i+1) {
			//원본의 데이터를 대문자로 변경해서 복사본 배열에 저장
			imsi[i] = alphabets[i].toUpperCase();
		}
		//복사본 배열을 정렬해서 출력
		Arrays.sort(imsi);
		for(String soccer : imsi) {
			System.out.println(soccer);
		}

	}

}
