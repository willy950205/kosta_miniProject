package service;

import java.sql.SQLException;
import java.util.List;

import DTO.UserDTO;

public interface UserService {
	
	/**
	 * 회원가입
	 * */
	UserDTO signUp(String id, String password, int residence) throws SQLException;
	
	/**
	 * 로그인
	 * */
	UserDTO logIn(String id, String password)throws SQLException;
	
	/**
	 * 나의 거주지 검색
	 * */
	String myResidence(String id) throws SQLException;;
	
	/**
	 * 치안등급 검색
	 * */
	String checkSecurity(int residence) throws SQLException;
	
	/**
	 * 거주지 전출신고
	 * */
	int changeResidence(String id, int residence) throws SQLException;
	
	/**
	 * 지역 치안 상황 상세보기
	 * */
	String checkDetail(String id) throws SQLException;
	
	List<UserDTO> selectAll() throws SQLException;
	
	int deleteID(String id) throws SQLException;
}
