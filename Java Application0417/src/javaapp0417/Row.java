package javaapp0417;

//프로퍼티와 생성자 그리고 접근자 메소드 만들기
public class Row {
	//번호와 이름을 저장하기 위한 프로퍼티
	private int num;
	private String name;
	
	private static int sequence = 1;
	
	//생성자 - 매개변수가 없는 생성자와 매개변수가 있는 생성자
	public Row() {
		super();
		//static 변수의 값을 1씩 증가시켜서 대입하면 
		//일련번호가 됩니다.
		num = sequence;
		sequence = sequence + 1;
		// TODO Auto-generated constructor stub
	}
	public Row(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		num = sequence;
		sequence = sequence + 1;
	}
	
	//접근자 메소드
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
