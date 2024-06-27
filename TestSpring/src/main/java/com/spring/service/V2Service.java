package com.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.TempDaolmp;
import com.spring.dto.TempDTO;

@Service
public class V2Service  {

	@Autowired
	private TempDaolmp dao;
	
	public TempDTO save(HttpServletRequest req) {
		String title = req.getParameter("title");
		String content = req.getParameter("contetn");		
		return dao.save(TempDTO.builder().title(title).content(content).build());

	}
	
	public void findAll(Model model, HttpServletRequest req) {
		String type = req.getParameter("type");
		boolean accept = false;
		if(type != null || !"".equals(type)) {
			accept = ("1".equals(type)) ? true : false;
		}
		model.addAttribute("list", dao.findAll(TempDTO.builder().type(type).accept(accept).build()));
	}
}
