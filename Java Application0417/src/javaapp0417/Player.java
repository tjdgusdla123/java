package javaapp0417;

public class Player {
	//이름, 소속팀, 연봉 을 저장할 프로퍼티 생성
	//인스턴스가 직접 핸들링 할 수 없도록 private으로 생성
	private String name;
	private String team;
	private int salary;
	
	//전체 제목으로 사용할 변수를 생성
	//전체가 공통된 이름을 사용하기 때문에 static
	//변경할 수 없도록 final
	private static final String title =
			"프로야구 선수 명단";

	//프로퍼티를 private 으로 만들어서
	//인스턴스가 사용할 수 없기 때문에 
	//인스턴스가 사용할 수 있도록 접근자 메소드를 생성
	//접근자 메소드 - getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static String getTitle() {
		return title;
	}
	
	//이름, 팀이름, 연봉을 받아서 set 하는 메소드
	public void setProperty(
		String name, String team, int salary) {
		//메소드의 매개변수가 name, team, salary
		//프로퍼티 이름도 name, team, salary
		//메소드 안에서 만든 지역변수가 아닌
		//프로퍼티를 가져올 때는 this.을 붙여서 가져오면 됩니다.
		//this를 생략하면 메소드 안에서 찾고 
		//없으면 프로퍼티로 갑니다.
		this.name = name;
		this.team = team;
		this.salary = salary;
	}
	
	//이름과 연봉만 입력받고 팀은 FA로 설정하는 메소드
	//위에 String, String, int를 매개변수로 하는
	//setProperty가 이미 존재
	//String, int를 매개변수로 받는 setProperty
	//이런 경우를 MethodOverloading이라고 합니다.
	public void setProperty(
			String name, int salary) {
		this.name = name;
		this.salary = salary;
		this.team = "FA";
		
	}
	
	//이름과 소속팀 그리고 연봉을 출력하는 메소드
	public void display() {
		System.out.println("이름:" + name + 
			" 소속팀:" + team + " 연봉(단위-만원):"
			+ salary);
	}
	
	
	
}
