package jdbc.day04;

import java.util.List;

public interface interBoardDAO {
	
	// 게시판 글쓰기
	int write(BoardDTO bdto);
	
	// 글 목록보기
	List<BoardDTO> boardList();
	
}
