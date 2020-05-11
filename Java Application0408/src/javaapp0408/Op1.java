package javaapp0408;

public class Op1 {

	public static void main(String[] args) {
		int a = 10;
		a++; //현재 a의 데이터는 11
		++a; //현재 a의 데이터는 12

		System.out.println(a++); //++가 뒤에 있어서
		//System.out.println(a); a = a + 1; 의 의미로 해석
		//12가 출력되고 a의 값은 13이 됩니다.

		System.out.println(++a); //++가 앞에 있어서
		//a = a + 1; System.out.println(a); 의 의미로 해석
		//a를 14로 만들고 출력을 하기 때문에 화면에는 14가 출력됩니다.
	
		a = 0;
		//int result = ++a + ++a;
		int temp1 = a++;
		int temp2 = a++;
		int result = temp1 + temp2;
		System.out.println("result:" + temp2);
		//결과는 3
		//a의 값을 먼저 증가시켜서 1 + 
		//하나를 증가시켜서 1 + 2
	}

}
