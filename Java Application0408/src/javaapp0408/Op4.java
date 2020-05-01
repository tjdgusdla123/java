package javaapp0408;

public class Op4 {

	public static void main(String[] args) {
		String msg = "Java";
		//msg 와 Java를 저장한 공간이 같은지 확인
		System.out.println(msg == "Java");
		//msg에 저장된 내용과 Java의 내용이 같은지 확인
		System.out.println(msg.equals("Java"));
		
		java.util.Scanner sc = 
			new java.util.Scanner(System.in);
		String name = sc.nextLine();
		System.out.println(name);
		System.out.println(name == "Java");
		System.out.println(name.equals("Java"));
		
		

	}

}
