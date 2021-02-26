package jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DDL_create_PreparedStatement_06 {

	public static void main(String[] args) {
		
		Connection conn = null;
		// Connection conn 은 오라클 데이터베이스 서버와 연결을 맺어주는 객체이다.
		
		PreparedStatement pstmt = null;
		// PreparedStatement pstmt 은 Connection conn(특정 오라클 서버)에 전송할 SQL문(편지)을 전달할 객체(우편배달부)이다.       

		ResultSet rs = null;
		// ResultSet rs 은 select 되어진 결과물이 저장되어지는 곳.
		
		try {
			// >>> 1. 오라클 드라이버 로딩 <<<  //
			/*
			   === OracleDriver(오라클 드라이버)의 역할 ===
			   1). OracleDriver 를 메모리에 로딩시켜준다.
			   2). OracleDriver 객체를 생성해준다.
			   3). OracleDriver 객체를 DriverManager에 등록시켜준다.
			       --> DriverManager 는 여러 드라이버들을 Vector 에 저장하여 관리해주는 클래스이다.
			*/ 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			// >>> 2. 어떤 오라클 서버에 연결을 할래? <<<  //
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "HR", "cclass");
			
			
			// >>> 3. SQL문(편지)을 작성한다. <<< //
			String sql1 = " create table jdbc_tbl_examtest "
					    + " (no    number(4) "
					    + " ,name  varchar2(40) "
					    + " ,msg   varchar2(200) "
					    + ") ";
			
			String sql2 = " create sequence jdbc_seq_examtest "
					    + " start with 1 "
					    + " increment by 1 "
					    + " nomaxvalue "
					    + " nominvalue "
					    + " nocycle "
					    + " nocache ";
			
			String sql3 = " insert into jdbc_tbl_examtest(no, name, msg) "
					    + " values(jdbc_seq_examtest.nextval, '이순신', '안녕하세요? 이순신 입니다') "; 
			
			String sql4 = " select * "
					    + " from jdbc_tbl_examtest"
					    + " order by no asc ";
			
			
			// >>> 4. 연결한 오라클서버(conn)에 SQL문(편지)을 전달할 PreparedStatement 객체(우편배달부) 생성하기 <<< //
			pstmt = conn.prepareStatement(sql1);
			
			// >>> 5. PreparedStatement pstmt 객체(우편배달부)는 작성된 SQL문(편지)을 오라클 서버에 보내서 실행이 되도록 해야 한다 <<< // 
			int n = pstmt.executeUpdate(); 
			/*  .executeUpdate(); 은 SQL문이 DML문(insert, update, delete, merge) 이거나 
			                        SQL문이 DDL문(create, drop, alter, truncate) 일 경우에 사용된다. 
			    
			     SQL문이 DML문이라면 return 되어지는 값은 적용되어진 행의 개수를 리턴시켜준다.
			         예를 들어, insert into ... 하면 1 개행이 입력되므로 리턴값은 1 이 나온다. 
			             update ... 할 경우에 update 할 대상의 행의 개수가 5 이라면 리턴값은 5 가 나온다. 
			             delete ... 할 경우에 delete 되어질 대상의 행의 개수가 3 이라면 리턴값은 3 가 나온다.
			             
			     SQL문이 DDL문이라면 return 되어지는 값은 무조건 0 이 리턴된다.       
			*/
			
			System.out.println("create table 을 한 DDL문의 n : " + n);
			// create table 을 한 DDL문의 n : 0 
			
			
			pstmt.close();
			pstmt = conn.prepareStatement(sql2);
			n = pstmt.executeUpdate();
			System.out.println("create sequence 를 한 DDL문의 n : " + n);
			// create sequence 를 한 DDL문의 n : 0
			
			
			pstmt = conn.prepareStatement(sql3);
			n = pstmt.executeUpdate();
			System.out.println("insert 를 한 DML문의 n : " + n);
			// insert 를 한 DML문의 n : 1
			
			pstmt = conn.prepareStatement(sql4);
			rs = pstmt.executeQuery();
			
			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			
			while(rs.next()) {
				cnt++;
			    if(cnt == 1) {	
					System.out.println("----------------------------------");
					System.out.println("일련번호\t성명\t글내용");
					System.out.println("----------------------------------");
			    }
			    
			    sb.append( rs.getInt("NO") + "\t" + rs.getString("NAME") + "\t" + rs.getString("MSG") + "\n" );
			}// end of while(rs.next())---------------------------
			
			if(cnt > 0) {
				System.out.println(sb.toString());
			}
			else {
				System.out.println(">> 입력된 데이터가 없습니다. <<");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(">> ojdbc6.jar 파일이 없습니다. <<");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// >>> 6. 사용하였던 자원을 반납하기 <<< //
			// 반납의 순서는 생성순서의 역순으로 한다.
			
			try {
				  if(rs != null) 
					  rs.close();
				
				  if(pstmt != null) 
					  pstmt.close(); 
				  
				  if(conn != null) 
					  conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("~~~ 프로그램 종료 ~~~");
		
	}// end of main()------------------------------

}
