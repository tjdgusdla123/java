package test0430;

import java.util.Arrays;

public class ArrayMain {

	public static void main(String[] args) {
		ArrayClass0430[] data = new ArrayClass0430[3];
		data[0] = new ArrayClass0430();
		data[0].setNum(1);
		data[0].setName("임성현");
		data[0].setArea("은평구");
		data[0].setPhone("013-1221-3213");
		
		data[1] = new ArrayClass0430();
		data[1].setNum(2);
		data[1].setName("김동훈");
		data[1].setArea("서대문구");
		data[1].setPhone("012-1123-1148");
		
		data[2] = new ArrayClass0430();
		data[2].setNum(3);
		data[2].setName("강준희");
		data[2].setArea("서대문구");
		data[2].setPhone("011-3213-4214");

		
		for (ArrayClass0430 temp : data) {
			System.out.println(temp);
		}

	}
}
