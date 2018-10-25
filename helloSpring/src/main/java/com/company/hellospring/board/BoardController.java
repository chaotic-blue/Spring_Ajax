package com.company.hellospring.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired //DI(Dependency Injection)
	BoardService boardService; //컨테이너가 자동으로 UserDAO 를 생성해서 주입을 해준다. 즉 new가 필요없음
	
	@RequestMapping("/getBoards.do")
	public String getUsers(Model model) {
		model.addAttribute("list", boardService.getUsers());
		return "user/getBoards";
	}
	
/*	//수정폼
	@RequestMapping("/updateUserForm.do")
	public String updateUserForm(Model model, UserDTO dto) {
		model.addAttribute("user", userService.getUser(dto));
		return "user/updateUser";
	}
	//수정처리
	@RequestMapping("/updateUser.do")
	public String updateUser(Model model, UserDTO dto) {
		model.addAttribute("user", userService.updatetUser(dto));
		return "redirect:/getUsers.do";
	}
	//등록폼
	@RequestMapping("/insertUserForm.do")
	public String insertUserForm() {
		return "user/insertUser";
	}
	
	//등록처리
	@RequestMapping("/insertUser.do")
	public String insertUser(Model model, UserDTO dto) {
		model.addAttribute("user", userService.insertUser(dto));
		return "redirect:/getUsers.do";
	}*/
}
