package grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.databaseUtil;

public class gradeDAO {
	public gradeDTO gradeCheck(String c_id, String s_id) {
		String SQL = "select * from grade where c_id = ? and s_id = ?";

		gradeDTO dto = new gradeDTO();
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, c_id);
			pstmt.setString(2, s_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString(3) + "이거");
				dto.setC_id(rs.getString(1));
				dto.setS_id(rs.getString(2));
				dto.setAttend(rs.getString(3));
				dto.setWork(rs.getString(4));
				dto.setMid(rs.getString(5));
				dto.setFin(rs.getString(6));
				dto.setGrade(rs.getString(7));
			}

			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void gradeUpdate(gradeDTO dto) {
		String SQL = "insert into grade(c_id, s_id, attend, works, mid, fin, grade) value(?, ?, ?, ?, ?, ?, ?);";
		try {
			Connection conn = databaseUtil.getConnection();
			PreparedStatement pstmt;

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getC_id());
			pstmt.setString(2, dto.getS_id());
			pstmt.setString(3, dto.getAttend());
			pstmt.setString(4, dto.getWork());
			pstmt.setString(5, dto.getMid());
			pstmt.setString(6, dto.getFin());
			pstmt.setString(7, dto.getGrade());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
