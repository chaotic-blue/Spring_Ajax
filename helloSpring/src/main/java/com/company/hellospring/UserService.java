package com.company.hellospring;

import java.util.List;

public interface UserService {
	
	//등록
	public int insertUser(UserDTO dto);
	//수정
	public int updatetUser(UserDTO dto);
	//삭제 
	public int deleteUser(UserDTO dto);
	//글 상세 조회
	public UserDTO getUser(UserDTO dto);
	//글 목록 조회
	public List<UserDTO> getUsers(UserSearchDTO searchDTO);
	//단건조회
	public int getCnt(UserSearchDTO searchDTO);
	
	
}
