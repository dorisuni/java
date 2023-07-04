package ex01;

import java.util.*;

public class Address1 {
	public static void run() {
		Scanner s = new Scanner(System.in);
		List<Student> array = new ArrayList<>();
		Student stu = new Student("20231", "홍길동", "인천 서구 경서동");
		array.add(stu);
		// 이름이 같은 생성자가 여러번 쓰이는게 오버로딩
		stu = new Student("20232", "심청이", "인천 부평구 계산동");
		array.add(stu);
		stu = new Student("20233", "장길산", "인천 서구 경서동");
		array.add(stu);

		boolean run = true;

		// 아무것도 안생성된 어레이리스트.
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.주소등록 2.주소목록 3.주소검색 4.주소수정 5.주소삭제 0.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			String menu = s.nextLine();
			switch (menu) {
			case "0":
				run = false;
				System.out.println("프로그램 종료");
				break;
			case "1":
				stu = new Student();
				stu.setSno("2023" + (array.size() + 1));
				System.out.println("학번>" + stu.getSno());
				System.out.print("이름>");
				stu.setSname(s.nextLine());
				System.out.print("주소>");
				stu.setAddress(s.nextLine());
				array.add(stu);
				// 인덱스 지정해줄 필요 없음. 바구니이기 떄문에.
				System.out.println(array.size() + "명 등록완료!");
				break;
			case "2":
				for (Student st : array) {
					System.out.println(st.toString());
				}
				break;
			case "3":
				boolean find = false;

				System.out.println("검색할이름>");
				String search = s.nextLine();
				for (Student st : array) {
					if (st.getSname().equals(search)) {
						// 찾았을때
						System.out.println(st.toString());
						find = true;
					}
				}

				if (!find) {
					System.out.println("학생을 찾지 못했어요.");
				}

				break;
			case "4":
				System.out.print("수정할이름>");
				String update = s.nextLine();
				for (Student st : array) {
					if (update.equals(st.getSname())) {
						find = true;
						System.out.println("이름" + st.getSname());
						System.out.println("주소" + st.getAddress());

					}
				}
			case "5":
				find = false;
				System.out.print("삭제할이름>");
				String delete = s.nextLine();
				for (Student st : array) {
					if (delete.equals(st.getSname())) {
						find = true;
						array.remove(st);
						System.out.println("삭제가 완료되었습니다.");
						break;
						//리무브를 하면 어레이사이즈가 달라져서 포문이 안돌아감. 그래서 브레이크로 빠져나가야되는거임.
					}
				}if(!find) {
					System.out.println("학생을 찾지 못했어요.");
				}

				break;

			default:
				System.out.println("다시선택하세요.");
			}// switch

		} // while
	}// run
}// class
