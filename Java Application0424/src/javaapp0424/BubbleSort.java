package javaapp0424;

public class BubbleSort {

	public static void main(String[] args) {
		int [] ar = {76, 65, 87, 99, 45, 23};
		//size : 데이터 개수 - ar.length
		int size = ar.length;
		//회전수 - 최대 데이터개수-1 회전
		for(int i=0; i<size-1; i=i+1) {
			//자리변화 체크를 위한 변수를 생성
			boolean flag = false;
			//첫번째 부터 n-1번째 까지 1개씩 줄이면서
			for(int j=0; j<size-i-1; j=j+1) {
				//현재 위치의 데이터와 다음 위치의 데이터를 비교해서
				//다음 데이터가 더 작으면 2개의 데이터의 값을 교체
				if(ar[j] > ar[j+1]) {
					int temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
					flag = true;
				}
			}
			if(flag == false) {
				break;
			}
		}
		
		for(int temp : ar) {
			System.out.printf(temp + "\t");
		}

	}

}
