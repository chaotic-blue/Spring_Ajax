package com.company.hellospring.board;

import java.util.List;

public interface BoardService {
		
/*		//등록
		public int insertUser(BoardDTO dto);

		//삭제 
		public int deleteUser(BoardDTO dto);
		//글 상세 조회
		public BoardDTO getUser(BoardDTO dto);
		//글 목록 조회
		 * 
		 * 
*/		
	//수정
/*	public int updateBoard(BoardDTO dto);*/
	
	public List<BoardDTO> getUsers();

	int insertBoard(BoardDTO dto);




}
