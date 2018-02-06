package com.apsfc.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Properties;
/**
 * 
 * @author Evan
 *
 */
//连接数据库
public class DBConn {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Connection getConn() {
		try {

			String url = "jdbc:mysql://localhost:3306/apsfc";
			Properties inf = new Properties();
			inf.setProperty("user", "root");
			inf.setProperty("password", "123456");
			inf.setProperty("useUnicode", "true");
			inf.setProperty("characterEncoding", "UTF-8");
			Connection conn = DriverManager.getConnection(url, inf);
			// conn=DriverManager.getConnection("jdbc:mysql://localhost/apsfc?useUnicode=true&characterEncoding=gb2312","root","123456");
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
/**
 * 
 * @param conn
 * @param st
 * @param rs
 * @Description 关闭数据库
 */
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception ex) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}

	public static void close(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
		if (pst != null) {
			try {
				pst.close();
			} catch (Exception ex) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
	}
}
