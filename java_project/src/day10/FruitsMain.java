package day10;

public class FruitsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruits apple = new Fruits();
		apple.name = "사과";
		apple.color = "빨강";
		apple.isSeed = true;
		
		
		//두번째 생성자 사용해서 바나나 객체생성
		Fruits banana = new Fruits("바나나");
		banana.color = "노랑";
		banana.isSeed = false;
		
		
		//세번째 생성자 사용해서 멜론 객체생성
		Fruits melon = new Fruits("멜론","연두");
		melon.isSeed = true;
		//네번째 생성자 사용해서 오렌지 객체생성
		Fruits orange = new Fruits("오렌지","주황",false);
		
		System.out.println("과일리스트");
		apple.print();
		banana.print();
		melon.print();
		orange.print();
		
	}

}
