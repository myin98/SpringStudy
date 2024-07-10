package com.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import com.spring.dao.ViewDaoImp;
import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewServiceImp implements ViewService {
	
	
	@Autowired
	private ViewDaoImp dao;
	
	public void findAll(Model model , HttpServletRequest req) {
		
		String type = req.getParameter("type");
		boolean accept = false;
		if(type != null || "".equals(type)) {
			accept = ("1".equals(type)? true : false);
		}
		model.addAttribute("list",dao.findAll(TempDTO.builder().type(type).accept(accept).build()));
	}
	
	public boolean findOne(HttpServletRequest req, Model model) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			String type = req.getParameter("type");
			if(type != null) {
				boolean accept = ("1".equals(type)) ? true : false;
				dao.accept(TempDTO.builder().no(no).accept(accept).build());
		}
		model.addAttribute("dto", dao.findOne(TempDTO.builder().no(no).build()));
		} catch(NumberFormatException e) {
			return false;	
		}
		return true;
	}
	
	public TempDTO edit(HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			return dao.edit(TempDTO.builder().no(no).title(title).content(content).build());
		}
		catch(NumberFormatException e) {
			return null;
		}
		
	}
	
	public TempDTO save(HttpServletRequest req) {
		String title = req.getParameter("title");
		String centent = req.getParameter("content");
		if(title != null || !"".equals(title)) {
		return dao.save(TempDTO.builder().title(title).content(centent).build());
		}
		return null;
	}
	
	
	
}
