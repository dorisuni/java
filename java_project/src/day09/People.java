package day09;

public class People {
	
	private String name; //이름
	private int age; // 나이
	
	public People() {
		
	}
	
	public People(String name,int age) {
		this.name = name;
		this.age = age;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void print() {
		System.out.println();
		System.out.printf("%s의 나이는 %d 살입니다.\n",name,age);
	}
	public void ageUp() {
		age+=1;
	}
	public void ageUp1(int age) {
		this.age+=age;
	}
	
	public int koreanAge() {
		return age-2;
	}
	
//	//생성자
//	
//	//기본생성자
//	public People() {
//		
//	}
//	//전체필드를 다 받는 생성자
//	public Peoole(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//	//모든 필드 get / set메서드   메서드는 리턴타입이 추가된다.
//	public void setName(String name) {
//		this.name = name;
//		
//	}
//	public String getName() {
//		return name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;
//	}
	//모든필드를 출력하는 print 메서드
	//메서드명:ageUP, 매개변수 없음, 리턴타입 없음, 실행문구는 age를 매개변수만큼 증가.
	
}
