/**
 * 
 */
package com.spexle.tbk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @작성자 이예빈
 * @작성일 2021. 2. 7.
 * @파일명 DBConnection.java
 * @package_name com.spexle.tbk.dao
 * @description 
 */
public class DBConnection {
	private static DBConnection connection = new DBConnection();
	
//	Connection 생성자를 private하게 만듦 => new 할 수 없음
	private DBConnection() {
	}
	
	public static DBConnection getInstance() {
		return connection;
	}
	
	public Connection getConnection() {
		Connection con	= null;
		String driver	= "oracle.jdbc.driver.OracleDriver";
		String url		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "ora_user";
		String pw		= "hong";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
