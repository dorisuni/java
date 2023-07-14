package ex10;

import java.text.*;
import java.util.List;
import java.util.Scanner;

public class Student {
	public static void run() {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		StudentDAO sdao = new StudentDAO();
		EnrolDAO edao = new EnrolDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		while (run) {
			System.out.println("\n\n******* 학생관리 ****************");
			System.out.println("----------------------------------");
			System.out.println("|1.학생목록|2.학생조회|3.학생등록|0.메인메뉴|");
			System.out.println("----------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("메인메뉴로 돌아갑니다.");
				run = false;
				break;

			case "1":
				System.out.println("=========학생목록출력=========");
				System.out.println("학번\t이름\t학과");
				for (StudentVO vo : sdao.list()) {
					System.out.printf("%s\t%s\t%s\n", vo.getScode(), vo.getSname(), vo.getDept());
				}
				System.out.println("---------------------------");
				System.out.println(sdao.list().size() + "명 등록되었습니다.");
				break;

			case "2":

				while (true) {
					System.out.print("조회할학번>");
					String scode = s.nextLine();
					if (scode == "") {
						System.out.println("조회를 취소합니다.");
						break;
					} else {
						StudentVO vo = sdao.read(scode);
						if (vo.getScode() == null) {
							System.out.println("학생이 존재하지 않습니다.");
						} else {
							System.out.println("학생이름:" + vo.getSname());
							System.out.println("학생학과:" + vo.getDept());
							System.out.println("-----------------------------");
							// 수강신청한 강좌목록
							List<EnrolVO> carray = edao.clist(scode);
							if (carray.size() == 0) {
								System.out.println("수강신청내역이 없습니다.");
							} else {
								for (EnrolVO v : carray) {
									System.out.printf("%s\t%-20s\t%d\t%s\n", v.getCcode(), v.getCname(), v.getGrade(),
											sdf.format(v.getEdate()));
								}
							}
						}

					}

				}
				break;

			case "3":
				StudentVO vo = new StudentVO();
				System.out.println("학번>" + sdao.getCode());

				System.out.print("이름을 입력하세요>");
				String sname = s.nextLine();
				if (sname == "") {
					System.out.println("등록을 취소합니다.");
				} else {
					System.out.print("학과를 입력하세요>");
					String sdept = s.nextLine();
					if (sdept == "") {
						System.out.println("등록을 취소합니다.");
					} else {
						vo.setScode(sdao.getCode());
						vo.setSname(sname);
						vo.setDept(sdept);
						sdao.insert(vo);
						System.out.println("새로운 학생이 등록되었습니다.");
					}
				}

				break;

			default:
				System.out.println("올바른 번호를 입력해 주세요.");

			}
		}
	}
}
