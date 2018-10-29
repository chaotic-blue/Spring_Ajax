package com.company.hellospring.board;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOMybatis {
	
	//전체조회
	@Autowired SqlSessionTemplate mybatis;
	public List<BoardDTO> getUsers(){
		System.out.println("board mybatis 목록 조회========");
		return mybatis.selectList("board.getBoards");
	}
	//
	public int insertBoardProc(BoardDTO dto) {
		System.out.println("board mybatis 프로시저호출========");
		return mybatis.insert("board.insertBoardProc",dto);
	}
	
	public int insertBoard(BoardDTO dto) {
		System.out.println("insertBoard mybatis 프로시저호출========");
		return mybatis.insert("board.insertBoard", dto);
	}
}
