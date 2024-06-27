package app.study;

import org.springframework.stereotype.Service;

@Service
public class Study06Service {
	
	public int run(int type,int a,int b) {
		if(type == 1) {
			return 합(a,b);
			
		}
		if(type == 2) {
			return 곱(a,b);
			
		}
		if(type == 3) {
			return 빼기(a,b);
			
		}
		if(type == 4) {
			return 나누기(a,b);
			
		}
		return 0;
	}
	
	private int 합(int a,int b) {
		return a + b;
	}
	
	private int 곱(int a,int b) {
		return a * b;
		
	}
	
	private int 빼기(int a,int b) {
		return a - b;
	}
	
	private int 나누기(int a,int b) {
		return a / b;
	}
}
