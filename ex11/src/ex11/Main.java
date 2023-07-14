package ex11;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean run = true;
		CampDAO cdao = new CampDAO();
		while (run) {
			System.out.println("\n\n******* 캠핑장관리 ****************");
			System.out.println("----------------------------------");
			System.out.println("|1.캠핑장목록|2.캠핑장조회|3.캠핑장정보수정|0.종료|");
			System.out.println("|4.시설물관리|5.유형관리|6.캠핑장등록|");
			System.out.println("----------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("프로그램 종료!");
				run = false;
				break;

			case "1":// 캠핑장목록
				List<CampVO> array = cdao.list();

				System.out.println("넘버\t이름\t\t\t주소\t전화번호");
				System.out.println("====================================================");
				for (CampVO vo : array) {
					System.out.printf("%s\t%-20s\t%s\t%s\n", vo.getCno(), vo.getCname(), vo.getJuso(), vo.getTel());
				}
				System.out.println(array.size() + "개의 캠핑장이 등록되었습니다.");

				break;

			case "2":// 캠핑장조회
				while (true) {

					System.out.print("\n캠핑장번호입력>");
					String cno = s.nextLine();
					if (cno == "") {
						System.out.println("조회를 종료합니다.");
						break;
					} else {
						CampVO vo = cdao.read(cno);
						if (vo.getCname() == null) {
							System.out.println("해당 캠핑장이 존재하지 않습니다.");
						} else {
							System.out.println("=================캠핑장조회==============================");
							System.out.println("넘버\t이름\t\t\t주소\t전화번호");
							System.out.printf("%s\t%-20s\t%s\t%s\n", vo.getCno(), vo.getCname(), vo.getJuso(),
									vo.getTel());
						}

					}
				}

				break;

			case "3":
				while (true) {
					System.out.print("수정할캠핑장번호입력>");
					String cno = s.nextLine();
					if (cno == "") {
						System.out.println("수정을 취소합니다.");
						break;
					} else {
						CampVO cvo = cdao.read(cno);
						if (cvo.getCname() == null) {
							System.out.println("캠핑장이 존재하지 않습니다.");
						} else {// 수정할 캠핑장이 있으면
							System.out.print("캠핑장 이름>" + cvo.getCname());
							System.out.print("\n새로운캠핑장이름>");
							String newCamp = s.nextLine();
							if (newCamp != "")
								cvo.setCname(newCamp);
							System.out.print("캠핑장 주소>" + cvo.getJuso());
							System.out.print("\n새로운캠핑장주소>");
							String newJuso = s.nextLine();
							if (newJuso != "")
								cvo.setJuso(newJuso);
							System.out.print("캠핑장 전화번호>" + cvo.getTel());
							System.out.print("\n새로운캠핑장주소>");
							String newTel = s.nextLine();
							if (newTel != "")
								cvo.setTel(newTel);
							System.out.print("\n수정하실래요?(Y/y)");
							String sel = s.nextLine();
							if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
								//수정작업
								cdao.update(cvo);
								System.out.println("캠핑장 수정이 완료되었습니다.");
								
							} else {
								System.out.println("수정을 취소합니다.");
								
							}break;
						}
					}
				}
				break;

			case "6":
				CampVO cvo = new CampVO();
				cvo.setCno(cdao.getNo());
				System.out.println("새로운 번호>" + cvo.getCno());
				System.out.print("캠핑장 이름>");
				String cname = s.nextLine();
				if (cname == "") {
					System.out.println("등록을 취소합니다.");
					break;
				} else {
					System.out.print("캠핑장주소>");
					String juso = s.nextLine();
					System.out.print("캠핑장전화>");
					String tel = s.nextLine();
					cvo.setCname(cname);
					cvo.setJuso(juso);
					cvo.setTel(tel);
					System.out.println("현재 입력된 정보는 다음과 같습니다." + cvo.toString());
					System.out.print("\n등록할까요?(Y/y)");
					String sel = s.nextLine();
					if (sel.equals("Y") | sel.equals("y") | sel.equals("ㅛ")) {
						cdao.insert(cvo);
						System.out.println("새로운 캠핑장등록이 완료되었습니다.");
					} else {
						System.out.println("등록을 취소합니다.");
						break;
					}

				}

				break;
			default:
				System.out.println("올바른 번호를 입력해 주세요.");

			}// switch

		} // while
	}// main

}// Main
