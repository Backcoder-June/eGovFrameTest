package egovframework.example.sample.service.impl;

import egovframework.example.sample.service.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoardMapper")
public interface BoardMapper {
	
	void insertBoard(BoardVO boardVO) throws Exception;

}
