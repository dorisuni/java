package day10;

public class Student {
	private String no; //학번
	private String name; // 이름
	private String dept;// 학과
	int year; // 학년
	
	public Student() {
		
	}
	
	public Student(String no,String name,String dept,int year) {
		this.no = no;
		this.name = name;
		this.dept = dept;
		this.year = year;
		
		}
	public void setNo(String no) {
		this.no = no;
	}
	public String getNo() {
		return no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDept(String Dept) {
		this.dept = dept;
	}
	public String getDept() {
		return dept;
	}
	
	public void setYear(int year) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void print() {
		System.out.printf("%s\t%s\t%s\t%d\n",no,name,dept,year);
	}
	
	public void search() {
		
	}
	
}
