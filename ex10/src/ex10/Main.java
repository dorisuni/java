package ex10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("\n\n******* 메인메뉴 ****************");
			System.out.println("----------------------------------");
			System.out.println("|1.학생관리|2.강좌관리|3.수강신청관리|0.종료|");
			System.out.println("----------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("프로그램 종료!");
				run = false;
				break;

			case "1":
				Student.run();
				break;

			case "2":
				Course.run();
				break;

			case "3":
				Enrol.run();
				break;

			default:
				System.out.println("올바른 번호를 입력해 주세요.");

			}// switch

		} // while

	}// main
}// Main