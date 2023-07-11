package ex08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetailDAO {
	Connection con = Database.connect();
	
	//특정계좌 거래내역
	
	public List<DetailVO> list(int ano){
		List<DetailVO> array = new ArrayList<>();
		try {
			//거래번호가 큰게 위에 나오도록 세팅
			String sql = "select * from detail where ano=? order by dno desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ano);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DetailVO vo = new DetailVO();
				vo.setDno(rs.getInt("dno"));	
				vo.setAno(rs.getInt("ano"));
				vo.setAmount(rs.getInt("amount"));
				vo.setType(rs.getString("type"));
				vo.setDdate(rs.getTimestamp("ddate"));
				array.add(vo);
			}
			
			
			
			
		}catch(Exception e){
			System.out.println("거래내역조회"+e.toString());
		}
		
		return array; 
	}
	
	
}
