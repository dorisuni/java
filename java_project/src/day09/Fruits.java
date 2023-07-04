package day09;

public class Fruits {
	
	//필드(인스턴스 변수)
	
	String name;
	String color;
	boolean isSeed;
	
	
	
	//생성자 - 객체를 생성할 때 사용하는 것
	//아래것은 기본생성자인데, 아무것도 없으면 기본생성된다.
	//특징 1. 클래스 이름과 동일
	// 2.리턴타입이 없다. 
	//다른생성자가 없으면 생성되지 않는다.
	
	public Fruits() {
		
	}
	//생성자인데 값 세팅할라고 쓰는거임. 
	//코드줄이려고 쓰거나 
	//오버로딩 - 매개변수를 다르게 해서 동일한 이름을 가질 수 있는것.
	//오버로딩 하는 이유 ->매개변수가 들어가야만 확인할 수 있는 조건이 있다.
	//두번째 생성자 사용하여 melon 객체 생성 
	//세번째 생성자 사용하여 orange 객체 생성
	
	public Fruits(String name) {
		this.name = name;
	}
	
	public Fruits(String name,String color) {
		this.name = name;
		this.color = color;
	}
	
	public Fruits(String name,String color, boolean isSeed) {
		this.name = name;
		this.color = color;
		this.isSeed = isSeed;
	}
	
	
	//메서드
	public void print() {
		System.out.println(name+"\t"+color+"\t"+isSeed);
	}
	
	
}
