package egovframework.example.sample.web;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.example.sample.service.BoardService;
import egovframework.example.sample.service.BoardVO;

@Controller
public class DeptController {
	
	@Resource(name="boardVO")
	public BoardVO boardVO;
	@Resource(name="boardService")
	public BoardService boardService;

	@RequestMapping(value="/write.do", method=RequestMethod.GET )
	public String writingForm() {
		
		return "dept/deptWrite";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST )
	public String writingProcess(BoardVO boardVO) throws Exception {
		boardService.save(boardVO);
		
		return "redirect:/write.do";
	}
	

}
