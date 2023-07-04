package day12;

public class Ex01_static {
	public static void main(String[] args) {
		
		Test a = new Test();
		Test b = new Test();
		Test c = new Test();
		
		a.num = 100;
		Test.num = 200;
		a.numUp();
		
		
		System.out.println(a.num);
		System.out.println(b.num);
		System.out.println(c.num);

		
	



	}
}
	
class Test{
	static int num = 100;
	public void numUp() {
		num++;
	}
}

