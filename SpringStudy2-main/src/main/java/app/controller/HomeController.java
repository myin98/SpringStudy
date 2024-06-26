package app.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.service.HomeService;
import app.util.ParameterUtil;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("name", "홍길동");
		return "home";
	}
	
	@GetMapping("/page1")
	public String page1() {
		return "page1";
	}
	
	@Autowired
	private HomeService hs;
	
	@Autowired 
	private ParameterUtil pUtil;
	
	@GetMapping("/page2")
	public String page2(Model model, HttpServletRequest req) {
		hs.page2(model, pUtil.param(req));
		return "page2";
	}
	
	@Autowired
	private SqlSession session;
	
	@GetMapping("/test")
	public String test() {
		int no = session.selectOne("sql.test");
		System.out.println("no : " + no);
		return "";
	}
	
}
