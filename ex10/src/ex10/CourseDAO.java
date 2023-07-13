package ex10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
	// DATABASE ACCEPT OBJECT
	Connection con = Database.connect();

	// 학생조회
	public CourseVO read(String ccode) {
		CourseVO vo = new CourseVO();
		try {
			String sql = "SELECT * FROM COURSES where ccode = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ccode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vo.setCname(rs.getString("cname"));
				vo.setCcode(rs.getString("ccode"));
			}

		} catch (Exception e) {
			System.out.println("강좌조회 오류" + e.toString());
		}

		return vo;
	}

	// 학생등록
	public void insert(CourseVO vo) {
		try {
			String sql = "INSERT INTO COURSES(ccode,cname)" + "VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getCcode());
			ps.setString(2, vo.getCname());
			ps.execute();

		} catch (Exception e) {
			System.out.println("강좌등록 오류" + e.toString());
		}
	}

	// 새로운강좌번호 구하기
	public String getCode() {
		String ccode = "";

		try {
			String sql = "SELECT MAX(ccode)+1 NCODE FROM COURSES";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ccode = rs.getString("NCODE");
			}

		} catch (Exception e) {
			System.out.println("새로운강좌번호구하기오류" + e.toString());
		}

		return ccode;

	}

	// 학생목록
	public List<CourseVO> list() {
		List<CourseVO> array = new ArrayList<CourseVO>();

		try {
			String sql = "SELECT * FROM COURSES ORDER BY ccode desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CourseVO vo = new CourseVO();
				vo.setCcode(rs.getString("ccode"));
				vo.setCname(rs.getString("cname"));
				array.add(vo);
			}

		} catch (Exception e) {
			System.out.println("강좌목록출력오류" + e.toString());
		}

		return array;
	}

}
