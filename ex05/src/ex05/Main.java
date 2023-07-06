package ex05;
import java.util.*;
import java.text.*;

public class Main {
	public static void main(String[] args) {
		StudentDAO dao=new StudentDAO();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		
		Scanner s=new Scanner(System.in);
		boolean run=true;
		
		while(run) {
			System.out.println("\n\n******* 학생관리 *****************************");
			System.out.println("--------------------------------------------");
			System.out.println("1.입력 |2.조회 |3.목록 |4.수정 |5.삭제 |0.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>");
			String menu=s.nextLine();
			switch(menu) {
			case "0":
				run=false;
				System.out.println("프로그램을 종료합니다.");
				break;
			case "1":
				StudentVO stu=new StudentVO();
				stu.setSno(dao.getNo());
				System.out.println("학번>" + stu.getSno());
				break;
			case "2":
				
				break;
			case "3": //목록
				for(StudentVO vo:dao.list()) {
					String date=sdf.format(vo.getBirthday());
					System.out.printf("%s\t%s\t%s\t%s\t%d\n",
							vo.getSno(), 
							vo.getSname(), 
							vo.getDept(),
							date,
							vo.getYear());
				}
				break;
			case "4":
				break;
			case "5":
				break;	
			default: 
				System.out.println("메뉴를 다시선택하세요!");
			}//switch
		}//while
	}//main
}//main
