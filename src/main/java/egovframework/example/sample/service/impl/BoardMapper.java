package egovframework.example.sample.service.impl;

import java.util.List;

import egovframework.example.sample.service.entities.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardMapper {
	
	void insertBoard(BoardVO boardVO) throws Exception;
	
	List<BoardVO> getAllBoard() throws Exception;

	BoardVO getOneBoard(long id);

	void updateBoard(BoardVO boardVO);

	void deleteBoard(long id);
	
	


}
