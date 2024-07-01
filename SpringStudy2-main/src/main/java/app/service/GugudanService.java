package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.dao.GugudanDao;
import app.dto.ParamDTO;

@Service
public class GugudanService {
	
	@Autowired
	private GugudanDao gDao;

	public void gugudan(Model model, ParamDTO pd) {
		int s = 0;
		int e = 10;
		
		if(pd.isState()) // 파라메터 유무 확인
		{
			Object obj = pd.getResultMap().get("dan");
			if(obj != null) {
				String dan = obj.toString(); // 파라메터 중 이름이 dan인 값을 가져오기
				switch (dan) 
				{
					case "1":case "2":case "3":
					case "4":case "5":case "6":
					case "7":case "8":case "9":
						s = Integer.parseInt(dan);
						e = s + 1;
				}
			}
		}
		
		model.addAttribute("list1", getData(s, e));		// 반복문으로 데이터 가져오기
		model.addAttribute("list2", gDao.getData(s));	// 데이터베이스로 데이터 가져오기
	}
	
	private List getData(int s, int e) {
		List<List<String>> list = new ArrayList<List<String>>();
		if(s == 0) s = 1;
		for(int i = s; i < e; i++)
		{
			List<String> list2 = new ArrayList<String>();
			for(int j = 1; j < 10; j++)
			{
				String str = i + " * " + j + " = " + (i * j);
				list2.add(str);
			}
			list.add(list2);
		}
		return list;
	}
	
}
