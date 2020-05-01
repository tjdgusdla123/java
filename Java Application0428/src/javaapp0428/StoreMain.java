package javaapp0428;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class StoreMain {

	public static void main(String[] args) {
		//테이블 형태의 데이터 생성
		ArrayList<Store> list = 
			new ArrayList<>();
		list.add(
			new Store("1", "화선", 4.4, 10000, "짬뽕"));
		list.add(
			new Store("2", "초밥한잎", 3.7, 10000, "스시"));
		list.add(
			new Store("3", "김밥나라", 4.2, 12000, "라면"));
		
		//데이터 출력하기
		System.out.println(
			"코드\t이름\t평점\t최소주문금액\t메뉴");
		for(Store store : list) {
			System.out.println(
				store.getCode()+"\t"+
				store.getName()+"\t"+
				store.getGrade()+"\t"+
				store.getMinOrederMoney()+"\t"+
				store.getMenu());
		}
		
		ArrayList<LinkedHashMap<String,Object>>
			stores = new ArrayList<>();
		
		LinkedHashMap<String, Object> store1 = 
			new LinkedHashMap<>();
		store1.put("code", "1");
		store1.put("name", "화선");
		store1.put("grade", 4.4);
		store1.put("minordermoney", 10000);
		store1.put("menu", "짬뽕");
		stores.add(store1);
		
		for(LinkedHashMap<String, Object> map : stores) {
			Set<String>keys = map.keySet();
			for(String key : keys) {
				System.out.print(map.get(key) + "\t");
			}
		}
		
		

	}

}



