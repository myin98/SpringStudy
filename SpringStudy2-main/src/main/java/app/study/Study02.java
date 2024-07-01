package app.study;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/s2")
public class Study02 {

	// 첫 화면 출력
	@GetMapping("")
	public String page1(Model model, HttpServletRequest req) {
		String a = req.getParameter("a");
//		model.addAttribute("a", a);
//		req.setAttribute("b", "나");
		
		model.addAttribute("c", 1);
		model.addAttribute("d", 5);
		model.addAttribute("e", true);
		
		List<String> list = new ArrayList<String>();
		list.add("가");
		list.add("나");
		list.add("다");
		list.add("라");
		list.add("마");
		model.addAttribute("list", list);
		
		String s = list.get(2);
		// s > "다"
		
		return "study/s2/page1";
	}
	
	// 데이터 요청 후 정보를 돌려 보내는 메소드
	@GetMapping("/data")
	public String data(RedirectAttributes ra, HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		ra.addAttribute("a", "다");
		ra.addFlashAttribute("b", "라");
		return "redirect:/s2/";
	}
	
}
