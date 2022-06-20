package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseUtil {
	public static Connection getConnection() { // 데이터베이스와 연결상태 관리
		try {
			String dbURL = "jdbc:mysql://localhost:3306/ academicservice";
			String dbID = "root";
			String dbPassword = "1234";
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc드라이버를 불러온다.
			return DriverManager.getConnection(dbURL, dbID, dbPassword); // mysql에 연결하기 위한 커넥션 정보
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
