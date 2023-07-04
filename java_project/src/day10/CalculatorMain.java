package day10;

import java.util.Scanner;

public class CalculatorMain {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		//객체생성 후 각 메서드 호출하여 값 출력하기
		
		Calculator a = new Calculator();
		Calculator b = new Calculator();
		a.num1 = 5;
		a.num2 = 10;
		
		b.num1 = 9;
		b.num2 = 4;
		b.sum();
		b.sub(7, 2);
		System.out.println(b.mul());
		System.out.println(b.div(10, 3));
		
		a.sub(a.num1,a.num2);
		System.out.println(a.mul());
		a.sum();
		System.out.println(a.num1);
		System.out.println(a.num2);
		System.out.println(a.div(a.num1, a.num2));
		
	}
}
