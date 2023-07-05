package ex04;

import java.util.*;

public class Juso {
	public static void run() {
		boolean run = true;
		List<Student> array = new ArrayList<Student>();
		Student stu = new Student(10,"홍길동","인천","010-1010-1010");
		array.add(stu);
		stu = new Student(11,"장길산","인천","010-1010-1011");
		array.add(stu);
		stu = new Student(12,"심청이","인천","010-1010-1012");
		array.add(stu);
		Scanner scanner = new Scanner(System.in);

		
		
		while (run) {
			System.out.println("\n--------------------------------------------");
			System.out.println("1.등록 |2.목록 |3.목록 |4.수정 |5.삭제 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("메뉴선택>");//string 변수 선언
			String menu = scanner.nextLine();
			switch(menu) {
			
			case "0":
				System.out.println("프로그램 종료!");
				run=false;
				break;
				
			case "1":
				break;
				
			case "2":
				for (Student vo :array) {
					System.out.printf("%d\t%s\t%s\t%s\n",vo.getNo(),vo.getName(),vo.getJuso(),vo.getPhone());
				}
				
				
				break;
				
			case "3":
				break;
				
			case "4":
				break;
				
			case "5":
				break;
				
			default:
				System.out.println("다시선택");
			}
			
			
			
			
			
		}
	}
}