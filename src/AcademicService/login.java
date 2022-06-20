package AcademicService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.databaseUtil;

public class login extends GUI {

	private Connection conn = databaseUtil.getConnection();

	public int Login(String id, String pw, int who) {
		PreparedStatement pstmt;
		ResultSet rs;
		String SQL = "SELECT pw FROM =student  WHERE id = ?";

		if (who == 1) {
			SQL = "SELECT pw FROM student  WHERE id = ?";
		} else if (who == 2) {
			SQL = "SELECT pw FROM instructor  WHERE id = ?";
		}
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return 1; // true
				} else
					return 0; // false
			}
			return -1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}

	// 여기까지

}