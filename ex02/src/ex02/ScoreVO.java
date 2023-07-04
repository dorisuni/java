package ex02;

public class ScoreVO { //성적관리를 위한 자바빈

	private String no;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	private String grade;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public int getTot() {
		return kor+eng+mat;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public double getAvg() {
		return avg;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void print_land() {
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n",no,name,kor,eng,mat,tot,avg,grade);
	}
	
	@Override
	public String toString() {
		return "ScoreVO [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ getTot() + ", avg=" + getAvg() + ", grade=" + grade + "]";
	}
	
	public ScoreVO() {
		
	}
	public ScoreVO(String no, String name, int kor, int eng, int mat) {
		super(); //상위 위의것을 얘기하는것, 없어도됨.
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	public void print_port() {//세로출력
		System.out.println("학번: "+no);
		System.out.println("이름: "+name);
		System.out.println("국어: "+kor);
		System.out.println("영어: "+eng);
		System.out.println("수학: "+mat);
		System.out.println("총점: "+tot);
		System.out.printf("평균: %.2f\n",avg);
		System.out.println("학점: "+mat);

	}
	//세로출력은 검색 목록출력은 전체
	
	

}
