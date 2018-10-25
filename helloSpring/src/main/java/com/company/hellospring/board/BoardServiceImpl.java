package com.company.hellospring.board;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service //빈등록
public class BoardServiceImpl implements BoardService {

	//Log4jAdvice logAdvice = new Log4jAdvice();
	//LogAdvice logAdvice = new LogAdvice();
	//DI
	//@Autowired UserDAO dao;
	//@Autowired UserDAOSpring dao;
	@Autowired BoardDAOMybatis dao;

	@Override
	public List<BoardDTO> getUsers() {
		//int a = 5/0; //강제로 예외 발생
		//logAdvice.printLogging();	//횡단관심
		return dao.getUsers();		//핵심관심
	}
	
/*	@Override
	public int updateBoard(BoardDTO dto) {		
		return dao.updateBoard(dto);
	}*/
	
}
