package com.company.hellospring;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOMybatis {	
	
	@Autowired SqlSessionTemplate mybatis;
	//전체조회
	public List<UserDTO> getUsers(UserSearchDTO searchDTO){
		System.out.println("user mybatis 전체 조회========");
		return mybatis.selectList("user.getUsers",searchDTO);
	}
	//건수 조회
	public int getCnt(UserSearchDTO searchDTO) {
		return mybatis.selectOne("user.getCnt",searchDTO);
	}
	//단건조회
	public UserDTO getUser(UserDTO dto){
		System.out.println("user mybatis 단건 조회========");
		return mybatis.selectOne("user.getUser", dto);
	}
	//등록
	public int insertUser(UserDTO dto) {
		System.out.println("user mybatis 등록========");
		return mybatis.insert("user.insertUser", dto);
	}
	//수정
	public int updateUser(UserDTO dto) {
		System.out.println("user mybatis 수정========");
		return mybatis.update("user.updateUser", dto);
	}
	//삭제
	public int deleteUser(UserDTO dto) {
		System.out.println("user mybatis 삭제========");
		return mybatis.delete("user.deleteUser", dto);
	}
}
