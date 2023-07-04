package day10;

public class Fruits {
	String name;
	String color;
	boolean isSeed;
	
	//오버로딩 오버라이딩 차이점을 물어봄.
	//오버로딩이란?
	//이름은 같지만 시그니처(파라미터, 타입을 중복으로 선언하는것을 의미)
	//오버라이딩이란?
	//부모 클래스의 메소드의 동작 방법을 변경(재정의)하여 우선적으로 사용하는 것이다.ㅣ
	
	//생성자의 특징 1.클래스이름과 동일
	//생성자의 특징 2.리턴타입이 없다.
	//[생성자 선언방식]
	//접근제한자 생성자명([매개변수]){
	//		실행문구(보통의 경우 필드값을 초기화)
	//}
	
	
	public Fruits() {
		System.out.println("첫번째 생성자");
	}
	public Fruits(String name) {
		this.name = name;
		System.out.println("두번째 생성자");
	}
	public Fruits(String name,String color) {
		System.out.println("세번째 생성자");
		this.name = name;
		this.color =color;
		
	}
	public Fruits(String name, String color, boolean isSeed) {
		System.out.println("네번째 생성자");
		this.name = name;
		this.color = color;
		this.isSeed = isSeed;
	}
	public void print() {
		System.out.printf("%s %s %b\n",name,color,isSeed);
	}
		
		
	
	
	
	
}
