package jdbc.day04;

public class BoardDTO {	// BoardDTO 가 오라클의 자식 테이블인 jdbc_board(자식테이블)에 해당함.

	private int boardno; 		// 글번호
	private String fk_userid; 	// 작성자아이디
	private String subject; 	// 글제목
	private String contents; 	// 글내용
	private String writeday; 	// 작성일자
	private int viewcount; 		// 조회수 
	private String boardpasswd; //글암호 
	
	// 중요 ★
	private MemberDTO member;   
	// select 용 (jdbc_member 테이블과 jdbc_board 테이블의 JOIN).
	// 글쓴이에 대한 모든 정보
	// MemberDTO 가 오라클의 jdbc_member(부모테이블)에 해당함.
	
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getFk_userid() {
		return fk_userid;
	}
	public void setFk_userid(String fk_userid) {
		this.fk_userid = fk_userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getBoardpasswd() {
		return boardpasswd;
	}
	public void setBoardpasswd(String boardpasswd) {
		this.boardpasswd = boardpasswd;
	}
	public MemberDTO getMember() {
		return member;
	}
	public void setMember(MemberDTO member) {
		this.member = member;
	}
	
}
