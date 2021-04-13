package test.model;

import java.sql.SQLException;
import java.util.List;

public interface InterTestDAO {

	   // tbl_test01 테이블에 insert 해주는 추상메소드
	   int insertTest(TestVO vo) throws SQLException;
	
	   // tbl_test01 테이블에 select 해주는 추상메소드
	   List<TestVO> selectTest() throws SQLException;
}	
