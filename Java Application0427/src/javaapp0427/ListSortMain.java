package javaapp0427;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortMain {

	public static void main(String[] args) {
		//정수 데이터를 저장할 수 있는 ArrayList 생성
		ArrayList<Integer> list =
				new ArrayList<>();
		list.add(40);
		list.add(20);
		list.add(50);
		list.add(10);
		list.add(30);
		
		//데이터를 오름차순 정렬
		list.sort(new Comparator<Integer>() {
			@Override
			//숫자 데이터의 경우는 앞의 데이터에서 뒤의 데이터를
			//뺄셈한 결과를 리턴하면 오름차순 정렬
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		//결과 확인
		System.out.println(list);
		
		//문자열을 저장하는 ArrayList를 생성
		ArrayList<String> strList = 
			new ArrayList<>();
		
		//데이터를 추가
		strList.add("Pascal");
		strList.add("C");
		strList.add("C++");
		strList.add("Java");
		strList.add("Cobol");
		strList.add("VisualBasic");
		strList.add("Delphi");
		strList.add("PowerBuilder");
		strList.add("VisualC++");
		strList.add("VisualC#");
		strList.add("Python");
		strList.add("R");
		strList.add("JavaScript");
		strList.add("Kotlin");
		strList.add("Scala");
		strList.add("Objective-C");
		strList.add("Swift");
		strList.add("Closure");
		strList.add("Haskell");
		strList.add("Ruby");
		strList.add("Fortran");
		strList.add("씨앗");
		strList.add("Assembly");
		strList.add("MachineLanguage");
		//데이터를 내림차순 정렬
		strList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//String 과 Date는 compareTo 메소드를 이용해서
				//크기 비교 수행
				//앞의 데이터를 기준으로 비교:오름차순
				//뒤의 데이터를 기준으로 비교:내림차순
				//알고리즘에서는 비교하는 부등호의 방향을 반대로
				return o2.compareTo(o1);
			}
		});
		//전체 데이터를 확인
		System.out.println(strList);
		
	}
}










