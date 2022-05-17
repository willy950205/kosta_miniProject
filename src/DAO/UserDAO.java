package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.UserDTO;

public interface UserDAO {
	/**
	 * ȸ�������ϱ�
	 * "insert into USERINFO(id, password, residence) values(?, ?, ?)"
	 * 
	 */
	UserDTO signUp(String id, String password, int residence) throws SQLException;
	
	/**
	 * �α����ϱ�
	 */
	
	UserDTO logIn(String id, String password) throws SQLException;
	
	/**
	 * �� ������ �˻�
	 * "select RESIDENCE from USERINFO where id = 'id'"
	 */
	
	String myResidence(String id) throws SQLException;
	
	
	/**
	 * ġ�ȵ�� Ȯ��
	 * "select RESPONSIBILITY from POLICE where xxx"
	 * 
	 */
	
	int checkSecurity(int residence) throws SQLException;
	
	/**
	 * ������ ����
	 */
	
	int changeResidence(String id, int residence) throws SQLException;
	
	/**
	 * ġ�ȵ�� ���γ��� Ȯ��
	 */
	
	String checkDetail(String id) throws SQLException;
	
	
	List<UserDTO> selectAll() throws SQLException;

	int deleteID(String id) throws SQLException;
	
}
