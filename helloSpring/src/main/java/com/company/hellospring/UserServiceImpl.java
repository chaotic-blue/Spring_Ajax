package com.company.hellospring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //빈등록
public class UserServiceImpl implements UserService {

	//Log4jAdvice logAdvice = new Log4jAdvice();
	//LogAdvice logAdvice = new LogAdvice();
	//DI
	//@Autowired UserDAO dao;
	//@Autowired UserDAOSpring dao;
	@Autowired UserDAOMybatis dao;
		
	@Override
	public int insertUser(UserDTO dto) {		
		return dao.insertUser(dto); // 두번의 인설트를 만들어 일부러 에러를 만듬 트랜잭션 처리를 하게 되면 둘다 인설트가 되지 않게 한다.
	}

	@Override
	public UserDTO getUser(UserDTO dto) {
		//logAdvice.printLogging();	//횡단관심
		System.out.println("사용자 목록 조회");
		//int a = 5/0; //강제로 예외 발생
		return dao.getUser(dto);	//핵심관심
	}

	@Override
	public List<UserDTO> getUsers(UserSearchDTO searchDTO) {
		//int a = 5/0; //강제로 예외 발생
		//logAdvice.printLogging();	//횡단관심
		return dao.getUsers(searchDTO);		//핵심관심
	}

	@Override
	public int updatetUser(UserDTO dto) {	
		return dao.updateUser(dto);
	}

	@Override
	public int deleteUser(UserDTO dto) {
		return dao.deleteUser(dto);
	}

	@Override
	public int getCnt(UserSearchDTO searchDTO) {
		return dao.getCnt(searchDTO);
	}
	
}
