package jdbc.day04;

import java.util.*;

public interface interBoardDAO {

	int write(BoardDTO bdto); // 게시판 글쓰기
	
	List<BoardDTO> boardList(); // 글목록보기 
	
	BoardDTO viewContents(Map<String, String> paraMap); // 글내용보기

	void updateViewCount(String boardno); // 조회수 1증가 시키기 

	int writeComment(BoardCommentDTO cmdto, Scanner sc); // 댓글쓰기(jdbc_comment 테이블에 insert) 

	List<BoardCommentDTO> commentList(String boardno);
	// 원글에 대한 댓글을 가져오는 것(특정 게시글 번호에 대한 jdbc_comment 테이블과 jdbc_member 테이블 join)

	int updateBoard(Map<String, String> paraMap); // 글수정하기

	int deleteBoard(Map<String, String> paraMap); // 글삭제하기
	
	 
	
}
