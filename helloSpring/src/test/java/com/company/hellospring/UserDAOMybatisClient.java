package com.company.hellospring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
public class UserDAOMybatisClient {
	
	@Autowired UserDAOMybatis dao;
	
	@Test
	public void getUserTest() {		
		UserSearchDTO searchDTO = new UserSearchDTO();
		searchDTO.setStart(1);
		searchDTO.setEnd(5);
		
		String[] ids = {"a","b"};
		searchDTO.setIds(ids);
		
/*		searchDTO.setSearchCondition("id");
		searchDTO.setSearchKeyword("b");*/
		
		List<UserDTO> list = dao.getUsers(searchDTO);
		
		for(UserDTO dto : list) {
			System.out.println(dto.getId() + " : "+ dto.getName());
		}
	}
}
