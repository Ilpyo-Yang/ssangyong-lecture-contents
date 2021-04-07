package chap05.oracle;

import java.sql.SQLException;

public interface InterPersonDAO_03 {
	// 개인성향을 입력(insert)해주는 추상메소드(미완성메소드)
	int personRegister(PersonDTO_02 psdto) throws SQLException;
}
