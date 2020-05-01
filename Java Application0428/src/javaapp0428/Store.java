package javaapp0428;

//가게코드(문자열), 가게이름(문자열), 평점(실수)
//최소주문금액(정수), 메뉴(문자열)
public class Store {
	private String code;
	private String name;
	private double grade;
	private int minOrederMoney;
	private String menu;
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store(String code, String name, double grade, int minOrederMoney, String menu) {
		super();
		this.code = code;
		this.name = name;
		this.grade = grade;
		this.minOrederMoney = minOrederMoney;
		this.menu = menu;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getMinOrederMoney() {
		return minOrederMoney;
	}
	public void setMinOrederMoney(int minOrederMoney) {
		this.minOrederMoney = minOrederMoney;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "Store [code=" + code + ", name=" + name + ", grade=" + grade + ", minOrederMoney=" + minOrederMoney
				+ ", menu=" + menu + "]";
	}
	
	
}
