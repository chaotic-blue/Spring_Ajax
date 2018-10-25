package com.company.hellospring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.hellospring.board.BoardDAOMybatis;
import com.company.hellospring.board.BoardDTO;
import com.company.hellospring.emp.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:servlet-context-test.xml")
public class EmpDAOClient {
	
	@Autowired EmpDAO dao;
	@Autowired BoardDAOMybatis boardDao;
	
	@Test
	public void getCnt() {
		
		//게시글 등록
		BoardDTO dto = new BoardDTO();
		dto.setTitle("프로시저 테스트");
		dto.setWriter("문준영");
		dto.setContent("프로시저 테스트 내용");
		boardDao.insertBoardProc(dto);
		System.out.println(dto.getSeq());
		System.out.println(dto.getOut_msg());
		
/*		List<EmpDTO> list = dao.getSalaryTop3();
		for(EmpDTO emp : list) {
		System.out.println(emp.getEmployeeId() + " : " + 
		emp.getSalary());
		}*/
		
/*		EmpDTO dto = new EmpDTO();
		dto.setDepartmentId("110");
		dto.setSalary("7000");
		List<EmpDTO> list = dao.getEmps(dto);
		System.out.println("조회건수: "+ list.size());
		for(EmpDTO emp : list) {
			System.out.println(emp);
		}*/
		
		/*List<Map<String,Object>> list = dao.getEmpDept();
				for(Map<String,Object> emp:list) {
			
		}
		for(int i = 0 ; i < list.size() ; i++) {
			HashMap<String,Object> map = 
					(HashMap<String, Object>) list.get(i);
			System.out.println(map.get("deptName") 
					+ " : " +map.get("fName"));
			//맵의 키값을 읽어 낼때 컬럼명이 들어간다.
		}
		System.out.println(list);*/
		
/*		EmpDTO dto = new EmpDTO();
		dto.setLastName("문준영");
		dto.setEmail("aaaa@ad.s");
		dto.setHireDate("2018/10/18");
		dto.setJobId("IT_PROG");
		dao.insertEmp(dto);
		System.out.println("등록 사원번호 : " + dto.getEmployeeId());*/
		
		
	}
}
