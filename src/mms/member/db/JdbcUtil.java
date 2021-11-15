package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	private static Connection conn = null;

	static {
		// 클래스가 로딩될 때 단 한번 호출되는 영역
		// Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다.");
		}
	}

	public static Connection getConnection() {
		// 디비 작업에 필요한 Connection 객체를 생성해 주는 메소드

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			conn = DriverManager.getConnection(url, "javalink", "javalink");
			conn.setAutoCommit(false);
		} catch (SQLException e) {

			System.out.println("주소,id,pw가 다릅니다.");
		}

		return conn;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

	// transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit(); // insert, update, delete
		} catch (SQLException e) {
			System.out.println("Commit Error");
		}
	}

	public static void rollback(Connection con) {
		try {
			con.rollback(); // insert, update, delete
		} catch (SQLException e) {
			System.out.println("Rollback Error");
		
		}
	}
}
