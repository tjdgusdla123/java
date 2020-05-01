package javaapp0424;

import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		//정수 배열
		//정수는 java.lang.Integer 클래스로 표현 가능
		int [] ar = {30, 60, 90, 20};
		//Arrays 의 sort 메소드가 정렬을 해 줌
		//배열만 대입하는 경우에는 데이터가 Comparable
		//인터페이스를 implements 한 경우만 가능
		Arrays.sort(ar);
		//결과 확인
		for(int temp : ar) {
			System.out.printf(temp + "\t");
		}
		System.out.printf("\n");
		
		String [] br = {
			"박정아", "배유나", "문정원", "염혜선",
			"황민경", "고예림", "김희진"};
		//String 은 Comparable을 implements 했으므로
		//정렬 가능
		Arrays.sort(br);
		for(String temp : br) {
			System.out.printf(temp + "\t");
		}
		System.out.printf("\n");
		

	}

}
