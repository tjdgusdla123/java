package javaapp0501;

import java.io.Serializable;

//영화코드(문자열),영화제목(문자열),영화평점(실수) 을 저장하는 클래스
public class DTO implements Serializable {

	private String code;
	private String title;
	private double grade;
	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTO(String code, String title, double grade) {
		super();
		this.code = code;
		this.title = title;
		this.grade = grade;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "DTO [code=" + code + ", title=" + title + ", grade=" + grade + "]";
	}

	
	

}