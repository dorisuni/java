package day09;

public class Animal {
	// 필드
	private String name; // 동물이름
	private String sound; // 울음소리
	private int leg; // 다리갯수
	
	// 메서드(get/set)
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getSound() {
		return sound;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public int getLeg() {
		return leg;
	}
	public void print() {
		System.out.println(name+"\t"+sound+"\t"+leg);
	}
	public void print1(){
		System.out.printf ("이름:%s, 울음:%s ,다리:%d\n",name,sound,leg);
	
		
		
	}
	
}
