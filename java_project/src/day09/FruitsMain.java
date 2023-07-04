package day09;

public class FruitsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruits apple = new Fruits();

		apple.name = "사과";
		apple.color = "빨강";
		apple.isSeed = true;
		apple.print();
		
		Fruits banana = new Fruits("바나나");
		banana.print();
		// 두번째 생성자 사용하여 melon 객체 생성
		// 세번째 생성자 사용하여 orange 객체 생성

		Fruits melon = new Fruits("멜론", "초록");
		melon.isSeed = true;

		Fruits orange = new Fruits("오렌지", "주황", false);
		
		melon.print();
		orange.print();
		
	}

}
