package javaapp0417;

public class PlayerMain {

	public static void main(String[] args) {
		//Player 클래스의 인스턴스 만들기
		Player p1 = new Player();
		//프로퍼티에 데이터 저장
		p1.setName("양현종");
		p1.setTeam("KIA");
		p1.setSalary(230000);
		
		//새로운 인스턴스를 만들고 데이터 저장
		Player p2 = new Player();
		p2.setName("박병호");
		p2.setTeam("키움");
		p2.setSalary(180000);
		
		//p2의 salary를 가져와서 20000을 더한 후 
		//다시 설정
		//값을 설정할 때는 set, 가져올 때는 get
		int temp = p2.getSalary();
		p2.setSalary(temp + 20000);
		
		Player p3 = new Player();
		p3.setProperty("양의지", "NC", 200000);
		p3.display();
		
		Player p4 = new Player();
		p4.setProperty("노경은", 10000);
		p4.display();
		

	}

}
