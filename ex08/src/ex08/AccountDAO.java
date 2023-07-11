package ex08;

import java.sql.*;

public class AccountDAO {
	Connection con = Database.connect();

	// 계좌생성

	public void insert(AccountVO vo) {
		try {
			String sql = "INSERT INTO ACCOUNT(ANO, ANAME, BALANCE) VALUES(SEQ_ANO.NEXTVAL,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getAname());
			ps.setInt(2, vo.getBalance());
			ps.execute();

		} catch (Exception e) {
			System.out.println("계좌생성오류:" + e.toString());
		}
	}

	
	
	
	
	
	
	// 계좌정보조회
	public AccountVO read(int ano) throws Exception {
		AccountVO vo = new AccountVO();
		String sql = "select * from account where ano = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ano);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			vo.setAno(rs.getInt("ano"));
			vo.setAname(rs.getString("aname"));
			vo.setBalance(rs.getInt("balance"));
		}
		return vo;

	}
}
