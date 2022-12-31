package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.entities.BoardVO;
import egovframework.example.sample.service.serviceInterface.BoardService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("boardServiceImpl")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {
	
	@Resource(name="boardMapper")
	BoardMapper boardMapper; 
	
	

	@Override
	public void save(BoardVO boardVO) throws Exception {
		boardMapper.insertBoard(boardVO);
		
	}



	@Override
	public List<BoardVO> getAllBoard() throws Exception {
		return boardMapper.getAllBoard();
	}



	@Override
	public BoardVO getOneBoard(String title) throws Exception {
		return boardMapper.getOneBoard(title);
	}
	
	
	
	
	
	
	
	
	

}
