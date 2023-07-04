package day10;

public class AnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal dog = new Animal("강아지","멍멍",4);
		Animal chicken = new Animal("양념이","꼬끼오",4);
		Animal snake = new Animal("슥슥이","스윽스윽",0);
		Animal cat = new Animal();
		Animal elephant = new Animal();
		Animal horse = new Animal();
		cat.setName("야옹이");
		cat.setSound("야아옹");
		cat.setLeg(4);
		elephant.setName("끼리끼리코");
		elephant.setSound("뿌우우우우");
		elephant.setLeg(4);
		horse.setName("말말이");
		horse.setSound("히히힝");
		horse.setLeg(4);
		
		
		System.out.println("=====동물리스트=====");
		System.out.println("이름\t소리\t다리");
		dog.print();
		chicken.print();
		snake.print();
		cat.print();
		elephant.print();
		horse.print();
		
		
		
	}

}
