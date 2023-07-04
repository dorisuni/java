package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StuduntMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Student> list = new ArrayList<Student>();
		int cnt = 0;
		while(true) {
			System.out.println("=====학사관리시스템=====");
			System.out.println("1.학생등록 2.학생리스트 3.학생검색 0.종료");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.print("학번입력> ");
				String no = sc.next();
				System.out.print("이름입력> ");
				String name = sc.next();
				System.out.print("학과입력> ");
				String dept = sc.next();
				System.out.print("학년입력> ");
				int year = sc.nextInt();
				Student s = new Student(no,name,dept,year);
				list.add(cnt,s);
				cnt++;
				
			}else if (menu == 2) {
				System.out.println("학번\t이름\t학과\t학년");
				System.out.println("============================");
				for (int i=0;i<list.size();i++) {
					list.get(i).print();
				}
			}else if (menu == 3) {
				System.out.print("학생을 검색합니다. \t 검색할 학생의 학번을 입력해 주세요.\n");
				String searchNo = sc.next();
				boolean search = false;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getNo().equals(searchNo)) {
						list.get(i).print();
						System.out.println("학생을 찾았습니다.");
						search = true;
						break;
					}
				}
				if(!search) {
						System.out.println("학생을 찾을 수 없습니다.");
				
				}
				
				
			}else if (menu == 0) {
				System.out.println("종료합니다.");
				break;
			}else {
				System.out.println("0~3까지 번호를 입력해 주세요.");
			}
			
			
		System.out.println();	
		}
		
		
////		list.add("안녕"); // 이게 안된다는거임 안녕은 String 인데 이 list에는  Student객체만 들어갈 수 있음
//		Student a = new Student();
//		a.setName("홍길동");
//		list.add(0, a);
//		Student b = new Student();
//		b.setName("이순신");
//		list.add(b);
////		System.out.println(list.get(0).getName());
//		
//		Student c = new Student("13125","김철수","컴퓨터과학과",1);
//		list.add(c);
//		System.out.println(list.size());
//		
//		System.out.println(list.get(2).getName());
//		
//		a.setName("장길산");  //객체명을 찾아 넣어도 되고
//		System.out.println(list.get(0).getName());
//
//		
//		list.get(0).setName("이순신"); //리스트의 0번째 인덱스의 객체 안 내용을 이렇게 변경해도 되고
//		System.out.println(list.get(0).getName());
//		

	}
}
