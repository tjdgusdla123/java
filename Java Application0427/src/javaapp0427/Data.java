package javaapp0427;

//번호, 이름, 전화번호, 주소, 이메일, 생년월일 정보를 갖는 클래스
//번호를 제외하고는 전부 문자열
//번호는 정수
public class Data {
	//각 속성을 저장할 프로퍼티
	private int num;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String birthday;
	
	//인스턴스 생성을 하기 위한 생성자
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Data(int num, String name, String phone, String address, String email, String birthday) {
		super();
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.birthday = birthday;
	}

	//프로퍼티에 접근하기 위한 접근자 메소드
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	//디버깅을 위한 toString 메소드
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
}



