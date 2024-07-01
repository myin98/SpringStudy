package app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GugudanDao {

	@Autowired
	private SqlSession session;
	
	public List getData(int dan) {
		return session.selectList("sql.data", dan);
	}
	
}
