package app.dto;

import java.util.Map;

public class ParamDTO {
	
	private boolean state;
	private Map resultMap;
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Map getResultMap() {
		return resultMap;
	}
	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}
	@Override
	public String toString() {
		return "ParamDTO [state=" + state + ", resultMap=" + resultMap + "]";
	}

}
