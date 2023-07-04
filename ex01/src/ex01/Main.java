package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean run = true;
		// 아무것도 안생성된 어레이리스트.
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.타입 2.연산자 3.조건문 4.배열 5.주소관리 0.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();
			switch (menu) {
			case "0":
				run = false;
				System.out.println("프로그램 종료");
				break;
			case "1":
				TypeSample.run();
				break;
			case "2":
				Operation.run();
				break;	
			case "3":
				Condition.run();
				break;
			case "4":
				Dimension.run();
				break;
			case "5":
				Address1.run();
				break;	
				
				
//		Operation.run();
//		Condition.run();
//		Repeat.run();
//		TypeSample.run();		
//		Dimension.run();
//		Address.run();
//		Address1.run();
		
		
		
	}

}
}
}