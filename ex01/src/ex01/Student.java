package ex01;

public class Student {
	//필드
	private String sno;
	private String sname;
	private String address;
	private String dept = "컴정과";
	
	
	
	
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	//자바빈이라고 한다. 
	
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", address=" + address + ", dept=" + dept + "]";
	}
	
	
	public Student() {
		
	}
	
	
	public Student(String sno, String sname, String address) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.address = address;
	}
	
	//생성자 (생략가능하지만)
	
	
	
	
	//객체를 생성하는것이다.
	//object(instance)
	

	//메서드
	
	
	
	
	
	
	
	
	
	
	
	
	
}
