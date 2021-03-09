package my.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyUtil {
	
	public static String addDay(int n) {
		Calendar currentDate = Calendar.getInstance();	// 현재 날짜와 시간을 얻어온다.
		// currentDate.add(Calendar.DATE, 1);	
		// ==> 현재 날짜에서 두번 째 파라미터에 입력해준 숫자만큼 날짜수(Calender.DATE)에서 가감. 
		// ==> 위의 결과는 currentDate 값이 1일 더한 값으로 변한다.
				
		currentDate.add(Calendar.DATE, (n));
		
		SimpleDateFormat sdateFmt = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdateFmt.format(currentDate.getTime());
		// currentDate.getTime() ==> calendar 타입을 date 타입으로 바꿔주는 것
		// .format ==> date 타입을 String 타입으로 바꿔주는 것
	}
}
