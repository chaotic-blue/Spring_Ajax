package com.company.hellospring;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import polymorphism.coupling.TV;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@Autowired TV tv; 
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) //URL 요청
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		 
//		tv.powerOn();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board.do")
	public String board(UserBean user) { //http://localhost/hellospring/board.do?id=asdasd&pw=111
		System.out.println(user.getId());
		System.out.println(user.getPw());
		//id,pw가 출력된다.
		return "board";
	}		
	
	//json으로 처리하기
	@RequestMapping("/LoginCheck.do")
	@ResponseBody	//data(자바 객체) --> json string
	public HashMap<String, Object> dupcheck(UserBean user){ ///LoginCheck.do?id=chichi
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userid", user.getId());
		if(user.getId().equals("admin")) {
			map.put("result",false);
		}else {
			map.put("result",true);
		}
		return map;
	}	
	
	//xml으로 처리하기
	@RequestMapping("/LoginCheckXml.do")
	@ResponseBody	//data(자바 객체) --> json string
	public UserBean dupcheckXml(UserBean user) {
		if(user.getId().equals("admin")) {
			user.setResult(false);
		}else {
			user.setResult(true);
		}
		return user;
	}
	
}
