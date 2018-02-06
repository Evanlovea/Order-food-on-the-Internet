package com.apsfc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.apsfc.po.User;
import com.apsfc.util.DBConn;

public class UserDao {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	/**
	 * 
	 * @param name
	 * @param pwd
	 * @return User
	 * 用户登录操作
	 */
	public User login(String name,String pwd) {
		String sql="SELECT * FROM users";
		User ur=null;
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if(name.equals(rs.getString("name"))&&pwd.equals(rs.getString("pwd"))){
				    ur=new User();
					ur.setId(Integer.parseInt(rs.getString("id")));
					ur.setName(name);
					ur.setPwd(pwd);
					ur.setRealname(rs.getString("realname"));
					ur.setSex(rs.getString("sex"));
					ur.setAge(Integer.parseInt(rs.getString("age")));
					ur.setCard(rs.getString("card"));
					ur.setAddress(rs.getString("address"));
					ur.setPhone(rs.getString("phone"));
					ur.setEmail(rs.getString("email"));
					ur.setCode(rs.getString("code"));
					ur.setType(Integer.parseInt(rs.getString("type")));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return ur;
	}
	
	public int add(User user) {
		String sql = "";
		sql = "insert into users(name,pwd,realname,sex,age,card,address,phone,email,code,type)" +" values('" 
		        + user.getName() + "','"
				+ user.getPwd()+ "','" 
		        + user.getRealname() + "','"
				+ user.getSex() + "'," 
		        + user.getAge() + ",'"
				+ user.getCard()+"','"
		        + user.getAddress()+"','"
				+ user.getPhone()+"','"
		        + user.getEmail()+"','"
				+user.getCode()+"',"
				+user.getType()
				+ ")";
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
	
	
	public int update(User user) {
		String sql = "";
		sql = "update users set name='" + user.getName() + "',pwd='"
				+ user.getPwd()+ "',realname='" + user.getRealname() + "',sex='"
				+ user.getSex() + "',age=" + user.getAge() + ",card='"
				+ user.getCard()+"',address='" +user.getAddress()+"',phone='"
				+ user.getPhone()+"',email='"+user.getEmail()+"',code='"
				+user.getCode()+"',type="
				+user.getType()
				+ " where id=" + user.getId();
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
	public User getUserById(int id) {
		String sql = "SELECT * FROM users t where id="+id;
		conn = DBConn.getConn();
		User ur=null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ur = new User();
				ur.setId(Integer.parseInt(rs.getString("id")));
				ur.setName(rs.getString("name"));
				ur.setPwd(rs.getString("pwd"));
				ur.setRealname(rs.getString("realname"));
				ur.setSex(rs.getString("sex"));
				ur.setAge(Integer.parseInt(rs.getString("age")));
				ur.setCard(rs.getString("card"));
				ur.setAddress(rs.getString("address"));
				ur.setPhone(rs.getString("phone"));
				ur.setEmail(rs.getString("email"));
				ur.setCode(rs.getString("code"));
				ur.setType(Integer.parseInt(rs.getString("type")));
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return ur;
	}
	
	
	
	
	
}
