package day09;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board a = new Board();
		a.setTitle("즐겨찾기");
		a.setCnt(5);
		a.setOpen(true);
		
		
		
		a.cntUp1(4);
		a.print();
		
		
		Board b = new Board("자바는 즐거워",5,true);
		b.cntUp();
		b.print();
		
		Board c = new Board("자바는 어려워",4,false);
		
		System.out.println(c.cntUp1(5));
		
	}

}
