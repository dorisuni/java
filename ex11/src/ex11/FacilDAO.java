package ex11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class FacilDAO {
	Connection con = Database.connect();
	
	//캠핑장에 시설물등록
	public void insert(String cno,int fno) {
		try {
			String sql = "insert into camp_facil(cno,fno) values (?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cno);
			ps.setInt(2, fno);
			ps.execute();

		}catch(Exception e) {
			System.out.println("캠핑장에 시설물등록오류"+e.toString());
		}
	}
	
	
	//캠핑장별 시설물
	public List<CampFacilVO> list(String cno){
		List<CampFacilVO> array = new ArrayList<CampFacilVO>();
		try {//뷰를 만들었기 때문에 사용한 것임.
			String sql = "select * from view_facil where cno = ?";
					
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CampFacilVO vo = new CampFacilVO();
				vo.setFno(rs.getInt("fno"));
				vo.setFname(rs.getString("fname"));
				array.add(vo);
				
			}
			
			
		}catch (Exception e) {
			System.out.println("캠핑장별시설물목록 오류:" + e.toString());
		}
		
		return array;
	}
	
	
	// 시설물전체목록

	
	
	public List<FacilVO> list() {
		List<FacilVO> array = new ArrayList<FacilVO>();
		try {
			String sql = "select * from facil order by fno";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FacilVO vo = new FacilVO();
				vo.setFno(rs.getInt("fno"));
				vo.setFname(rs.getString("fname"));
				array.add(vo);
			}

		} catch (Exception e) {
			System.out.println("시설물전체목록출력오류" + e.toString());
		}

		return array;
	}

}
