package app.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {

	@Autowired
	private SqlSession session;
	
	public List<HashMap> gugudanAll() {
		return session.selectList("sql.all");
	}
	
	public List<HashMap> gugudanOne(int dan) {
		return session.selectList("sql.dan", dan);
	}
	
}
