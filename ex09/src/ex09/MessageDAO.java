package ex09;

import java.sql.*;
import java.util.*;

public class MessageDAO {
	Connection con = Database.connect();

	
	// 보낸메시지삭제
		public void sendDel(int mid) {
			try {
				String sql = "UPDATE MESSAGES SET rDEL=1 WHERE MID =?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, mid);
				ps.execute();
				
			} catch (Exception e) {
				System.out.println("메시지전송오류:" + e.toString());

			}
		}
	
	
	// 받은메시지삭제
	public void receiveDel(int mid) {
		try {
			String sql = "UPDATE MESSAGES SET sDEL=1 WHERE MID =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mid);
			ps.execute();
			
		} catch (Exception e) {
			System.out.println("메시지전송오류:" + e.toString());

		}
	}

	// 메시지전송
	public void insert(MessageVO vo) {
		try {
			String sql = "INSERT INTO MESSAGES(MID, SENDER,RECEIVER,SDATE,MESSAGE)"
					+ "VALUES(SEQ_MID.NEXTVAL,?,?,SYSDATE,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getSender());
			ps.setString(2, vo.getReceiver());
			ps.setString(3, vo.getMessage());
			ps.execute();

		} catch (Exception e) {
			System.out.println("메시지전송오류:" + e.toString());

		}
	}

	// 받은메시지
	public List<MessageVO> receiveList(String id) {
		List<MessageVO> array = new ArrayList<MessageVO>();

		try {
			String sql = "SELECT M.*, UNAME FROM MESSAGES M, USERS U WHERE RECEIVER=? AND SENDER=ID AND RDEL=0";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setMid(rs.getInt("mid"));
				vo.setSender(rs.getString("sender"));
				vo.setUname(rs.getString("uname"));
				vo.setMessage(rs.getString("message"));
				vo.setSdate(rs.getTimestamp("sdate"));
				array.add(vo);

			}

		} catch (Exception e) {
			System.out.println("보낸메시지오류" + e.toString());
		}

		return array;

	}

	// 보낸메시지
	public List<MessageVO> sendList(String id) {
		List<MessageVO> array = new ArrayList<MessageVO>();

		try {
			String sql = "SELECT M.*, UNAME FROM MESSAGES M, USERS U WHERE SENDER=? AND RECEIVER=ID AND rDEL=0";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setMid(rs.getInt("mid"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setUname(rs.getString("uname"));
				vo.setMessage(rs.getString("message"));
				vo.setSdate(rs.getTimestamp("sdate"));
				array.add(vo);

			}

		} catch (Exception e) {
			System.out.println("받은메시지오류" + e.toString());
		}

		return array;

	}

}
