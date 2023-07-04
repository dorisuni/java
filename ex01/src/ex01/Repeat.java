package ex01;

import java.util.Scanner;

public class Repeat {

	public static void run() {
		//반복문 (while,for)
		//무한반복할때 많이 사용한다.
		
		boolean run = true;
		while(run) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("1)100까지합 | 2)100까지 짝수합 | 3)100까지 홀수합 | 0)종료");
		System.out.println("-------------------------------------------------");
		System.out.print("선택>");
		String menu = s.nextLine();
		int sum = 0;
		int sum2 = 0;
		int sum3 = 0;
		switch(menu) {
		case "0":
			System.out.println("프로그램이 종료됩니다!");
			run = false;
			break;
		case "1":
			for(int i = 1;i<=100;i++) {
				sum+=i;
			}System.out.println("1~100까지합계:"+sum);
			break;
		case "2":
			for(int i=2;i<=100;i=i+2) sum2+=i;
			System.out.println("100까지짝수합: "+sum2);
			break;
		case "3":
			for(int i=1;i<=100;i=i+2) sum3+=i;
			System.out.println("100까지홀수합" + sum3);
			break;
		default:
			System.out.println("메뉴를 다시 입력하세요!");
			
			
			
		}
		
		
		
		}
		
		
		
		
	}//run
	
}//class
