package app.controller.v1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/v1")
public class ViewController {
	
	private String PATH = "v1/";
	private String LIST = "list";
	private String NEW = "new";
	private String DETAIL = "detail";
	private String REDIRECT = "redirect:/".concat(PATH);
	private String PARAM = "?no=";
	
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println(model.getAttribute("type"));
		return PATH.concat(LIST);
	}
	
	@GetMapping("/list/{type}")
	public String list(@PathVariable("type") String type, RedirectAttributes raa) {
		raa.addFlashAttribute("type", type);
		return REDIRECT.concat(LIST);
	}
	
	@GetMapping("/new")
	public String input() {return PATH.concat(NEW);}
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest req) {
		int no = 1; // 데이터베이스에서 전달받은 번호 담아주기
		return REDIRECT.concat(DETAIL).concat(PARAM) + no;
	}
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest req, Model model) {
		if(check(req.getParameter("no"))) return REDIRECT.concat(LIST);
		model.addAttribute("no", req.getParameter("no"));
		return PATH.concat(DETAIL);
	}
	
	@PostMapping("/update")
	public String update(HttpServletRequest req) {
		if(check(req.getParameter("no"))) return REDIRECT.concat(LIST);
		return REDIRECT.concat(DETAIL).concat(PARAM).concat(req.getParameter("no"));
	}
	
	@GetMapping("/accept/{type}")
	public String accept(@PathVariable("type") String type, HttpServletRequest req) {
		if(check(req.getParameter("no"))) return REDIRECT.concat(LIST);
		System.out.println(type);
		return REDIRECT.concat(DETAIL).concat(PARAM).concat(req.getParameter("no"));
	}
	
	private boolean check(String param) {
		if(param == null || "".equals(param)) return true;
		return false;
	}

}
