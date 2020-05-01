package javaapp0427;

import java.util.ArrayList;
import java.util.Comparator;

public class UserDefineClassListSortMain {

	public static void main(String[] args) {
		//Data 여러 개 저장하는 ArrayList를 생성
		ArrayList<Data> list = 
				new ArrayList<>();
		//데이터 추가
		list.add(new Data(
			1, "문정원", "013", "광주","moon","920324"));
		list.add(new Data(
			2, "배유나", "011", "안산","bae","891130"));
		list.add(new Data(
			3, "고예림", "011", "인천","go","940612"));
		list.add(new Data(
			4, "염혜선", "014", "목포","yhs","910203"));
		
		list.sort(new Comparator<Data>() {
			@Override
			//phone의 오름차순으로 정렬하고
			//phone이 같으면 이름의 오름차순 정렬
			public int compare(Data o1, Data o2) {
				if(o1.getPhone().compareTo(o2.getPhone()) == 0) {
					return o1.getName().compareTo(o2.getName());
				}else {
					return o1.getPhone().compareTo(o2.getPhone());
				}
			}
		});
		
		//데이터 출력
		for(Data data : list) {
			System.out.println(data);
		}
		
		
		
	}

}
