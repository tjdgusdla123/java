package datashare;

public class Child {
	public String childVar;
	
	//외부에서 데이터를 받고자 하는 경우에는
	//데이터를 대입받을 변수를 생성
	public String data;
	//생성자를 이용해서 데이터를 주입받기
	public Child(String data) {
		this.data = data;
	}
	public void disp() {
		System.out.println(
			"자식의 데이터:" + childVar);
		System.out.println(
			"부모의 데이터:" + data);
	}
}
