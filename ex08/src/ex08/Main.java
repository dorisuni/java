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
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 |2.계좌조회 |3.입금 |4.출금 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("시스템 종료!");
				run = false;
				break;

			case "1":
				
				System.out.print("이름을 입력하세요.>");
				String name=s.nextLine();
				if(name=="") break;
				AccountVO acc = new AccountVO();
				acc.setAname(name);
				int balance = input("입금금액을 입력하세요");
				if(balance==0) break;
				acc.setBalance(balance);
				System.out.println(acc.toString());
				
				System.out.println("새로운 계좌를 생성하실래요?(Y/y)");
				String sel =s.nextLine();
				if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
					adao.insert(acc);
					System.out.println("새로운 계좌가 생성되었습니다.");
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
				break;

			case "4":
				break;

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