package javaapp0417;

public class MemberMain {

	public static void main(String[] args) {
		Member mem1 = new Member();
		System.out.println(mem1.getId());
		
		Member mem2 = new Member();
		mem2.setId("itggangpae");
		mem2.setPw("12345");
		mem2.setName("관리자");
		
		//매개변수가 있는 생성자를 호출해서 인스턴스를 생성
		Member mem3 = new Member(
			"park","0000","운영자");
		

	}

}
