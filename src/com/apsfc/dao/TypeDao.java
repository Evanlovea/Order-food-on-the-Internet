package com.apsfc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apsfc.po.Type;
import com.apsfc.util.DBConn;

public class TypeDao {

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;

	public Type getTypeById(int id) {
		String sql = "SELECT * FROM types t where id="+id;
		conn = DBConn.getConn();
		Type type=null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				type = new Type();
				type.setId(Integer.parseInt(rs.getString("id")));
				type.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return type;
	}
	
	public List<Type> select() {
		String sql = "SELECT * FROM types t;";
		List<Type> typelist = new ArrayList<Type>();
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Type type = new Type();
				type.setId(Integer.parseInt(rs.getString("id")));
				type.setName(rs.getString("name"));
				typelist.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return typelist;
	}

	public int update(Type type) {
		String sql = "";
		sql = "update types set name='" + type.getName() + "'where id="
				+ type.getId();
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

	public int add(Type type) {
		String sql = "";
		sql = "insert into types(name)" + " values('" + type.getName() + "')";
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

	public int delete(int id) {
		String sql = "";
		sql = "delete from types where id=" + id;
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
