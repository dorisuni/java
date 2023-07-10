package ex072;

import java.util.Scanner;
import java.text.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductDAO dao = new ProductDAOImpl();
		Scanner s = new Scanner(System.in);
		boolean run = true;
		DecimalFormat df = new DecimalFormat("#,###.00");
		while (run) {
			System.out.println("\n\n******* 상품관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.입력 |2.조회 |3.목록 |4.수정 |5.삭제 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("시스템 종료!");
				run = false;
				break;

			case "1":
				ProductVO pro = new ProductVO();
				System.out.print("상품이름>");
				pro.setPname(s.nextLine());
				pro.setPprice(input("상품가격"));
				try {
					dao.insert(pro);
					System.out.println("상품이 등록되었습니다!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("상품등록 오류");
				}
				break;

			case "2":

				while (true) {
					System.out.print("\n상품코드>");
					String pcode = s.nextLine();
					if (pcode == "")
						break;
					try {
						ProductVO vo = dao.read(Integer.parseInt(pcode));
						if (vo.getPname() == null) {
							System.out.println("해당상품이 존재하지 않습니다.");
						} else {
							System.out.println("상품이름:" + vo.getPname());
							System.out.println("상품가격:" + df.format(vo.getPprice()));
						}
					} catch (Exception e) {
						System.out.println("상품조회 오류");
					}
				}

				break;

			case "3":
				try {
					for (ProductVO vo : dao.list()) {
						System.out.printf("%d\t%-20s\t%s원\n", vo.getPcode(), vo.getPname(), df.format(vo.getPprice()));
					}
					System.out.println(dao.list().size() + "개 상품이 등록되었습니다.");
				} catch (Exception e) {
					System.out.println("목록출력오류");
				}

				break;

			case "4":
				break;

			case "5":
				System.out.print("삭제코드입력>");
				String pcode = s.nextLine();

				try {
					ProductVO pro2 =  dao.read(Integer.parseInt(pcode));
					if(pro2.getPname()==null) {
						System.out.println("삭제할 상품이 존재하지않습니다.");
					}else {
						System.out.println("상품이름:"+pro2.getPname());
						System.out.println("상품가격:"+df.format(pro2.getPprice()));
						System.out.print("삭제하실래요?(Y,y)");
						String sel = s.nextLine();
						
						if(sel.equals("Y")||sel.equals("y")||sel.equals("ㅛ")) {
							dao.delete(Integer.parseInt(pcode));
							System.out.println("상품삭제완료!");
						}
					}
				} catch (Exception e) {
					System.out.println("상품삭제 오류"+e.toString());
				}

				break;

			default:
				System.out.println("메뉴를 다시 선택하세요!");

			}// swtich
		} // while

	}// main

	// 가격입력 메소드 만들기
	public static int input(String title) {
		Scanner s = new Scanner(System.in);
		int number = 0;
		while (true) {
			System.out.print(title + ">");
			try {
				number = Integer.parseInt(s.nextLine());
				return number;
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요!");
			}

		}
	}

}// Main