package app.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/study/s1")
public class Study01 {

	// RequestMapping 방식
	@RequestMapping("/url") // url >> /s1/  >> /s1
	public void url1() {
		System.out.println("기본 화면");
//		return "url";
	}
	
	// RequestMapping 특정 메소드 선택 방식
	@RequestMapping(value = "/s", method = RequestMethod.GET)
	public void url2() {
		System.out.println("고정 메소드 처리");
	}
	
	// GetMapping 방식
	@GetMapping("/get")
	public String url3() {
		System.out.println("GET 메소드 호출");
		return "";
	}
	
	// PostMapping 방식
	@PostMapping("/post")
	public void url4() {
		System.out.println("POST 메소드 호출");
	}
	
	@RequestMapping("/data")
	public void data() {
		System.out.println("데이터 메소드 호출");
	}
	
}
