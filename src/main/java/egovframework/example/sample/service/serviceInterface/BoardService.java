package egovframework.example.sample.service.serviceInterface;

import java.util.List;

import egovframework.example.sample.service.entities.BoardVO;

public interface BoardService {
	
	void save(BoardVO boardVO) throws Exception;

	List<BoardVO> getAllBoard() throws Exception;

	BoardVO getOneBoard(long id) throws Exception;

	void updateBoard(BoardVO boardVO);

	void deleteBoard(long id);

}
