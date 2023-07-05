package ex04;

public class Student {
	//필드
	//메서드
	private int no;
	private String name;
	private String juso;
	private String phone;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJuso() {
		return juso;
	}
	public void setJuso(String juso) {
		this.juso = juso;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Student() {
		super();
	}
	public Student(int no, String name, String juso, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.juso = juso;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", juso=" + juso + ", phone=" + phone + "]";
	}
	
	public void print_line() {
		
	}
	
	
}
