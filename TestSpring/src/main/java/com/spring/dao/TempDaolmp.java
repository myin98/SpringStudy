package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

@Repository
public class TempDaolmp {

	@Autowired
	private SqlSession session;
	
	public TempDTO save(TempDTO dto) {
		session.insert("sql.save", dto);
		return dto;
	}
	
	public List<TempDTO> findAll(TempDTO dto) {
	    return session.selectList("sql.findAll", dto);
	}
	
	public TempDTO edit(TempDTO dto) {
		session.insert("sql.", dto);
		return dto;
	}
}
