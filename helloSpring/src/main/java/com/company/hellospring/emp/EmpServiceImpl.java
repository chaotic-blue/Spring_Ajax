package com.company.hellospring.emp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //빈등록
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDAO dao;
	
	
	@Override
	public List<Map<String, Object>> getEmpChart() {
		
		return dao.getEmpChart();
	}

	@Override
	public List<Map<String, Object>> getEmpDept() {
		// TODO Auto-generated method stub
		return dao.getEmpDept();
	}
	

		

}
