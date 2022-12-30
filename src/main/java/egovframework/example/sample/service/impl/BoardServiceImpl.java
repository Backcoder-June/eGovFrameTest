package egovframework.example.sample.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.BoardService;
import egovframework.example.sample.service.BoardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("boardServiceImpl")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {
	
	@Resource
	BoardMapper boardMapper; 
	
	

	@Override
	public void save(BoardVO boardVO) throws Exception {
		boardMapper.insertBoard(boardVO);
		
	}
	
	
	
	

}
