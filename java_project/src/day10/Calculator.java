package day10;

public class Calculator {
	
	int num1;
	int num2;
	
	//[메서드	형식]
	//접근제한자 리턴타입 메서드명([매개변수])
	//실행문구
	
	//메서드명 sun, 리턴타입 x, 매개변수 x 실행변수 필드 num1+num2출력
	//메서드명 sub, 리턴타입 x 매개변수 정수두개 실행문구 매개변수로 받은 두 숫자 출력
	// 메서드명: mul, 리턴타입: o, 매개변수: x, 실행문구: 필드 num1*num2 리턴
	//메서드명: div , 리턴타입 o 매개변수 정수두개, 실행문구 매개변수로 받은 두개의 나눈값 리턴
	
	public void sum() {
		System.out.println(num1+num2);
	}
	
	public void sub(int num1, int num2) {
		System.out.println(this.num1-this.num2);
	}
	public int mul() {
		return num1*num2;
	}
	public double div(int num1 , int num2) {
		return this.num1 / (double)this.num2;
	}
}
