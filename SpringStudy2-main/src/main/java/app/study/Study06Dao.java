package app.study;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Study06Dao {
	
	@Autowired
	private SqlSession session;
	
	public List<Map> findlist(Object accept){
		
		return session.selectList("temp1.findlist",accept);
	}
	
	public Map findone(int no) {
		return session.selectOne("temp1.findone" ,no);
	}
	
	public int edit(Map map) {
		return session.update("temp1.edit", map);
	}
	
	public int editaccept(Map map) {
		return session.update("temp1.editaccept", map);
	}
	
	public Map save(Map map) {
		session.insert("temp1.save", map);

		return map;
	}
	
}
