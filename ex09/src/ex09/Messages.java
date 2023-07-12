package ex09;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.*;

public class Messages {
	public static void run(UserVO uvo) {
		Scanner s = new Scanner(System.in);
		MessageDAO ddao = new MessageDAO();
		UserDAO udao = new UserDAO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		boolean run = true;
		while (run) {
			System.out.println("\n**메시지관리**");
			System.out.println("==================================================");
			System.out.println("1.받은메시지함|2.보낸메시지|3.메시지보내기|4.메시지삭제|0.메인메뉴");
			System.out.println("==================================================");
			uvo = udao.read(uvo.getId());
			System.out.printf("이름:%s\t 포인트:%d\n", uvo.getUname(), uvo.getPoint());
			System.out.print("선택>");

			String menu = s.nextLine();

			switch (menu) {

			case "0":
				System.out.println("메인으로 돌아갑니다.");
				run = false;
				break;
				
				
			case "1":// 받은메시지
				for (MessageVO vo : ddao.receiveList(uvo.getId())) {
					System.out.printf("%d\t%s(%s)\t%s\n", vo.getMid(), vo.getSender(), vo.getUname(),
							sdf.format(vo.getSdate()));
					System.out.println(vo.getMessage());
					System.out.println("===========================================");

				}
				while (true) {
					System.out.println("삭제할번호");
					String mid = s.nextLine();
					if (mid == "") {
						break;
					}
					System.out.print("삭제하실래요?(Y/y");
					String sel =s.nextLine();
					if (sel.equals("Y") || sel.equals("y") || sel.equals("ㅛ")) {
						ddao.receiveDel(Integer.parseInt(mid));
						System.out.println("보낸 메시지가 삭제되었습니다.");
						break;
					}
					
				}
				break;
				
				
				
			case "2":// 보낸메시지
				for (MessageVO vo : ddao.sendList(uvo.getId())) {
					System.out.printf("%d\t%s(%s)\t%s\n", vo.getMid(), vo.getReceiver(), vo.getUname(),
							sdf.format(vo.getSdate()));
					System.out.println(vo.getMessage());
					System.out.println("===========================================");
				}
				break;


			case "3":
				while (true) {
					System.out.print("메시지를 받을 아이디>");
					String receiver = s.nextLine();
					if (receiver == "") {
						System.out.println("메시지 전송을 취소합니다.");
						break;
					} else {
						UserVO vo = udao.read(receiver);
						if (vo.getUname() == null) {
							System.out.println("해당 아이디가 없습니다.");
						} else {
							MessageVO mvo = new MessageVO();
							mvo.setSender(uvo.getId());
							mvo.setReceiver(receiver);
							System.out.print("메시지>");
							String message = s.nextLine();
							if (message == "") {
								System.out.println("메시지 전송을 취소합니다.");
							} else {
								mvo.setMessage(message);
								ddao.insert(mvo);
								udao.updatePoint(uvo.getId());
								System.out.println("메시지가 전송되었습니다.");
							}

							break;
							// 메시지 입력받기

						}
					}
				}

				break;

			case "4":
				break;

			default:
				System.out.println("올바른 번호를 입력해 주세요.");

			}

		}

	}
}
