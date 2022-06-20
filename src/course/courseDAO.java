package course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.databaseUtil;

public class courseDAO {
	public ArrayList<courseDTO> list(String s) {
		String SQL = "select distinct c.course_id, c.course_name, c.credit, c.dept_name, i.name from course as c , instructor as i where c.i_id = i.id and (c.course_id like ? or c.course_name like ? or c.credit like ?  or c.dept_name like ?  or i.name like ? );";

		String str = "%" + s + "%";
		ArrayList<courseDTO> list = new ArrayList<courseDTO>();
		courseDTO dto = null;

		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, str);
			pstmt.setString(2, str);
			pstmt.setString(3, str);
			pstmt.setString(4, str);
			pstmt.setString(5, str);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new courseDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 수강신청
	public void Enrolment(String c_id, String s_id) {
		String SQL = "insert into advisor(c_id, s_id) value(?, ?);";
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, c_id);
			pstmt.setString(2, s_id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<courseDTO> studentCourseList(String id) {
		String SQL = "select a.c_id, c.course_name, c.credit, c.dept_name, i.name from course as c, instructor as i, advisor as a where a.c_id=c.course_id and c.i_id=i.id and a.s_id = ?;";
		ArrayList<courseDTO> list = new ArrayList<courseDTO>();
		courseDTO dto = null;
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new courseDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<courseDTO> instructorCourseList(String id) {
		String SQL = "select c.course_id, c.course_name, c.credit, c.dept_name from course as c, instructor as i where c.i_id = i.id and id = ?;";
		ArrayList<courseDTO> list = new ArrayList<courseDTO>();
		courseDTO dto = null;

		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto = new courseDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
