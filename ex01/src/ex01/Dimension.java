package ex01;

import java.util.Scanner;

public class Dimension {

	public static void run() {
		Scanner s = new Scanner(System.in);

		String[] name = new String[22];
		String[] address = new String[22];
		int index = 0;
		boolean run = true;
		while (run) {
			System.out.println("-----------------------");
			System.out.println("1.주소등록 2.주소목록 0.종료");
			System.out.println("-----------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();
			switch (menu) {
			case "0":
				System.out.println("시스템 종료");
				run = false;
				break;
			case "1":
				System.out.print("이름입력> ");
				name[index] = s.nextLine();
				System.out.print("주소입력> ");
				address[index] = s.nextLine();
				index++;
				System.out.println(index +"명 입력완료.");
				break;
			case "2":
				for(int i = 0; i<index;i++) {
					System.out.printf("%d\t%s\t%s\n",i+1,name[i],address[i]);
				}
				break;
			default:
				System.out.println("다시입력");
			}
		}
	}
}
