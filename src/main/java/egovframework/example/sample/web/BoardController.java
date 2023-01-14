package egovframework.example.sample.web;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.sample.service.entities.BoardVO;
import egovframework.example.sample.service.serviceInterface.BoardService;

@Controller
public class BoardController {
	
	@Resource(name="boardVO")
	public BoardVO boardVO;
	
	@Resource(name="boardServiceImpl")
	public BoardService boardService;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value="/write.do", method=RequestMethod.GET )
	public String writingForm() {
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST )
	public String writingProcess(BoardVO boardVO) throws Exception {
		boardService.save(boardVO);
		
		return "redirect:/allboard.do";
	}
	
	
	@RequestMapping(value="/allboard.do", method=RequestMethod.GET )
	public String allBoard(Model model) throws Exception {
		List<BoardVO> allBoard = boardService.getAllBoard();
		int allBoardCount = allBoard.size();
		model.addAttribute("allBoard", allBoard);
		model.addAttribute("allBoardCount", allBoardCount);
		return "board/allboard";
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/oneboard.do",method=RequestMethod.POST, produces=
	 * {"application/json; charset=utf-8"}) public String oneBoard(long oneboardId,
	 * Model model) throws Exception { BoardVO oneBoard =
	 * boardService.getOneBoard(oneboardId); return "{\"oneBoardTitle\" : \"" +
	 * oneBoard.getTitle() + "\", \"oneBoardContents\" : \"" +
	 * oneBoard.getContents() + "\"}"; }
	 */	
	
	// @ResponseBody => xml jsonView 로 전송 
	@RequestMapping(value="/oneboard.do", method=RequestMethod.POST, produces= {"application/json; charset=utf-8"})
	public ModelAndView oneboardajax(long oneboardId) throws Exception {
		BoardVO oneBoard = boardService.getOneBoard(oneboardId);
		ModelAndView mav = new ModelAndView("jsonView");
		
		if(oneBoard != null) {
			mav.addObject("responseEntity", new ResponseEntity<>(oneBoard, HttpStatus.OK));
		}
		if(oneBoard == null) {
			mav.addObject("responseEntity", new ResponseEntity<>(HttpStatus.BAD_REQUEST));
		}
		
//		mav.addObject("oneBoard", oneBoard);
		
		return mav;
	}
	
	@RequestMapping(value="/{id}/updateboard.do", method=RequestMethod.GET)
	public String updateBoardForm(@PathVariable("id")long id, Model model) throws Exception {
		BoardVO oneBoard = boardService.getOneBoard(id);
		model.addAttribute("oneBoard", oneBoard);
		return "board/updateBoard";
	}
	
	@RequestMapping(value="/{id}/updateboard.do", method=RequestMethod.POST)
	public String updateBoardProcess(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "redirect:/allboard.do"; 
	}
	
	
	@RequestMapping(value="/{id}/deleteboard.do", method=RequestMethod.POST)
	public String deleteBoard(@PathVariable("id")long id) {
		boardService.deleteBoard(id);
		return "redirect:/allboard.do"; 
	}
	
	
	

}
