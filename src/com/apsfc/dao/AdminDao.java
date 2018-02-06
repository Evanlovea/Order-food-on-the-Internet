package com.apsfc.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.apsfc.po.Admin;
import com.apsfc.util.DBConn;


public class AdminDao {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	public Admin login(String name,String pwd) {
		String sql="SELECT * FROM admin;";
		/*try {
			name=java.net.URLEncoder.encode(name,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		Admin ad=null;
		conn = DBConn.getConn();
		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				
				if(name.equals(rs.getString("name"))&&pwd.equals(rs.getString("pwd"))){
					
				    ad=new Admin();
					ad.setId(Integer.parseInt(rs.getString("id")));
					ad.setName(name);
					ad.setPwd(pwd);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return ad;
	}
	
	public int update(Admin admin) {
		String sql = "";
		sql = "update admin set name='" + admin.getName() + "',pwd='"+admin.getPwd()+"' where id="
				+ admin.getId();
		int temp = 0;
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			temp = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			temp = -1;
		} finally {
			DBConn.close(conn, st, rs);
		}
		return temp;
	}
}
