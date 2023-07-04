package ex03;

import java.util.*;

public class Sale {
	public static void run() {
		//샘플데이터
		List<SaleVO> array = new ArrayList<SaleVO>();
		SaleVO sale = new SaleVO(100,"냉장고",250,10);
		array.add(sale);
		sale = new SaleVO(101,"TV",220,15);
		array.add(sale);
		sale = new SaleVO(102,"에어컨",280,15);
		array.add(sale);
		int last = 102;
		Scanner s = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("\n\n******* 재고관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.입력 |2.조회 |3.목록 |4.수정 |5.삭제 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu = s.nextLine();
			switch (menu) {
			case "0":
				run = false;
				System.out.println("프로그램이 종료됩니다!");
				break;
			case "1":
				sale = new SaleVO();
				sale.setCode(++last);
				System.out.println("상품코드>"+sale.getCode());
				System.out.println("상품이름> ");
				sale.setName(s.nextLine());
				System.out.print("상품가격> ");
				sale.setPrice(Integer.parseInt(s.nextLine()));
				System.out.print("재고수량> ");
				sale.setQnt(Integer.parseInt(s.nextLine()));
				array.add(sale);
				break;
			case "2":
				System.out.print("조회번호> ");
				int search = Integer.parseInt(s.nextLine());
				boolean find =false;
				for(SaleVO vo:array) {
					if(search==vo.getCode()) {
						vo.setSum(vo.getPrice()*vo.getQnt());
						find =true;
						System.out.println("상품이름:" + vo.getName());
						System.out.println("상품가격:" + vo.getPrice());
						System.out.println("재고수량:" + vo.getQnt());
						System.out.println("상품금:" + vo.getSum());
					}
				}if(!find) {
					System.out.println("찾을 수 없는 번호입니다.");
				}
				break;
			case "3":
				for(SaleVO vo:array) {
					vo.setSum(vo.getPrice()*vo.getQnt());
					vo.print_land();
				}
				System.out.println(array.size()+"개 상품이 등록되었습니다.");
				break;
			case "4":	
				System.out.print("수정번호>");
				find = false;
				String update = s.nextLine();
				for (SaleVO vo: array) {
					if(Integer.parseInt(update)==vo.getCode()) {
						find = true;
						System.out.print("상품이름: "+vo.getName()+">");
						String newName = s.nextLine();
						if(newName!="") vo.setName(newName);
						System.out.print("상품가격: "+vo.getPrice()+">");
						String newPrice = s.nextLine();
						if(newPrice!="") vo.setPrice(Integer.parseInt(newPrice));
						String newQnt = s.nextLine();
						System.out.print("재고수량: "+vo.getQnt()+">");
						if(newQnt!="") vo.setQnt(Integer.parseInt(newQnt));
						System.out.println("수정완료!");
					}
				}if(!find) {
					System.out.println("없는 번호입니다.");
				}
				break;
			case "5":	
				System.out.print("삭제번호>");
				String delete = s.nextLine();
				find = false;
				for (SaleVO vo: array) {
					if(Integer.parseInt(delete)==vo.getCode()) {
						find = true;
						array.remove(vo);
						System.out.println("삭제완료");
						break;
					}
				}
				if(!find) System.out.println("없는 번호입니다.");
				break;
			}//switch
		}//while
	}//run
}//class