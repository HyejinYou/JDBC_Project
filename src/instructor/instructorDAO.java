package instructor;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.databaseUtil;

public class instructorDAO {
	public void instructorPhoneUpdate(String id, String phone) {
		String SQL = "update instructor set p_num = ? where id = ?;";
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, phone);
			pstmt.setString(2, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void instructorMailUpdate(String id, String mail) {
		String SQL = "update instructor set mail = ? where id = ?;";
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, mail);
			pstmt.setString(2, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
