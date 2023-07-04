package day10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Member> list = new ArrayList<Member>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss");
		
		while(true) {
			System.out.println("=====멤버관리=====");
			System.out.println("1.멤버등록 2.멤버리스트 3.검색 4.멤버수정 5.멤버삭제 0.종료");
			System.out.print("메뉴선택> ");
			int menu = sc.nextInt();
			
			if(menu == 1) {
				System.out.print("이메일> ");
				String email = sc.next();
				System.out.print("비밀번호> ");
				String pw = sc.next();
				System.out.print("이름> ");
				String name = sc.next();
				String joinDate = dtf.format(LocalDate.now());
				Member m = new Member(email,pw,name,joinDate);
				list.add(m);
				System.out.println(name+"님 멤버가입을 축하드립니다");
			}else if(menu == 2) {
				System.out.println("이메일\t비밀번호\t이름\t가입날짜");
				System.out.println("===================================");
				for(int i=0; i<list.size(); i++) {
					list.get(i).print();
				}
			}else if(menu == 3) {
				System.out.print("검색할 이메일> ");
				String sEmail = sc.next();
				
			}else if(menu == 4) {
				
			}else if(menu == 5) {
				
			}else if(menu == 0) {
				break;
			}else {
				System.out.println("다시입력");
			}
			System.out.println();
		}
		System.out.println("프로그램종료");
	}

}


