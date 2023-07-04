package ex01;

import java.util.Scanner;

public class Address {
	public static void run() {

		Student[] students = new Student[5];
		Scanner s = new Scanner(System.in);
		int count = 0;
		boolean run = true;
		while (run) {
			System.out.println("---------------------------------------");
			System.out.println("1.주소등록 2.주소목록 3.주소검색 4.주소수정 0.종료");
			System.out.println("---------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();
			switch (menu) {
			case "0":
				System.out.println("시스템 종료");
				run = false;
				break;
			case "1":
				Student student = new Student();
				student.setSno("2023" + (count + 1));
				System.out.println("학번>" + student.getSno());
				System.out.print("이름> ");
				student.setSname(s.nextLine());
				System.out.print("주소> ");
				student.setAddress(s.nextLine());
				students[count] = student;
				count++;
				System.out.println(count + "명 학생등록");
				break;
			case "2":
				for (int i = 0; i < count; i++) {
					Student stu = students[i];
					System.out.println(stu.toString());
				}
				break;
			case "3":
				System.out.print("검색할이름 입력> ");
				String search = s.nextLine();
				boolean find = false;
				for (int i = 0; i < count; i++) {
					// 변수선언할때는 항상 타입이 앞에 붙어야한다.
					Student stu = students[i];
					if (search.equals(stu.getSname())) {
						System.out.println(stu.toString());
						find = true;
						break;
					}
				}
				if (find == false)
					System.out.println(search + "학생이 존재하지 않습니다.");
				break;

			case "4": // 수정
				System.out.print("수정할이름 입력> ");
				String update = s.nextLine();
				find = false;
				for (int i = 0; i < count; i++) {
					Student stu = students[i];
					if (update.equals(stu.getSname())) {
						System.out.println(stu.toString());
						find = true;
						System.out.println("이름:" + stu.getSname());
						System.out.println("현재주소:" + stu.getAddress());
						System.out.print("새로운주소> ");
						String newAddress = s.nextLine();
						if (newAddress != "") {
							stu.setAddress(newAddress);
							System.out.println("새로운 주소로 변경되었습니다.");
						}
						break;
					}
				}
				if (find == false)
					System.out.println(update + "학생이 존재하지 않습니다.");
				break;

			default:
				System.out.println("다시입력");

				// curd 작업만 하면 끝이라는데.
				// create
				// update
				// read
				// delete
				// collection은 arraylist라고 한다.
				// 프로그램을 해석할때는 위에서 아래로 그냥 중얼주얼거리면서 내려가라

			}// switch

		} // while
	}// run
}