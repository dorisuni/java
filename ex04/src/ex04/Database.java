package ex04;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	// 데이터베이스를 접속하기 위한 클래스임.
	public static Connection getConnection() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "java";
		String password = "pass";
		Connection con = null;

		// try catch문은 오류를 감지하고 오류를 보여주기위한.것이다.

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("접속성공");
		} catch (Exception e) {
			System.out.println("DB연결:" + e.toString());
		}
		return con;

		
		
		
	}
}
