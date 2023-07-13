package ex10;

import java.util.Scanner;

public class Enrol {
	public static void run() {
		Scanner s = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("\n\n******* 수강신청관리 ****************");
			System.out.println("----------------------------------");
			System.out.println("|1.수강목록|2.수강조회|3.수강신청|4.성적등록|0.메인메뉴|");
			System.out.println("----------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;
				
				
			case "1":
				break;
				
			case "2":
				break;
				
			case "3":
				break;
				
			case "4":
				break;	
				
				
				
				
				

			default:
				System.out.println("올바른 번호를 입력해 주세요.");

			}
		}
	}
}