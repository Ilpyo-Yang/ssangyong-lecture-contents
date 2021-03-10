package jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DQL_update_PreparedStatement_04 {

	public static void main(String[] args) {
		
		Connection conn = null;
		// Connection conn 은 오라클 데이터베이스 서버와 연결을 맺어주는 객체이다. 
		
		PreparedStatement pstmt = null;
		// PreparedStatement pstmt 은 Connection conn(특정 오라클 서버)에 전송할 SQL문(편지)을 전달할 객체(우편배달부)이다. 
		
		ResultSet rs = null;
		// ResultSet rs 은 select 되어진 결과물이 저장되어지는 곳.
		
		Scanner sc = new Scanner(System.in);
		
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
			System.out.print("▷  연결할 오라클 서버의 IP 주소 : ");
			String ip = sc.nextLine();
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":1521:xe", "HR", "cclass");
			
			conn.setAutoCommit(false); // 수동 commit 으로 전환 
			
			// >>> 3. SQL문(편지)을 작성한다. <<< //
			String sql = "select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday "+
					     "from jdbc_tbl_memo "+
					     "order by no desc"; // SQL문 맨 뒤에 ; 을 넣으면 오류이다.!!!!
			
			
			// >>> 4. 연결한 오라클서버(conn)에 SQL문(편지)을 전달할 PreparedStatement 객체(우편배달부) 생성하기 <<< //
			pstmt = conn.prepareStatement(sql); 
			
			
			// >>> 5. PreparedStatement pstmt 객체(우편배달부)는 작성된 SQL문(편지)을 오라클 서버에 보내서 실행이 되도록 해야 한다 <<< // 
			rs = pstmt.executeQuery();
			//   SQL문이 DQL문(select) 이므로 executeQuery(); 이다.
			//   pstmt.executeQuery(); 을 실행하면 select 되어진 결과물을 가져오는데 그 타입은 ResultSet 으로 가져온다. 
			
			/*
			   === 인터페이스 ResultSet 의 주요한 메소드 ===
			   1. next()  : select 되어진 결과물에서 커서를 다음으로 옮겨주는 것             리턴타입은 boolean 
			   2. first() : select 되어진 결과물에서 커서를 가장 처음으로 옮겨주는 것       리턴타입은 boolean
			   3. last()  : select 되어진 결과물에서 커서를 가장 마지막으로 옮겨주는 것    리턴타입은 boolean
			   
			   == 커서가 위치한 행에서 컬럼의 값을 읽어들이는 메소드 ==
			   getInt(숫자) : 컬럼의 타입이 숫자이면서 정수로 읽어들이때
			                  파라미터 숫자는 컬럼의 위치값 
			                 
			   getInt(문자) : 컬럼의 타입이 숫자이면서 정수로 읽어들이때
			                  파라미터 문자는 컬럼명 또는 alias명 
			                  
			   getLong(숫자) : 컬럼의 타입이 숫자이면서 정수로 읽어들이때
			                     파라미터 숫자는 컬럼의 위치값 
			                 
			   getLong(문자) : 컬럼의 타입이 숫자이면서 정수로 읽어들이때
			                     파라미터 문자는 컬럼명 또는 alias명                
			   
			   getFloat(숫자) : 컬럼의 타입이 숫자이면서 실수로 읽어들이때
			                      파라미터 숫자는 컬럼의 위치값 
			                 
			   getFloat(문자) : 컬럼의 타입이 숫자이면서 실수로 읽어들이때
			                      파라미터 문자는 컬럼명 또는 alias명 
			                      
			   getDouble(숫자) : 컬럼의 타입이 숫자이면서 실수로 읽어들이때
			                        파라미터 숫자는 컬럼의 위치값 
			                 
			   getDouble(문자) : 컬럼의 타입이 숫자이면서 실수로 읽어들이때
			                        파라미터 문자는 컬럼명 또는 alias명    
			                        
			   getString(숫자) : 컬럼의 타입이 문자열로 읽어들이때
			                        파라미터 숫자는 컬럼의 위치값 
			                 
			   getString(문자) : 컬럼의 타입이 문자열로 읽어들이때
			                        파라미터 문자는 컬럼명 또는 alias명                                                        
			*/		
			
			System.out.println("-------------------------------------------------------");
			System.out.println("글번호\t글쓴이\t글내용\t작성일자");
			System.out.println("-------------------------------------------------------");
			       
			StringBuilder sb = new StringBuilder();
			
			while(rs.next()) {
				/*
				   rs.next() 는 select 되어진 결과물에서 위치(행의 위치)를 다음으로 옮긴 후 
				     행이 존재하면 true 를 리턴해주고, 행이 없으면 false 를 리턴해주는 메소드이다.
				*/
				
				 int no = rs.getInt("NO");                   // "NO" 은  select 해온 컬럼명이다.
				 String name = rs.getString("NAME");         // "NAME" 은  select 해온 컬럼명이다.
				 String msg = rs.getString("MSG");           // "MSG" 은  select 해온 컬럼명이다.
				 String writeday = rs.getString("WRITEDAY"); // "WRITEDAY" 은  select 해온 컬럼명이다.
				
				 sb.append(no);
				 sb.append("\t"+name);
				 sb.append("\t"+msg);
				 sb.append("\t"+writeday+"\n");
				 
			}// end of while(rs.next())------------------
					
			System.out.println(sb.toString());
			
			//////////////////////////////////////////////
			System.out.print("▷ 수정할 글번호 : ");
			String no = sc.nextLine();
			
			sql = " select name, msg "
				+ " from jdbc_tbl_memo "
				+ " where no = ? ";
			
			pstmt.close();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs.close();
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String name = rs.getString(1);
				String msg = rs.getString(2);
				
				System.out.println("\n=== 수정하기 전 내용 ===");
				System.out.println("\n□ 글쓴이 : " + name);
				System.out.println("□ 글내용 : " + msg);
				
				System.out.println("\n=== 글 수정하기 ===");
				System.out.print("▷ 글쓴이 : ");
				name = sc.nextLine(); 
				
				System.out.print("▷ 글내용 : ");
				msg = sc.nextLine(); 
				
				sql = " update jdbc_tbl_memo set name = ? "
					+ "                        , msg = ? "
					+ " where no = ? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, msg);
				pstmt.setString(3, no);
				
				int n = pstmt.executeUpdate(); 
				// n 은 update 되어진 행의 개수를 리턴받는 것이다.
				/*  .executeUpdate(); 은 SQL문이 DML문(insert, update, delete, merge) 이거나 
				    SQL문이 DDL문(create, drop, alter, truncate) 일 경우에 사용된다. 
				
				    SQL문이 DML문이라면 return 되어지는 값은 적용되어진 행의 개수를 리턴시켜준다.
				       예를 들어, insert into ... 하면 1 개행이 입력되므로 리턴값은 1 이 나온다. 
				            update ... 할 경우에 update 할 대상의 행의 개수가 5 이라면 리턴값은 5 가 나온다. 
				            delete ... 할 경우에 delete 되어질 대상의 행의 개수가 3 이라면 리턴값은 3 가 나온다.
				     
				    SQL문이 DDL문이라면 return 되어지는 값은 무조건 0 이 리턴된다.       
				*/
				
				if(n==1) {
					// n==1 이라는 뜻은 update 구문이 성공되었다라면 
					
					String yn = "";
					do {
						System.out.print("▷ 정말로 수정하시겠습니까?[Y/N] : ");
						yn = sc.nextLine();
						
						if("y".equalsIgnoreCase(yn)) {
							conn.commit(); // 커밋
							System.out.println(">> 데이터 수정 성공!! <<");
							
							System.out.println("\n=== 수정한 후 내용 ===");
							
							sql = " select name, msg "
								+ " from jdbc_tbl_memo "
								+ " where no = ? ";
							
							pstmt = conn.prepareStatement(sql);
							pstmt.setString(1, no);
							
							rs = pstmt.executeQuery();
							
							rs.next();
							
							name = rs.getString(1);
							msg = rs.getString(2);
							
							System.out.println("□ 글쓴이 : " + name);
							System.out.println("□ 글내용 : " + msg);
							
						}
						
						else if("n".equalsIgnoreCase(yn)) {
							conn.rollback(); // 롤백
							System.out.println(">> 데이터 수정 취소!! <<");
						}
						
						else {
							System.out.println(">> Y 또는 N 만 입력하세요!! << \n");
						}
						
					} while ( !("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn)) );
					
				}
				
			} // end of if(rs.next())------------------------------
			
			else {
				System.out.println(">>> 글번호 "+no+" 은 존재하지 않습니다 <<< \n");
			}
		
		} catch(ClassNotFoundException e) {
			System.out.println(">> ojdbc6.jar 파일이 없습니다. <<");
		} catch (SQLException e) {
			System.out.println(">> 작성하신 SQL 문장에 오류가 있습니다. << ");
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
		
		sc.close();
		
		System.out.println("\n~~~ 프로그램 종료 ~~~");

	}// end of main()---------------------------------

}
