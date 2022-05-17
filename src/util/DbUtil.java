package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * DB������ ���� �ε�, ����, �ݱ�
 * 
 * 
 * */
public class DbUtil{
	/**
	 * �ε�  
	 * */
	static {
		
		try {
			Class.forName(DbProperty.DIRVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���� 
	 * */
	public static Connection getConnection() throws SQLException{ //�̰� ȣ���ϴ� �ʿ��� ����ó���Ѵ�. �ֳ��ϸ� �̰� ȣ���ϴ� �ʿ����� ������ ����ó���ؾ��ϴϱ�.
		return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORD);
	}
	
	/**
	 * �ݱ�(Db���� ���� ��ü�� close()�Ѵ�. )
	 * (INSERT, UPDATE, DELETE �� ���)
	 * */
	public static void dbClose(Connection con, Statement stmt) {//Statement�� preparedStatment�� �θ��.
		
		try {
			if(con != null) {
				con.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * �ݱ�(Db���� ���� ��ü�� close()�Ѵ�. )
	 * (SELECT �� ���)
	 * */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {//Statement�� preparedStatment�� �θ��.
		dbClose(con, stmt);
		try{
			if(rs != null) rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
