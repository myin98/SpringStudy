package app.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/s6")
public class Study06 {
	
	@Autowired
	private Study06Service service;

	// Service에서 연산 호출하여 결과값 받아 오기
	@GetMapping("/{value:[1-4]}/{a:[0-9]+}/{b:[0-9]+}")
	public void url(@PathVariable int value ,
					@PathVariable int a , 
					@PathVariable int b) {
	
		String value2 = "";
		
		if(value==1) {	
			value2 = " + ";
		}else if(value==2) {
			value2 = " * ";
		}else if(value==3) {
			value2 = " - ";
		}else if(value==4) {
			value2 = " / ";
		}
	
		String d = a + value2 + b + " =";
		
		log.info("run : {} {} " , d ,service.run(value, a, b));

	}
	
//	// Service에서 연산 호출하여 결과값 받아 오기
//	@GetMapping("/{a}/{b}/{c}/{d}")
//	public void url(@PathVariable int a, @PathVariable int b) {
//		int value = service.run(b);
//		log.info("run() : {} {} {} {} " , value, (a == value));
//
//	}	
	
	
}
