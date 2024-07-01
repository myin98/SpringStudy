package app.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
//	@GetMapping
//	@PostMapping
//	@RequestMapping
	@GetMapping("/page4")
	public String page4() {
		// 스프링에 화면 처리 객체인 ViewResolver에 의해서 Prefix와 Suffix 통해 화면을 호출한다.
		// Prefix : "/WEB-INF/views/"   
		// Suffix : ".jsp"
		// Prefix + 리턴 문자열 + Suffix   << 최종 화면 처리가 된다.
		return "page4";
	}
	
	@Autowired
	SqlSession session;
	
	@GetMapping("/dbTest")
	public String dbTest() {
		int no = session.selectOne("sql.test");
		System.out.println("no : " + no);
		return "";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@GetMapping("/result")
	public String result() {
		return "result";
	}
	
}
