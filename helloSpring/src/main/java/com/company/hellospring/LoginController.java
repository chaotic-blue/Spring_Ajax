package com.company.hellospring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 빈등록, 서블릿이 호출하도록 설정
public class LoginController {

	@Autowired
	UserService userService;

	// 로그인폼
	@RequestMapping(value = { "/login.do", "/in.do" }, method = RequestMethod.GET) // RequestMethod는 enum
	public String login() {
		return "user/login";
	}

	// 로그인 처리
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String loginProc(@ModelAttribute("user") UserDTO dto, @RequestParam(value="id", required=false,defaultValue="admin") String userid, @RequestParam String password,  HttpSession session) {
		System.out.println("==유저 id와 password 임 ^^-=-=-=-=-="+userid+":"+password); //@RequestParam String id id값을 param에 넣어줌 required=true => true면 파라미터 값 무조건 넣어야됨 생략 불가
		UserDTO userDTO = userService.getUser(dto);
		if (userService.getUser(dto) == null || 
				!userDTO.getPassword().equals(dto.getPassword())) {
			return "user/login";
		} else {
			session.setAttribute("login", userDTO);
			return "redirect:getUsers.do";
		}
	}

	// 로그아웃처리
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "user/login";
	}
}
