package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.UserDTO;

public interface UserDAO {
	/**
	 * 회원가입하기
	 * "insert into USERINFO(id, password, residence) values(?, ?, ?)"
	 * 
	 */
	UserDTO signUp(String id, String password, int residence) throws SQLException;
	
	/**
	 * 로그인하기
	 */
	
	UserDTO logIn(String id, String password) throws SQLException;
	
	/**
	 * 내 거주지 검색
	 * "select RESIDENCE from USERINFO where id = 'id'"
	 */
	
	String myResidence(String id) throws SQLException;
	
	
	/**
	 * 치안등급 확인
	 * "select RESPONSIBILITY from POLICE where xxx"
	 * 
	 */
	
	int checkSecurity(int residence) throws SQLException;
	
	/**
	 * 거주지 변경
	 */
	
	int changeResidence(String id, int residence) throws SQLException;
	
	/**
	 * 치안등급 세부내용 확인
	 */
	
	String checkDetail(String id) throws SQLException;
	
	
	List<UserDTO> selectAll() throws SQLException;

	int deleteID(String id) throws SQLException;
	
}
