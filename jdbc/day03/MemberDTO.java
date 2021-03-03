package jdbc.day03;

// === DTO(Data Transfer Object, 데이터전송(운반)객체) ===
//	      쉽게 말해서 DTO는 테이블의 1개 행(row)을 말한다.
//	      어떤 테이블에 데이터를 insert 하고자 할 때 DTO 에 담아서 보낸다.
//	      또한 어떤 테이블에서 데이터를 select 하고자 할 때도 DTO 에 담아서 읽어온다.

public class MemberDTO {

	// property, attribute, 속성을 정의한다.  => 추상화
	
	private int userseq;
	private String userid;
	private String passwd;
	private String name;
	private String mobile;
	private int point;
	private String registerday; 
	private int status;	// 1 이면 정상, 0 이면 탈퇴
	
	
	public int getUserseq() {
		return userseq;
	}
	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getRegisterday() {
		return registerday;
	}
	public void setRegisterday(String registerday) {
		this.registerday = registerday;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
