package test.model;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

public class TestDAO implements InterTestDAO {
	
	private DataSource ds;
	// DataSource ds 는 아파치톰캣이 제공하는 DBCP(DB Connection Pool) 이다.
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 생성자
	public TestDAO() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	// 사용한 자원을 반납하는 close() 메소드 생성하기 
	   private void close() {
	      try {
	         if(rs != null)    {rs.close();    rs=null;}
	         if(pstmt != null) {pstmt.close(); pstmt=null;}
	         if(conn != null)  {conn.close();  conn=null;}
	      } catch(SQLException e) {
	         e.printStackTrace();
	      }
	   }

	// tbl_test01 테이블에 insert 해주는 메소드
	@Override
	public int insertTest(TestVO vo) throws SQLException {
		int n=0;
		
		try {
		
			conn = ds.getConnection();
			
			String sql = " insert into tbl_test01 (name, address) "
					   + " values(?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			
			n = pstmt.executeUpdate();
			
		}finally {
			close();
		}
		return n;
	}

	// tbl_test01 테이블에 select 해주는 메소드
	@Override
	public List<TestVO> selectTest() throws SQLException {
		List<TestVO> testList = new ArrayList<>();
		
		try {
			
			conn = ds.getConnection();
			
			String sql = "select name, address "
					   + " from tbl_test01 ";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				TestVO vo = new TestVO();
				
				vo.setName(rs.getString(1));
				vo.setAddress(rs.getString(2));
				
				testList.add(vo);
			} // end of while----------------
			
		} finally {
			close();
		}
		return testList;
	}
	   
	   
	   
	   
	
	   
}
