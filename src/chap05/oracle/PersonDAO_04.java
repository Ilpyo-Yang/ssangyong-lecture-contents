package chap05.oracle;

import java.sql.*;

public class PersonDAO_04 implements InterPersonDAO_03 {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 자원반납 메서드
	private void close() {	
		try {
			if(rs!=null) {rs.close(); rs=null;}
			if(pstmt!=null) {pstmt.close(); pstmt=null;}
			if(conn!=null) {conn.close(); conn=null;}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	// 개인성향을 입력(insert) 해주는 메서드
	@Override
	public int personRegister(PersonDTO_02 psdto) throws SQLException {
		int n = 0;
		
		try {
			conn = MyDBConnection_05.getConn();
			
			String sql = " insert into tbl_person_interest(seq, name, school, color, food) "+
						 " values(person_seq.nextval, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, psdto.getName());
			pstmt.setString(2, psdto.getSchool());
			pstmt.setString(3, psdto.getColor());
			
			if(psdto.getFood()!=null) {
				pstmt.setString(4, String.join(",", psdto.getFood()));
			} else {
				pstmt.setString(4, null);
				// 또는
				// pstmt.setString(4, "없음");
			}
			
			n = pstmt.executeUpdate();

		} finally {
			close();
		}
		return n;
	}// end of personRegister(PersonDTO_02 psdto) throws SQLException --------------

}
