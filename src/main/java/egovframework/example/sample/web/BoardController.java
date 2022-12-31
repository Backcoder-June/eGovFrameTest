package egovframework.example.sample.web;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.entities.BoardVO;
import egovframework.example.sample.service.serviceInterface.BoardService;

@Controller
public class BoardController {
	
	@Resource(name="boardVO")
	public BoardVO boardVO;
	
	@Resource(name="boardServiceImpl")
	public BoardService boardService;

	@RequestMapping(value="/write.do", method=RequestMethod.GET )
	public String writingForm() {
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST )
	public String writingProcess(BoardVO boardVO) throws Exception {
		boardService.save(boardVO);
		
		return "redirect:/write.do";
	}
	
	
	@RequestMapping(value="/allboard.do", method=RequestMethod.GET )
	public String allBoard(Model model) throws Exception {
		List<BoardVO> allBoard = boardService.getAllBoard();
		model.addAttribute("allBoard", allBoard);
		return "board/allboard";
	}
	
	@RequestMapping(value="/{title}/oneboard.do", method=RequestMethod.GET )
	public String oneBoard(@PathVariable("title")String title, Model model) throws Exception {
		System.out.println(title);
		BoardVO oneBoard = boardService.getOneBoard(title);
		model.addAttribute("oneBoard", oneBoard); 
		return "board/oneboard";
	}
	
	
	

}
