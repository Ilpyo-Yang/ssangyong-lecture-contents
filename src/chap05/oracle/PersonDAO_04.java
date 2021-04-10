package chap05.oracle;

import java.sql.*;
import java.util.*;

public class PersonDAO_04 implements InterPersonDAO_03 {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void close() {
		
		try {
			 if(rs != null)    { rs.close(); rs = null; }
			 if(pstmt != null) { pstmt.close(); pstmt = null; }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}// end of private void close()---------------
	
	
	// 개인성향을 입력(insert)해주는 메소드
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
			
			if( psdto.getFood() != null ) {
				pstmt.setString(4, String.join(",", psdto.getFood()) );	
			}
			else {
				pstmt.setString(4, null);
			//  또는 
			//	pstmt.setString(4, "없음");
			}
			
			n = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		
		return n;
	}// end of public int personRegister(PersonDTO_02 psdto) throws SQLException---------- 


	// tbl_person_interest 테이블에 저장되어진 모든 행들을 select 해주는 메소드  
	@Override
	public List<PersonDTO_02> selectAll() throws SQLException {
		
		List<PersonDTO_02> personList = new ArrayList<>();
		
		try {
			
			conn = MyDBConnection_05.getConn();
			
			String sql = " select seq, name, school, color, food, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') AS registerday "+ 
					     " from tbl_person_interest "+
					     " order by seq ";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				PersonDTO_02 psdto = new PersonDTO_02();
				psdto.setSeq(rs.getInt(1));
				psdto.setName(rs.getString(2));
				psdto.setSchool(rs.getString(3));
				psdto.setColor(rs.getString(4));
				
				String food = rs.getString(5);
				if(food != null) {
					psdto.setFood(rs.getString(5).split("\\,")); // "짜짱면,짬뽕,탕수육,양장피,팔보채" 
				}
				else {
					psdto.setFood(null);
				}
				
				psdto.setRegisterday(rs.getString(6));
				
				personList.add(psdto);
				
			}// end of while----------------------------
			
		} finally {
			close();
		}
		
		return personList;
	}// end of public List<PersonDTO_02> selectAll() throws SQLException-----------


	// tbl_person_interest 테이블에 저장되어진 특정 1개 행만 select 해주는 메소드 
	@Override
	public PersonDTO_02 selectOne(String seq) throws SQLException {
		
		PersonDTO_02 psdto = null;
		
		try {
			
			conn = MyDBConnection_05.getConn();
			
			String sql = " select seq, name, school, color, food, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') AS registerday "+ 
					     " from tbl_person_interest "+
					     " where seq = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				psdto = new PersonDTO_02();
				psdto.setSeq(rs.getInt(1));
				psdto.setName(rs.getString(2));
				psdto.setSchool(rs.getString(3));
				psdto.setColor(rs.getString(4));
				
				String food = rs.getString(5);
				if(food != null) {
					psdto.setFood(rs.getString(5).split("\\,")); // "짜짱면,짬뽕,탕수육,양장피,팔보채" 
				}
				else {
					psdto.setFood(null);
				}
				
				psdto.setRegisterday(rs.getString(6));
				
			}// end of if----------------------------
			
		} finally {
			close();
		}
		
		return psdto;
	}// end of public PersonDTO_02 selectOne(String seq) throws SQLException--------


	// tbl_person_interest 테이블에 저장되어진 특정 1개 행만 delete 해주는 추상메소드(미완성메소드)
	@Override
	public int deletePerson(String seq) throws SQLException {
		
		int n = 0;
		
		try {
			conn = MyDBConnection_05.getConn();
			
			String sql = " delete from tbl_person_interest "+
					     " where seq=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
				
			n = pstmt.executeUpdate();
	
			
		} finally {
			close();
		}
		
		return n;
	}


	// tbl_person_interest 테이블에 저장되어진 특정 1개 행만 update 해주는 추상메소드(미완성메소드)
	public int updatePerson(PersonDTO_02 psdto) throws SQLException {
		int n = 0;
		
		try {
			conn = MyDBConnection_05.getConn();
			
			String sql = " update tbl_person_interest set name=?, school=?, color=?, food=? "+
					     " where seq=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, psdto.getName());
			pstmt.setString(2, psdto.getSchool());
			pstmt.setString(3, psdto.getColor());
			
			String[] arrFood = psdto.getFood(); 
			if( arrFood != null ) {
				pstmt.setString(4, String.join(",", arrFood));	
			}
			else {
				pstmt.setString(4, null);
			//  또는 
			//	pstmt.setString(4, "없음");
			}
			
			pstmt.setInt(5, psdto.getSeq());
			
			n = pstmt.executeUpdate();
			
		} finally {
			close();
		}
		return n;
	}
	

}
