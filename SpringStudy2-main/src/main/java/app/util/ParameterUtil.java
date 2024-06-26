package app.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import app.dto.ParamDTO;

@Component
public class ParameterUtil {

	public ParamDTO param(HttpServletRequest req) {
		ParamDTO pDto = new ParamDTO();
		pDto.setState(false);
		Enumeration enu = req.getParameterNames();
		Map<String, String> map = new HashMap<String, String>();
		while(enu.hasMoreElements()) {
			Object name = enu.nextElement();
//			System.out.println("name : " + name);
			String str = req.getParameter(name.toString());
//			System.out.println("value : " + str);
			map.put(name.toString(), str);
			pDto.setState(true);
		}
		pDto.setResultMap(map);
		return pDto;
	}
	
}
