package jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 쌤 pc -> 211.238.142.72

public class DQL_select_where_PreparedStatement_03 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.print("▷  연결할 오라클 서버의 IP 주소 : ");
			String ip = sc.nextLine();
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":1521:xe", "HR", "cclass");
			
			String sql = "select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday\n"+
				    	"from jdbc_tbl_memo\n"+
					    "order by no desc";
						// "order by no desc;";
						// java.sql.SQLSyntaxErrorException: ORA-00911: invalid character
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
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
			
		  System.out.println("------------------------------------------------------------------");
		  System.out.println("글번호\t글쓴이\t글내용\t작성일자");
		  System.out.println("------------------------------------------------------------------");
		  
		
		  StringBuilder sb = new StringBuilder();
		// string을 계속 붙여쓰면 내부적 메모리가 많이 소모되므로 StringBuilder 나 StringBuffer 를 사용한다.

		  while(rs.next()) {
			  /*
			   		rs.next() 는 select 되어진 결과물에서 위치(행의 위치)를 다음으로 옮긴 후
			   		행이 존재하면 true 를 리턴해주고, 행이 없으면 false 를 리턴해주는 메소드이다.
			   */
			  int no = rs.getInt(1);	            // 컬럼 인덱스 값은 1 부터 시작. 즉, NO 컬럼을 말한다.
			  String name = rs.getString(2);	    // 컬럼 인덱스 값은 2 부터 시작. 즉, NAME 컬럼을 말한다.	
			  String msg = rs.getString(3);		    // 컬럼 인덱스 값은 3 부터 시작. 즉, MSG 컬럼을 말한다.
			  String writeday = rs.getString(4);	// 컬럼 인덱스 값은 4 부터 시작. 즉, WRIEDAY 컬럼을 말한다.
		      
			  sb.append(no);
			  sb.append("\t"+name);
			  sb.append("\t"+msg);
			  sb.append("\t"+writeday+"\n");
			  
		  }// end of while(rs.next()) ----------------------------------------------------
		   
		  System.out.println(sb.toString());
		  
		/////////////////////////////////////////////////////////////////
		  
		  // StringBuilder sb 을 초기화하기
		  sb = new StringBuilder();
		  // 또는
		  // sb.setLength(0);
		  
		  sb.append("----------->> 조회할 대상 <<----------\n");
		  sb.append("1.글번호	 2.글쓴이	 3.글내용   4.종료\n");
		  sb.append("----------------------------------\n");
		  String menu = sb.toString();
		  
		  String menuNo = "";
		  
		  do {
			  System.out.println(menu);
			  System.out.println("▷ 번호선택 : ");
			  menuNo = sc.nextLine();
			  String colName = ""; 		// where 절에 들어올 컬럼명
			  
			  switch (menuNo) {
				case "1":	// 글번호 검색
					colName="no";
					break;
				case "2":	// 글쓴이 검색
					colName="name";
					break;
				case "3":	// 글내용 검색
					colName="msg";
					break;
				case "4":	// 종료
					
					break;
				default:
					System.out.println("~~~ 메뉴에 없는 번호입니다 ~~~\n");
					break;
			}// end of switch ----------------------------------------------
			  
			  String search = "";
			  
			  if("1".equals(menuNo)||"2".equals(menuNo)||"3".equals(menuNo)) {
				 
				  System.out.println("▷ 검색어 : ");
				  search = sc.nextLine();
				  
				  sql = " select no,name,msg, to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') as writeday "+
					    " from jdbc_tbl_memo ";		
				  
				  if(!"3".equals(menuNo)) {	// 글번호 또는 글쓴이로 검색
					  sql += " where "+colName+" = ?";
					  // !!! 컬럼명 또는 테이블명은 위치홀더인 ? 를 쓰면 안되고, 변수처리로 해야 한다. !!!
					  // !!! 데이터값만 위치홀더인 ? 를 써야 한다. !!!
					  
				  } else {
					  sql += " where "+colName+" like '%'|| ? ||'%' ";	// 오라클 입력할 때 이렇게 해야한다
				  }
				  
				  sql += " order by no desc";
			  }	
			  
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setString(1, search);
			  
			  rs = pstmt.executeQuery();
			  
			 
			  
			   // StringBuilder sb 을 초기화하기
			   // sb = new StringBuilder();
			   // 또는
			   sb.setLength(0);
			   
			   
			   int cnt = 0;
			   while (rs.next()) {
				   cnt++;
				   
				  if(cnt==1) {
					  System.out.println("------------------------------------------------------------------");
					  System.out.println("글번호\t글쓴이\t글내용\t작성일자");
					  System.out.println("------------------------------------------------------------------");
				  }
				   
				  int no = rs.getInt(1);	            // 컬럼 인덱스 값은 1 부터 시작. 즉, NO 컬럼을 말한다.
				  String name = rs.getString(2);	    // 컬럼 인덱스 값은 2 부터 시작. 즉, NAME 컬럼을 말한다.	
				  String msg = rs.getString(3);		    // 컬럼 인덱스 값은 3 부터 시작. 즉, MSG 컬럼을 말한다.
				  String writeday = rs.getString(4);	// 컬럼 인덱스 값은 4 부터 시작. 즉, WRIEDAY 컬럼을 말한다.
			      
				  sb.append(no);
				  sb.append("\t"+name);
				  sb.append("\t"+msg);
				  sb.append("\t"+writeday+"\n");
			   }// while (rs.next())------------------------------------------------------------
			   
			   if(cnt>0) System.out.println(sb.toString());
			   else { 
				   String searchType = "";

				   switch (menuNo) {
					case "1":
						searchType = "글번호";
						break;
					case "2":
						searchType = "글쓴이";
						break;
					case "3":
						searchType = "글내용";
						break;
					}
				   
				   System.out.println(">> "+searchType+"에는 "+search+"에 해당하는 데이터가 없습니다. <<");
			   }
			   
		  } while(!("4".equals(menu)));		  
		  // end of do-while ------------------------------------------------
		  
		  
		  
		} catch (ClassNotFoundException e) {
			System.out.println(">> obbdjr.6 파일이 없습니다. <<");
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
			
		
		sc.close();
		System.out.println("~~~~~~~~~~ 프로그램 종료 ~~~~~~~~~");

	}

}}
