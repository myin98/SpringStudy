package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ViewDaoImp implements ViewDao {
	@Autowired
	private final SqlSession session;
	
	public List<TempDTO> findAll(TempDTO dto){	
		return
		session.selectList("sql.findAll", dto);
	}
	public void accept(TempDTO dto) {
		session.update("sql.accept", dto);
	}
	
	public TempDTO findOne(TempDTO dto) {
		return session.selectOne("sql.findOne", dto);
		
	}
	
	public TempDTO edit(TempDTO dto) {
		session.update("sql.edit", dto);
		return dto;
	}
	
	public TempDTO save(TempDTO dto) {
		session.insert("sql.save", dto);
		return dto;
	}
	private void transaction(int status) {
	    if(status == 1) {
	      session.commit();
	    } else {
	      session.rollback();
	    }
	  }
	
}
