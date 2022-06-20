package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.databaseUtil;

public class studentDAO {
	public void studentUpdate(String id, String pw) {
		String SQL = "update student set pw =? where id = ?;";

		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void studentPhoneUpdate(String id, String phone) {
		String SQL = "update student set p_num = ? where id = ?;";

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

	public void studentEmailUpdate(String id, String mail) {
		String SQL = "update student set mail = ? where id = ?;";

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

	public ArrayList<studentDTO> studentList(String c_id) {
		String SQL = "select s.id, s.name, s.dept_name, s.c_year, s.p_num, s.mail from student as s, advisor as a where a.s_id = s.id and a.c_id = ?";
		ArrayList<studentDTO> list = new ArrayList<studentDTO>();
		studentDTO dto = null;
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, c_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new studentDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
