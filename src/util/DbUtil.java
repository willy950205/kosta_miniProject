package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * DB연동을 위한 로드, 연결, 닫기
 * 
 * 
 * */
public class DbUtil{
	/**
	 * 로드  
	 * */
	static {
		
		try {
			Class.forName(DbProperty.DIRVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결 
	 * */
	public static Connection getConnection() throws SQLException{ //이거 호출하는 쪽에서 예외처리한다. 왜냐하면 이거 호출하는 쪽에서도 어차피 에외처리해야하니까.
		return DriverManager.getConnection(DbProperty.URL, DbProperty.USER, DbProperty.PASSWORD);
	}
	
	/**
	 * 닫기(Db관련 사용된 객체를 close()한다. )
	 * (INSERT, UPDATE, DELETE 인 경우)
	 * */
	public static void dbClose(Connection con, Statement stmt) {//Statement가 preparedStatment의 부모다.
		
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
	 * 닫기(Db관련 사용된 객체를 close()한다. )
	 * (SELECT 인 경우)
	 * */
	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {//Statement가 preparedStatment의 부모다.
		dbClose(con, stmt);
		try{
			if(rs != null) rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
