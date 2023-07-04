package day09;

public class Board {
	// 필드 (인스턴스 변수)
	private String title;
	private int cnt;
	private boolean open;

	// 생성자 이게없으면 생성이 안된다.
	public Board() {
		
	}
	
	public Board(String title, int cnt, boolean open) {
		this.title = title;
		this.cnt = cnt;
		this.open = open;
	}

	// 메소드는 (get/set)
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setOpen(boolean open) {
		this.open = open;

	}

	public boolean getOpen() {
		return open;
	}

	// 메서드명 : cntUp, 매개변수X 리턴타입 x 실행문구:cnt 1증가

	public void cntUp() {
		cnt++;
	}
	// 메서드명 : cntUp1, 매개변수 정수하나 리턴타입 o
	public int cntUp1(int cnt) {	
		return this.cnt+=cnt;
	}
	// 실행문구:매개변수만큼 cnt 증가하고 cnt리턴
	
	
	// 전체필드 다 출력하는 print메서드
	public void print() {
		System.out.printf("%s\t%d\t%b\t\n",title,cnt,open);
	}
}
