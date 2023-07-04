package day10;

public class Animal {
	private String name;
	private String sound;
	private int leg;
	
	
	public Animal(){
		
	}
	
	public Animal(String name, String sound, int leg) {
		this.name = name;
		this.sound = sound;
		this.leg = leg;
	}
	
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
		System.out.printf("%s\t%s\t%d\n",name,sound,leg);
	}
	
	
}
