package test0430;

public class ArrayClass0430 {
      private int  Num;
      private String Name;
      private String Phone;
      private String Area;
	public ArrayClass0430() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayClass0430(int num, String name, String phone, String area) {
		super();
		Num = num;
		Name = name;
		Phone = phone;
		Area = area;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	@Override
	public String toString() {
		return "ArrayClass0430 [Num=" + Num + ", Name=" + Name + ", Phone=" + Phone + ", Area=" + Area + "]";
	}
      
      
}