package com.company.hellospring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.company.hellospring.emp.EmpDTO;
/*
 * List, Set, Map
 */
public class CollectionTest {	
	public static void main(String[] args) {
		//List test
		
		//List<String> list = new List<String>(); 에러 발생 List 는 인터페이스라서 객체를 생성 할수 없다.
		List<String> list = new ArrayList<String>();
		//list.addAll(c) 다른 리스트를 몽땅다 추가 하는것 도 가능하다. 체스에서 사용했었음.
		
		//추가 
		list.add("바나나");
		list.add("사과");
		list.add(0,"오렌지");			
		System.out.println(list);
		
		//변경
		list.set(1, "포도");
		System.out.println(list);
		
		//단건조회
		System.out.println(list.get(1));
		
		//삭제
		list.remove(1);
		System.out.println(list);
		
		//전체조회
		//1.일반 포문
		for(int i = 0 ; i < list.size() ; i++) {
			String temp = list.get(i);
			System.out.println(temp);
		}
		//2.확장 포문
		System.out.println("==========확장 포문 =========");
		for(String temp: list) { // 앞에는 리스트의 타입과 임시 변수명을 적어준다. 뒤에는 프로젝트 타입의 객체 변수를쓴다
			System.out.println(temp);
		}
		//3.iterator
		System.out.println("==========Iterator=========");
		Iterator<String> iter = list.iterator(); //hashNext 해당 요소가 있냐 라는것 next는 다음 요소를 가져 오는것
		while(iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);
		}			
		
		//EmpDTO 타입
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		//추가
		empList.add(new EmpDTO("100","kim","a@b.c","99/11/11","IT"));
		empList.add(new EmpDTO("101","kim","a@b.c","99/11/11","IT"));
		empList.add(new EmpDTO("102","kim","a@b.c","99/11/11","IT"));		
		System.out.println(empList);	
		
		//2.확장 포문
		System.out.println("==========확장 포문 =========");
		for(EmpDTO emp:empList) // 뒤에는 변수명 앞에는 타입과 임시 변수명  
		{
			System.out.println(emp.getEmployeeId() + " " + emp.getLastName());
		}		
		//3.iterator
		System.out.println("==========Iterator=========");
		Iterator<EmpDTO> empIter = empList.iterator(); //hashNext 해당 요소가 있냐 라는것 next는 다음 요소를 가져 오는것
		while(empIter.hasNext()) {	
			EmpDTO emp = empIter.next();			
			System.out.println(emp.getEmployeeId() + " " + emp.getLastName());
		}
		
		// set을 사용해서 로또 만들기
	}
}
