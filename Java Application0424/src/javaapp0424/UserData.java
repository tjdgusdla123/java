package javaapp0424;

//이름, 나이, 연봉을 저장하는 클래스
//프로퍼티, constructor, getters&setters, toString
public class UserData {

	//저장 프로퍼티
	private String name;
	private int age;
	private int salary;
	
	//생성자
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	//접근자 메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	//디버깅을 위한 메소드
	@Override
	public String toString() {
		return "UserData [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}
