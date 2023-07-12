package ex09;

import java.awt.print.Printable;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		UserDAO udao = new UserDAO();

		boolean run = true;

		while (run) {
			System.out.println("\n\n******* 메시지관리 **************************************");
			System.out.println("------------------------------------------------------");
			System.out.println("|1.사용자목록|2.사용자조회|3.사용자수정|4.사용자등록|5.사용자삭제|0.종료|");
			System.out.println("------------------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("시스템 종료!");
				run = false;
				break;
			case "1":
				System.out.println("Id\t이름\t전화번호\t\t포인트");
				System.out.println("--------------------------------------------");
				for (UserVO vo : udao.list()) {
					System.out.printf("%s\t%s\t%s\t%d\n", vo.getId(), vo.getUname(), vo.getPhone(), vo.getPoint());
				}
				System.out.println(udao.list().size() + "명 등록되었습니다.");
				break;
			case "2":
				System.out.print("조회할아이디>");
				String id = s.nextLine();
				if (id == "") {
					System.out.println("조회를 종료합니다.");
					break;
				} else {
					UserVO uvo = udao.read(id);
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다.");

					} else {
						System.out.println("사용자이름:" + uvo.getUname());
						System.out.println("사용자전화:" + uvo.getPhone());
						System.out.println("사용자포인트:" + uvo.getPoint());

					}
				}

				break;

			case "3":
				System.out.println("수정할 아이디");
				id = s.nextLine();
				if (id == "") {
					System.out.println("수정종료!");
				} else {
					UserVO uvo = udao.read(id);
					if (uvo.getUname() == "") {
						System.out.println("사용자가 존재하지 않습니다.");
					} else {
						System.out.println("이름:" + uvo.getUname() + ">");
						String uname = s.nextLine();
						if (uname != "")
							uvo.setUname(uname);
						System.out.println("전화:" + uvo.getPhone() + ">");
						String phone = s.nextLine();
						if (phone != "")
							uvo.setPhone(phone);
						System.out.println(uvo.toString());
						System.out.println("수정하실래요?(Y/y)");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							udao.update(uvo);
							System.out.println("수정이 완료되었습니다.");
						} else {
							System.out.println("수정이 취소되었습니다.");
						}

					}
				}
				break;

			case "4":
				System.out.println("회원가입을 진행합니다.");
				while (true) {
					System.out.print("아이디입력>");
					id = s.nextLine();
					if (id == "") {
						System.out.println("등록을 취소합니다.");
						break;
					} else {
						UserVO uvo = udao.read(id);
						if (uvo.getUname() == null) {
							System.out.print("이름입력>");
							String sname = s.nextLine();
							if (sname == "") {
								System.out.println("이름은 반드시 입력해야 합니다.");
								break;
							} else {
								uvo.setUname(sname);
								uvo.setId(id);
								System.out.print("전화번호입력>");
								String phone = s.nextLine();
								uvo.setPhone(phone);
								System.out.println(uvo.toString());
								System.out.println("등록하실래요?(Y/y)");
								String sel = s.nextLine();
								if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
									udao.insert(uvo);
									System.out.println("등록이완료되었습니다.");
								} else {
									System.out.println("등록이취소되었습니다.");
								}

							}

							break;
						} else {
							System.out.println("사용중인 아이디입니다.");
						}
					}

				}

				break;

			case "5":
				System.out.print("삭제할아이디입력>");
				id = s.nextLine();
				if (id == "") {
					System.out.println("삭제를 취소합니다.");
				} else {
					UserVO uvo = udao.read(id);
					if (uvo.getUname() == null) {
						System.out.println("사용자가 존재하지 않습니다.");

					} else {
						System.out.println("사용자이름 " + uvo.getUname());
						System.out.print("삭제하실래요?(Y/y)>");
						String sel = s.nextLine();
						if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
							try {
								udao.delete(id);
								System.out.println("삭제가 완료되었습니다.");
							} catch (Exception e) {
								System.out.println("사용자 삭제를 실패했습니다.");
							}

						}
					}
				}
				break;

			default:
				System.out.println("메뉴를 다시 선택해 주세요.");

			}// switch
		} // while

	}// main
}// Main
