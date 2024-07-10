package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.TempDTO;
import com.spring.service.ViewServiceImp;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1")
public class ViewController {

	
	@Autowired
	private ViewServiceImp v1;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model model , HttpServletRequest req) {
		v1.findAll(model, req);
		return "v1/list";
	}
	
	
	
	@GetMapping("/detail")
	public String detail(HttpServletRequest req, Model model) {
		
		if(v1.findOne(req, model)) {
			return "v1/detail";
		} else {
			return "redirect:/v1/list";	
		}
		
	}
	
	@PostMapping("/edit")
	public String edit(HttpServletRequest req) {
		TempDTO dto = v1.edit(req);
		if(dto != null) {
			return "redirect:/v1/detail?no=" + dto.getNo();
		}else {
			
			return "redirect:/v1/list";
		}
	}
	
	@PostMapping("/save")
	public String save(HttpServletRequest req) {
		TempDTO dto = v1.save(req);
		if(dto != null) {
			return "redirect:/v1/detail?no=" + dto.getNo();
		} else {
			return "redirectv1/v1/new";
		}
	}
	
	@GetMapping("/new")
	public String input() {return "v1/new";}

}
