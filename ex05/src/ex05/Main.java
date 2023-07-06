package ex05;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();

		Scanner scanner = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("\n\n******* 학생관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.입력 |2.조회 |3.목록 |4.수정 |5.삭제 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu = scanner.nextLine();
			switch (menu) {
				case "0":
					run = false;
					System.out.println("프로그램을 종료합니다.");
					break;
				case "1":
					StudentVO stu = new StudentVO();
					stu.setSno(dao.getNo());
					System.out.println("학번>" + stu.getSno());
					System.out.print("이름>");
					stu.setSname(scanner.nextLine());
					stu.setDept("컴정");
					System.out.println("학과> " + stu.getDept());
					// 빨간줄 안나오는 이유는 위에 전부 선언되어있어서.
					stu.setBirthday("2000-01-02");
					System.out.println("생일>" + stu.getBirthday());
					// System.out.println(stu.toString());
					dao.insert(stu);
					System.out.println(stu.getSname()+"학생이 등록되었습니다.");
					break;
				case "2":
					System.out.println("조회할 학번을 입력하세요.");
					String sno = scanner.nextLine();
					StudentVO stu2 = dao.read(sno);
					if(stu2.getSname()==null){
						System.out.println(sno+"번 학생이 존재하지 않습니다.");

					}else{
						System.out.println("이름>"+stu2.getSname());
						System.out.println("학과>"+stu2.getDept());
						System.out.println("생일>"+stu2.getBirthday());
						System.out.println("학년>"+stu2.getYear());
					}
					break;
				case "3": // 목록
					for (StudentVO vo : dao.list()) {
						System.out.printf("%s\t%s\t%s\t%s\t%d\n",
								vo.getSno(),
								vo.getSname(),
								vo.getDept(),
								vo.getBirthday(),
								vo.getYear());
					}
					break;
				case "4": //수정
					System.out.println("수정할학번>");
					String uno = scanner.nextLine();
					StudentVO stu4 = dao.read(uno);
					if (stu4.getSname()==null){
						System.out.println(uno+"번 학생이 존재하지 않습니다.");
					}else{
						System.out.print("이름:"+stu4.getSname()+">");
						String newSname =scanner.nextLine();
						if (newSname!="") stu4.setSname(newSname);

						System.out.print("학과:"+stu4.getDept()+">");
						String newDept =scanner.nextLine();
						if (newDept!="") stu4.setDept(newDept);

						stu4.setBirthday(stu4.getBirthday().substring(0, 10));
						System.out.print("생일:"+stu4.getBirthday()+">");
						String newBirthday = scanner.nextLine();
						if (newBirthday!="") stu4.setBirthday(newBirthday);
						System.out.print("학년:"+stu4.getYear()+">");
						String newYear = scanner.nextLine();
						if (newYear!="") stu4.setYear(Integer.parseInt(newYear));

						System.out.println(stu4.toString());
						System.out.println("수정하실래요(Y/y)");
						String sel1 = scanner.nextLine();
						if(sel1.equals("Y")||sel1.equals("y")||sel1.equals("ㅛ")){
							dao.update(stu4);
							System.out.println("수정완료!");
						}
					}
					break;
				case "5"://삭제
					System.out.print("삭제할학번>") ;
					String dno = scanner.nextLine();
					StudentVO stu3 = dao.read(dno);
					if (stu3.getSname()==null){
						System.out.println(dno + "번 학생이 존재하지 않습니다.");
					}else{
						System.out.println(stu3.toString());
						System.out.print("삭제하실래요?(Y/y)");
						String sel = scanner.nextLine();
						if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")){
							dao.delete(dno);
							System.out.println("삭제완료!");
						}
					}
						


					break;
				default:
					System.out.println("메뉴를 다시선택하세요!");
			}// switch
		} // while
	}// main
}// main
