package com.company.hellospring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDAOClient {
	//UserDAO 테스트
	UserDAO dao;
	UserDTO dto;
	@Before
	public void before() {
		dao = new UserDAO();
		dto = new UserDTO();
		dto.setId("user1");
		dto.setPassword("user1");
	}
	
	//등록 테스트
	@Ignore
	@Test
	public void insertTest() {
		assertEquals(1, dao.insertUser(dto));		
	}
	
	//단건 조회 테스트
	@Test
	public void getUserTest() {
			assertEquals("user1", dao.getUser(dto).getPassword());	
	}
	//다건 조회 테스트
	@Test
	public void getUsersTest() {
			assertNotNull("user1", dao.getUsers().get(0).getId());	//not null 체크
	}
}
