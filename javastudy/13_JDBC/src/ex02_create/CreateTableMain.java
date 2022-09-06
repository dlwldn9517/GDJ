package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTableMain {

	public static void main(String[] args) {

		// Connection 생성
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB접속 정보 오류");
		}
		
		// CREATE TABLE 실행
		
		
		
		// Connection 닫기
		try {
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
