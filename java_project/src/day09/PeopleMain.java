package day09;

public class PeopleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People a = new People("홍길동",90);
		People b = new People("이순신",80);
		
		a.ageUp();
		b.ageUp1(5);
		a.print();
		b.print();
		
		System.out.println(a.getName()+"만 나이: "+a.koreanAge());
		System.out.println(b.getName()+"만 나이: "+b.koreanAge());
		
		//홍길동 나이 90인 객체 생성 ageUp메서드 사용(호출), 프린트사용.
		//이순신 나이 80인 객체 생성, ageUp1메서드 사용, 프린트사용.
		
	}

}
