package my.day10.e.stringbuilder;

public class MainStringBuilder {

	public static void main(String[] args) {

		String name = "일순신";			//메모리 상에 1개 누적
					name += ",이순신";		//메모리 상에 1개 누적
					name += ",삼순신";		//메모리 상에 1개 누적	
					name += ",사순신";		//메모리 상에 1개 누적
					name += ",오순신";		//메모리 상에 1개 누적
					name += ",육순신";		//메모리 상에 1개 누적
					name += ",칠순신";		//메모리 상에 1개 누적
					name += ",팔순신";		//메모리 상에 1개 누적
					name += ",구순신";		//메모리 상에 1개 누적
					
													//누적된 메모리상의 name은 총 9개 누적
															
		System.out.println(name);
		
		name = "끝";
		System.out.println(name);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		StringBuilder sb = new StringBuilder();
		sb.append("일순신");
		sb.append(",이순신");
		sb.append(",삼순신");
		sb.append(",사순신");
		sb.append(",오순신");
		sb.append(",육순신");
		sb.append(",칠순신");
		sb.append(",팔순신");
		sb.append(",구순신");
		
		System.out.println(sb.toString());
		
		// StringBuilder 의 초기화
		sb.setLength(0);

		sb.append("끝");
		System.out.println(sb.toString());
		
	}

}
