package inheritance3overriding;

//Employee 클래스를 상속받는 Manager 클래스
public class Manager extends Employee {
	//직급을 저장할 프로퍼티
	private String rank;
	
	public Manager() {
		super();
		//private 은 상속이 되더라도 하위 클래스에서 접근 안됨
		//auto_increment = auto_increment + 1;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	//문자열을 만들어서 리턴하는 메소드
	//Method Overriding
	public String resultStr() {
		//상위 클래스에 만든 resultStr()을 호출
		String result = super.resultStr();
		result = result + "직급:" + rank;
		return result;
	}
}
