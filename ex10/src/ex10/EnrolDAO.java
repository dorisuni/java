package ex10;
import java.util.*;
import java.sql.*;

public class EnrolDAO {
	Connection con = Database.connect();
	
	//특정 강좌를 신청한 학생목록
	public List<EnrolVO> slist(String ccode){
		List<EnrolVO> array = new ArrayList<EnrolVO>();
		try {
			String sql = "SELECT * FROM VIEW_ENROLS where ccode = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ccode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EnrolVO vo = new EnrolVO();
				vo.setScode(rs.getString("scode"));
				vo.setSname(rs.getString("sname"));
				vo.setEdate(rs.getTimestamp("edate"));
				vo.setGrade(rs.getInt("grade"));
				array.add(vo);
			}
		
			
			
			
		}catch(Exception e) {
			System.out.println("특정 학생이 신청한 강좌목록:"+e.toString());
		}
		
		return array;
	}
	
	
	
	
	
	
	
	//특정 학생이 신청한 강좌목록	
	public List<EnrolVO> clist(String scode){
		List<EnrolVO> array = new ArrayList<EnrolVO>();
		try {
			String sql = "SELECT * FROM VIEW_ENROLS where scode = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, scode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EnrolVO vo = new EnrolVO();
				vo.setSname(rs.getString("sname"));
				vo.setCcode(rs.getString("ccode"));
				vo.setCname(rs.getString("cname"));
				vo.setEdate(rs.getTimestamp("edate"));
				vo.setGrade(rs.getInt("grade"));
				array.add(vo);
			}
		
			
			
			
		}catch(Exception e) {
			System.out.println("특정 학생이 신청한 강좌목록:"+e.toString());
		}
		
		return array;
	}
			
	
}
