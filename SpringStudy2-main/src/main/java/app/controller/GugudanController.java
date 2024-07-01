package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.service.GugudanService;
import app.util.ParameterUtil;

@Controller
public class GugudanController {
	
	@Autowired
	private GugudanService gs;
	
	@Autowired
	private ParameterUtil pu;

	@GetMapping("/gugudan")
	public String gugudan(Model model, HttpServletRequest req) {
		gs.gugudan(model, pu.param(req));
		return "page3";
	}
	
}
