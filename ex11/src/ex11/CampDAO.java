package ex11;

import java.sql.*;
import java.util.*;

public class CampDAO {
	Connection con = Database.connect();
	
	
	//캠핑장 정보 수정
	
	public void update(CampVO vo) {
		try {
			String sql = "update camp set cname=?,juso=?,tel=? where cno=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCname());
			ps.setString(2, vo.getJuso());
			ps.setString(3, vo.getTel());
			ps.setString(4, vo.getCno());
			ps.execute();
			
			
		}catch(Exception e) {
			System.out.println("캠핑장수정오류:"+e.toString());
		}

	}
	
	//캠핑장등록
	
	public void insert(CampVO vo) {
		try {
			String sql = "insert into camp(cno,cname,juso,tel) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCno());
			ps.setString(2, vo.getCname());
			ps.setString(3, vo.getJuso());
			ps.setString(4, vo.getTel());
			ps.execute();
			
			
		}catch(Exception e) {
			System.out.println("새로운캠핑장오류:"+e.toString());
		}
		
	}
	
	
	// 새로운 캠핑장번호생성
	public String getNo() {
		String cno = "";
		try {
			String sql = "select max(cno)+1 nno from camp";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cno = rs.getString("nno");
			}

		} catch (Exception e) {
			System.out.println("새로운 캠핑번호 생성 오류:" + e.toString());
		}

		return cno;
	}

	// 캠핑장조회
	public CampVO read(String cno) {
		CampVO vo = new CampVO();
		try {
			String sql = "select * from camp where cno = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vo.setCname(rs.getString("cname"));
				vo.setCno(rs.getString("cno"));
				vo.setJuso(rs.getString("Juso"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			System.out.println("캠핑장조회오류" + e.toString());
		}

		return vo;
	}

	// curd처리
	// 캠핑장목록메서드
	public List<CampVO> list() {
		List<CampVO> array = new ArrayList<CampVO>();
		try {
			String sql = "select * from camp order by cno desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CampVO vo = new CampVO();
				vo.setCname(rs.getString("cname"));
				vo.setCno(rs.getString("cno"));
				vo.setJuso(rs.getString("Juso"));
				vo.setTel(rs.getString("tel"));
				array.add(vo);
			}

		} catch (Exception e) {
			System.out.println("캠핑장목럭출력오류" + e.toString());
		}
		return array;
	}

}
