package com.company.hellospring.emp;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
	
	@Autowired SqlSessionTemplate mybatis;
	//empMapper.xml의 아이디 명과 EmpDAO 메서드 명을 같이 해주면 보기 쉽다.
	public int getCnt() {
		return mybatis.selectOne("emp.getCnt");
	}
	public List<EmpDTO> getSalaryTop3() {
		return mybatis.selectList("emp.getSalaryTop3");
	}
	public List<EmpDTO> getEmps(EmpDTO dto) {
		return mybatis.selectList("emp.getEmps",dto);
	}
	public List<Map<String,Object>> getEmpDept(){
		return mybatis.selectList("emp.getEmpDept");
	}
	public int insertEmp(EmpDTO dto){
		int r = mybatis.insert("emp.insertEmp",dto);
		System.out.println(dto.getEmployeeId());
		return r;
	}
}