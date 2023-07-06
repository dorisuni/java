package ex05;
import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection con=Database.connect();
	
	//새로운 학번구하기
	public String getNo() {
		String no="";
		try {
			String sql="select max(sno)+1 no from students";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				no=rs.getString("no");
			}
		}catch(Exception e) {
			System.out.println("새로운 학번구하기:" + e.toString());
		}
		return no;
	}
	
	//학생목록
	public List<StudentVO> list(){
		List<StudentVO> array=new ArrayList<>();
		try {
			String sql="SELECT * from students";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				StudentVO vo=new StudentVO();
				vo.setSno(rs.getString("Sno"));
				vo.setSname(rs.getString("sname"));
				vo.setDept(rs.getString("dept"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setYear(rs.getInt("year"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("학생목록:" + e.toString());
		}
		return array;
	}
}