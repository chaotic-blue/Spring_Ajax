package com.company.hellospring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤 필요없음
		
	UserDTO dto = null;
	List<UserDTO> list = null;	

	//등록
	public int insertUser(UserDTO dto){	
		int r = 0;
		try {
			//1단계 :connect
			conn = DBConnection.getConnection();
			//2단계 : statement
			String sql = "INSERT INTO USERS(ID, PASSWORD, NAME, ROLE) "
					+ "VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//3단계 : 실행	
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());
						
			//4단계 : 결과처리
			r = pstmt.executeUpdate();
			System.out.println(r + "건이 처리됨");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5단계 : 연결해제
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return r; //처리 건수를 받아옴
	}
	
	//단건조회
	public UserDTO getUser(UserDTO dto){
						
		try {
			conn = DBConnection.getConnection();
			
			String sql = "select * from users where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getString("ID"));				
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setName(rs.getString("NAME"));				
				dto.setRole(rs.getString("ROLE"));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5단계 : 연결해제
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}	
	
	//다건조회
	public List<UserDTO> getUsers(){
		list = new ArrayList<UserDTO>();
		
		try {
			
			conn = DBConnection.getConnection();
			
			String sql = "select * from users order by id";
			
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getString("ID"));				
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setName(rs.getString("NAME"));				
				dto.setRole(rs.getString("ROLE"));
			
				list.add(dto); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5단계 : 연결해제
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
