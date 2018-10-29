package com.company.hellospring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.company.hellospring.common.Paging;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired //DI(Dependency Injection)
	UserService userService; //컨테이너가 자동으로 UserDAO 를 생성해서 주입을 해준다. 즉 new가 필요없음
	
	@ModelAttribute("roleMap") // model.addAttribute("roleMap", map),,,, insertUser.jsp 등록, updateUser.jsp 수정에 role사용
	public Map<String, String> roleMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("admin", "관리자");
		map.put("User", "사용자");
		map.put("Super", "최고관리자");
		return map;
	}
	
	
	
	@RequestMapping("/getUsers.do")
	public ModelAndView getUsers(ModelAndView mv, UserSearchDTO searchDTO, Paging paging) {
		
		//조회 할 레코드 건수
		paging.setPageUnit(3);
		
		//현재 페이지번호. 없으면 1page로 설정
		if(paging.getPage() == null) {
			paging.setPage(1);
		}		
		
		//전체 건수
		int total = userService.getCnt(searchDTO);
		paging.setTotalRecord(total);
		//model.addAttribute("paging",paging); //model은 request.setAttribute의 역할을 한다.
		mv.addObject("paging",paging);
		System.out.println(paging);
		//시작 마지막 레코드번호
		searchDTO.setStart(paging.getFirst()); //이렇게 넣어주면 getFirst()에서 계산을 해준다.
		searchDTO.setEnd(paging.getLast());
		//model.addAttribute("list", userService.getUsers(searchDTO));
		mv.addObject("list", userService.getUsers(searchDTO));
		
		mv.setViewName("user/getUsers");
		
		//return "user/getUsers";
		return mv;
		
	}
	//수정폼
	@RequestMapping("/updateUserForm.do/{id}")
	public String updateUserForm(Model model, @PathVariable String id, UserDTO dto) {
		System.out.println("id==============="+id);
		dto.setId(id);
		model.addAttribute("user", userService.getUser(dto));
		return "user/updateUser";
	}
	//수정처리
	@RequestMapping("/updateUser.do")
	public String updateUser(Model model, SessionStatus ss, UserDTO dto) {
		model.addAttribute("user", userService.updatetUser(dto));
		ss.setComplete();
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
	}
	
	@RequestMapping("/getChartData.do")
	@ResponseBody
	public List<Map<String, String>> getChartData() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		//차트에 들어갈 데이터
		map.put("name", "인사");
		map.put("cnt", "5");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("name", "총무");
		map.put("cnt", "10");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("name", "기획");
		map.put("cnt", "20");
		list.add(map);
		return list;
	}
}
