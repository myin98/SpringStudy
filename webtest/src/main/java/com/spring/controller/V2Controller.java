package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.TempDTO;
import com.spring.service.V2Service;

@Controller
@RequestMapping("/v2")
public class V2Controller {

	@Autowired
	private V2Service V2;
	
	
	  @GetMapping("/list") 
	  public String list(Model model, HttpServletRequest req){ 
		  V2.findAll(model, req); 
		  return "v2/list"; 
		  }
	  
	  @PostMapping("/edit")
	  public String edit(HttpServletRequest req) {
		  TempDTO dto = V2.edit(req);
		  if(dto != null) {
			  return "redirect:/v2/detail?no=" + dto.getNo();
		  } else {
			  
			  return "redirect:/v2/list";
		  }
	  }
	  @GetMapping("/new")
	  public String input() {
		  return "v2/new";
	  }
	  
	  @PostMapping("/save")
	  public String save(HttpServletRequest req) {
		  TempDTO dto = V2.save(req);
		  if(dto != null) {
			  return "redirect:/v2/detail?no=" + dto.getNo();
		  } else {  
			  return "redirect:/v2/new";
		  }
	  }
	  
	  @GetMapping("/detail")
	  public String detail(Model model , HttpServletRequest req) {
		  if(V2.findeOne(model, req)) {
			  
			  return "v2/detail";
		  }else {
			  
			  return "redirect:/v2/list";
		  }
	  }
	 
	
	 
	
}
