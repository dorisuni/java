package ex09;

import java.sql.*;
import java.util.*;

public class UserDAO {
//DATABASE ACCESS OBJECT
	Connection con = Database.connect();

	
	//사용자 삭제하기
	public void delete(String uid)throws Exception {
		
			String sql = "DELETE FROM USERS WHERE Id =?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ps.execute();
	}
	
	
	
	
	//사용자 등록
	public void insert(UserVO vo) {
		try {
			String sql = "INSERT INTO USERS(ID,UNAME,PHONE)"
					+ "VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getUname());
			ps.setString(3, vo.getPhone());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("등록오류"+e.toString());
		}
	}
	
	
	
	
	
	//사용자수정
	public void update(UserVO vo) {
		try {
			String sql = "UPDATE USERS SET UNAME=?,PHONE=? WHERE ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUname());
			ps.setString(2, vo.getPhone());
			ps.setString(3, vo.getId());
			ps.execute();
			
		}catch(Exception e) {
			System.out.println("수정오류"+e.toString());
		}
		
	}
	
	
	
	
	// 사용자조회
	public UserVO read(String uid) {
		UserVO vo = new UserVO();

		try {
			String sql = "SELECT * FROM USERS WHERE ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setUname(rs.getString("uname"));
				vo.setPoint(rs.getInt("point"));
				vo.setPhone(rs.getString("phone"));

			}

		} catch (Exception e) {
			System.out.println("사용자조회오류" + e.toString());
		}
		return vo;

	}

	// 목록출력
	public List<UserVO> list() {
		List<UserVO> array = new ArrayList<UserVO>();

		try {
			String sql = "SELECT * FROM USERS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setId(rs.getString("id"));
				vo.setUname(rs.getString("uname"));
				vo.setPoint(rs.getInt("point"));
				vo.setPhone(rs.getString("phone"));
				array.add(vo);

			}

		} catch (Exception e) {
			System.out.println("사용자목록오류" + e.toString());

		}
		return array;
	}

}
