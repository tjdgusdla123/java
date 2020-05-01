package javaapp0424;

import java.util.Arrays;
import java.util.Comparator;

public class UserDataSorting {

	public static void main(String[] args) {
		//UserData 3개를 저장
		UserData [] ar = new UserData[3];
		
		UserData user1 = new UserData();
		user1.setName("문정원");
		user1.setAge(30);
		user1.setSalary(170000000);
		ar[0] = user1;
		
		ar[1] = new UserData();
		ar[1].setName("박정아");
		ar[1].setAge(31);
		ar[1].setSalary(580000000);

		ar[2] = new UserData();
		ar[2].setName("전새얀");
		ar[2].setAge(27);
		ar[2].setSalary(70000000);
		
		//정렬 - 예외 발생
		//ar은 UserData의 배열이고 UserData는
		//Comparable 인터페이스가 implements 되지 않아서
		//크기 비교하는 방법을 알지 못하기 때문입니다.
		
		//Arrays.sort(ar);
		
		Comparator<UserData> comp1 = new Comparator(){
			@Override
			public int compare(Object o1, Object o2){
				UserData o3 = (UserData)o1;
				UserData o4 = (UserData)o2;
				return o4.getName().compareTo(
						o3.getName());
			}
		};
		Arrays.sort(ar, comp1);
		
		//배열의 데이터 전부 출력
		for(UserData temp : ar) {
			System.out.println(temp);
		}
	}

}




