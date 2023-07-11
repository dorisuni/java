package ex08;

import java.text.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		AccountDAO adao = new AccountDAO();
		DetailDAO ddao = new DetailDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#,###원");
		boolean run = true;
		while (run) {
			System.out.println("\n\n******* 계좌관리 *****************************");
			System.out.println("------------------------------------------------------");
			System.out.println("|1.계좌생성 |2.계좌조회 |3.입금 |4.출금 |5.가입자 전체 리스트|0.종료|");
			System.out.println("------------------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("시스템 종료!");
				run = false;
				break;

			case "1":

				System.out.print("이름을 입력하세요.>");
				String name = s.nextLine();
				if (name == "")
					break;
				AccountVO acc = new AccountVO();
				acc.setAname(name);
				int balance = input("입금금액을 입력하세요");
				if (balance == 0)
					break;
				acc.setBalance(balance);
				System.out.println(acc.toString());

				System.out.println("새로운 계좌를 생성하실래요?(Y/y)");
				String sel = s.nextLine();
				if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
					int newano = adao.insert(acc);
					System.out.println(newano + "번 새로운 계좌가 생성되었습니다.");
					// 거래내역저장
					DetailVO dvo = new DetailVO();
					dvo.setAno(newano);
					dvo.setAmount(balance);
					dvo.setType("입금");
					ddao.insert(dvo);

				}

				break;

			case "2":

				while (true) {
					int ano = input("\n조회할계좌번호");
					if (ano == 0) {
						System.out.println("조회를 종료합니다.");
						break;
					} else {

						try {
							AccountVO vo = adao.read(ano);
							if (vo.getAname() == null) {
								System.out.println("해당계좌가 존재하지 않습니다.");
							} else {
								System.out.println("계좌주: " + vo.getAname());
								System.out.println("잔액: " + df.format(vo.getBalance()));
								System.out.println("========================================");
								System.out.println("거래번호\t금액\t거래종류\t거래일시");
								for (DetailVO vo1 : ddao.list(ano)) {
									System.out.printf("%d\t%s\t%s\t%s\n", vo1.getDno(), df.format(vo1.getAmount()),
											vo1.getType(), sdf.format(vo1.getDdate()));
								}

							}

						} catch (Exception e) {
							System.out.println("계좌조회오류" + e.toString());

						}

					}
				}

				break;

			case "3":
				int ano1 = input("입금계좌번호");
				if (ano1 == 0) {
					System.out.println("입금을 취소합니다.");
				} else {
					try {
						AccountVO acc1 = adao.read(ano1);
						if (acc1.getAname() == null) {
							System.out.println("해당 계좌가 존재하지 않습니다.");
						} else {
							System.out.println("계좌주:" + acc1.getAname());
							System.out.println("현재잔액:" + acc1.getBalance());
							int amount = input("입금금액");
							if (amount == 0) {
								System.out.println("입금을 취소합니다.");
							} else {
								acc1.setBalance(acc1.getBalance() + amount);
								adao.update(acc1);
								DetailVO dvo = new DetailVO();
								dvo.setAno(ano1);
								dvo.setType("입금");
								dvo.setAmount(amount);
								ddao.insert(dvo);
								System.out.println("입금이 완료되었습니다.");

							}
						}
					} catch (Exception e) {
						System.out.println("조회오류" + e.toString());
					}
				}

				break;

			case "4":
				boolean balanceNot = false;
				int ano2 = input("출금계좌번호");
				if (ano2 == 0) {
					System.out.println("출금을 취소합니다.");
				} else {
					try {
						AccountVO acc1 = adao.read(ano2);
						if (acc1.getAname() == null) {
							System.out.println("해당 계좌가 존재하지 않습니다.");
						} else {
							System.out.println("계좌주:" + acc1.getAname());
							System.out.println("현재잔액:" + acc1.getBalance());
							while (true) {
								int amount = input("출금금액");
								if (amount == 0) {
									System.out.println("출금을 취소합니다.");
									break;
								} else {

									if (acc1.getBalance() >= amount) {
										acc1.setBalance(acc1.getBalance() - amount);
										adao.update(acc1);
										DetailVO dvo = new DetailVO();
										dvo.setAno(ano2);
										dvo.setType("출금");
										dvo.setAmount(amount);
										ddao.insert(dvo);
										System.out.println("출금이 완료되었습니다.");
										balanceNot = true;
										break;

									}if (!balanceNot)
										System.out.println("잔액이 부족합니다.");

								}
							}
						}
					} catch (Exception e) {
						System.out.println("조회오류" + e.toString());
					}
				}

				break;

			case "5":
				System.out.println("=====전체계좌조회리스트======");
				System.out.println("계좌번호\t이름\t잔액");
				try {
					for (AccountVO vo : adao.list()) {
						System.out.printf("%s\t%s\t%s\n", vo.getAno(), vo.getAname(), df.format(vo.getBalance()));
					}
					break;
				} catch (Exception e) {
					System.out.println("목록출력오류:" + e.toString());
				}
			default:
				System.out.println("메뉴를 다시 선택하세요.");

			}

		}

	}

	public static int input(String title) {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print(title + ">");
			String str = s.nextLine();
			try {
				if (str == "") {
					return 0;
				} else {
					return Integer.parseInt(str);
				}

			} catch (Exception e) {
				System.out.println("숫자를 입력하세요.");
			}

		}

	}

}