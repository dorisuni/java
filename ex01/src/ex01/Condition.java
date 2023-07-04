package ex01;

import java.util.Scanner;

public class Condition {
	public static void run() {
		//if문 switch~case문
		
		Scanner s = new Scanner(System.in);
		System.out.print("점수:");
		int grade = s.nextInt();
		
		String result = "";
		if (grade >= 90) {
			if(grade>=95) {
				result = "A+";
			}else {
				result = "A0";
			}
				
		}else if(grade>=80) {
			result = "B";
		}else if(grade>=70) {
			result = "C";
		}else if(grade>60) {
			result = "D";
		}else {
			result = "F";
		}
		System.out.println("학점:"+result);
		
		
		
		System.out.print("시간:");
		int time = s.nextInt();
		switch (time) {
		case 6:
			System.out.println("일어나세요!");
			break;
		case 9:
			System.out.println("출근하세요!");
			break;
		case 12:
			System.out.println("점심식사하세요!");
			break;
		case 18:
			System.out.println("퇴근하세요!");
			break;
		default:
			System.out.println("잘못입력했습니다.");
		}
				
				
				
		
		
	
	
	
			
		
		
	}//run
}//class
