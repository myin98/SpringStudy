package app.study;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/s6")
public class Study06 {
	
	@Autowired
	private Study06Service service;

	// Service에서 연산 호출하여 결과값 받아 오기
	@GetMapping("/{value:[1-4]}/{a:[0-9]+}/{b:[0-9]+}")
	public void url(@PathVariable int value ,
					@PathVariable int a , 
					@PathVariable int b) {
	
		String value2 = "";
		
		if(value==1) {	
			value2 = " + ";
		}else if(value==2) {
			value2 = " * ";
		}else if(value==3) {
			value2 = " - ";
		}else if(value==4) {
			value2 = " / ";
		}
	
		String d = a + value2 + b + " =";
		
		log.info("run : {} {} " , d ,service.run(value, a, b));

	}
	@Autowired
	Study06Dao study06dao;
	
	@GetMapping(value = {"/findlist/{accept:[0-1]}" , "/findlist"})
	public String url(@PathVariable (required = false) Object accept, Model model) {
		log.info("accept : {}" , accept);
		List<Map> list = study06dao.findlist(accept);
		log.info("temp1 LIST SIZE : {} ",list.size());
		for( Map map : list) {
//			int check = 0;
//			if((boolean)map.get("accept")) {
//				check = 1;	
//			}
//			if(accept == check) {			
//			}
			log.info("ROW : {}" , map);
			log.debug("");
			
		}
		model.addAttribute("list", list);
		return "study/s6/list";
		
		
	}
	
	@GetMapping("/new")
	public String newPage() {

		return "study/s6/new";
	}
	
	@GetMapping("/detail/{no:[0-9]+}")
	public String detail(@PathVariable int no , Model model) {
		if(no > 0) {
		Map map = study06dao.findone(no);
		model.addAttribute("map", map);
		return "study/s6/detail";
		}
		return "redirect:/s6/findlist";
	}
	
	@PostMapping("/edit/{no:[0-9]+}")
	public String edit(@PathVariable int no, @RequestParam Map map) {
		service.edit(no,map);
		return "redirect:/s6/detail/" + no;
	}
	
	@GetMapping("/edit/{no:[0-9]+}/{accept:[0-1]}")
	public String edit(@PathVariable int no, @PathVariable int accept) {
		log.info("no : {}", no);
		log.info("Accept : {}" , accept);
		service.edit(no, accept);
		//service.edit(no,map);
		return "redirect:/s6/detail/" + no;
	}
	
	@PostMapping("/save")
	public String save(@RequestParam Map map) {
		log.info("Map : {}" , map);
		int no = service.save(map);
		return "redirect:/s6/detail/" + no;
	}
	
	@GetMapping("/test1")
	public String test1() {
		return "study/s6/test1";
	}
	
	
	
	
//	// Service에서 연산 호출하여 결과값 받아 오기
//	@GetMapping("/{a}/{b}/{c}/{d}")
//	public void url(@PathVariable int a, @PathVariable int b) {
//		int value = service.run(b);
//		log.info("run() : {} {} {} {} " , value, (a == value));
//
//	}	
	
	
}
