package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/loginPage.do")
	public String loginPage() throws Exception{
		return "member/loginPage";
	}

	@RequestMapping(value="/userPage/userTest.do")
	public String userPage() throws Exception{
		return "member/userPage";
	}
	
	
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home() throws Exception{
		return "member/main";
	}
	
	
	
	


}
