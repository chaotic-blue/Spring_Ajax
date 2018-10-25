package com.company.hellospring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOSpring {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	private final String USER_LIST = "select * from users order by id";
	private final String USER_GET = "select * from users where id = ?";
	private final String USER_INSERT = "INSERT INTO USERS(ID, PASSWORD, NAME, ROLE) "
			+ "VALUES (?,?,?,?)";
	private final String USER_UPDATE ="update users set name=?,password=?,role=? where id = ?";
	private final String USER_DELETE ="DELETE FROM USERS WHERE ID = ?";
	
	//추가
	public int insertUser(UserDTO dto) {
		//매개 변수가 Object[] 배열로 보내도 된다.
		//Object[] arr = {dto.getId(),dto.getPassword(),dto.getName(),dto.getRole()};
		//return jdbcTemplate.update(USER_INSERT, arr);
		
		
		//매개변수가 Object... args (가변인수) 뒤에 몇개든 관계없이 넣을수 있다. 
		return jdbcTemplate.update(USER_INSERT, dto.getId(),dto.getPassword(),dto.getName(),dto.getRole());
	}
	
	//수정
	public int updateUser(UserDTO dto) {		
		
		return jdbcTemplate.update(USER_UPDATE, dto.getName(),dto.getPassword(),dto.getRole(),dto.getId());
	}
	
	//삭제
	public int deleteUser(UserDTO dto) {
		return jdbcTemplate.update(USER_DELETE, dto.getId());
	}
	
	//단건조회
	public UserDTO getUser(UserDTO dto) {
		Object[] arr = {dto.getId()};
		return jdbcTemplate.queryForObject(USER_GET, arr, new UserRowMapper());
	}	
	
	//전체조회
	public List<UserDTO> getUsers(){
		System.out.println("UserDAOSpring 목록 조회 ====");
		return jdbcTemplate.query(USER_LIST, new UserRowMapper());
	}	
}

class UserRowMapper implements RowMapper<UserDTO>{

	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserDTO dto = new UserDTO();
		dto.setId(rs.getString("ID"));				
		dto.setPassword(rs.getString("PASSWORD"));
		dto.setName(rs.getString("NAME"));				
		dto.setRole(rs.getString("ROLE"));
		
		return dto;
	}	
}
