package app.study;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/s4")
public class Study04 {

	// 경로 변수를 이용하여 화면 출력하기
	@GetMapping(value = {"/v/{page}", "/v/"})
//	@GetMapping("/v/{page}")
	// name = 경로 변수명 지정
	// value = 기본 경로 변수명 지정
	// required = 기본은 true > false (경로 주소가 2개 이상이여야 한다)
	public String url1(@PathVariable(name="page", required = false) String page1) {
		return "study/s4/" + page1;
	}
	
	// 경로 변수에 따라 데이터 화면에 전달하기
	@GetMapping("/data/{name}/{age}")
	public String url2(
//			@PathVariable String name, 
//			@PathVariable int age,
			@PathVariable Map map,
			Model model) {
		System.out.println(map);
		model.addAttribute(map);
//		model.addAttribute("map", map);
//		System.out.println( name );
//		System.out.println( age );
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
		return "study/s4/quest";
	}
	
}
