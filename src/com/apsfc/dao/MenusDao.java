package com.apsfc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apsfc.po.Menus;
import com.apsfc.util.DBConn;

public class MenusDao {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private int totalpage = 0;
	private int currentpage = 0;

	public int getTotalpage() {
		return totalpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public List<Menus> pageList(int page, int size) {
		List<Menus> menuslist = new ArrayList<Menus>();
		String sql = "SELECT COUNT(*) FROM menus;";
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			int totalcount = 0;
			if (rs.next()) {
				totalcount = rs.getInt(1);
			}
			if (totalcount != 0) {
				if (totalcount % size == 0) {
					totalpage = totalcount / size;
				} else {
					totalpage = totalcount / size + 1;
				}
				int pagesize = 0;
				currentpage = page;
				if (page < 1) {
					currentpage = 1;
				}
				if (page > totalpage) {
					currentpage = totalpage;
				}
				if (currentpage == totalpage && totalcount % size != 0) {
					pagesize = totalcount % size;
				} else {
					pagesize = size;
				}
				int start = (currentpage - 1) * size;
				sql = "select a.id as id,a.name as name,typeid,b.name as typename,burden,price,sums,price1,sums1 ,brief,imgpath as imgpath from  menus a,types b where a.typeid=b.id order by a.sums1 desc limit "
						+ start + "," + pagesize + ";";
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Menus menus = new Menus();
					menus.setId(Integer.parseInt(rs.getString("id")));
					menus.setName(rs.getString("name"));
					menus.setTypeid(Integer.parseInt(rs.getString("typeid")));
					menus.setTypename(rs.getString("typename"));
					menus.setBurden(rs.getString("burden"));
					menus.setBrief(rs.getString("brief"));
					menus.setPrice(Float.parseFloat(rs.getString("price")));
					menus.setSums(Integer.parseInt(rs.getString("sums")));
					menus.setPrice1(Float.parseFloat(rs.getString("price1")));
					menus.setSums1(Integer.parseInt(rs.getString("sums1")));
					menus.setImgpath(rs.getString("imgpath"));
					menuslist.add(menus);
				}
			}
		} catch (SQLException e) {
			// TODO
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return menuslist;
	}
	
	public List<Menus> select() {
		List<Menus> menuslist = new ArrayList<Menus>();
		conn = DBConn.getConn();
		try {
			String sql = "";
			sql = "select a.id as id,a.name as name,typeid,b.name as typename,burden,price,sums,price1,sums1 ,brief,imgpath as imgpath from  menus a,types b where a.typeid=b.id order by a.sums1 desc";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Menus menus = new Menus();
				menus.setId(Integer.parseInt(rs.getString("id")));
				menus.setName(rs.getString("name"));
				menus.setTypeid(Integer.parseInt(rs.getString("typeid")));
				menus.setTypename(rs.getString("typename"));
				menus.setBurden(rs.getString("burden"));
				menus.setBrief(rs.getString("brief"));
				menus.setPrice(Float.parseFloat(rs.getString("price")));
				menus.setSums(Integer.parseInt(rs.getString("sums")));
				menus.setPrice1(Float.parseFloat(rs.getString("price1")));
				menus.setSums1(Integer.parseInt(rs.getString("sums1")));
				menus.setImgpath(rs.getString("imgpath"));
				menuslist.add(menus);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return menuslist;
	}

	public int add(Menus menus) {
		String sql = "";
		sql = "insert into menus(name,typeid,burden,brief,price,price1,imgpath)"
				+ " values('"
				+ menus.getName()
				+ "',"
				+ menus.getTypeid()
				+ ",'"
				+ menus.getBurden()
				+ "','"
				+ menus.getBrief()
				+ "',"
				+ menus.getPrice()
				+ ","
				+ menus.getPrice1()
				+ ",'"
				+ menus.getImgpath() + "')";
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

	public int update(Menus menus) {
		String sql = "";
		sql = "update menus set name='" + menus.getName() + "',typeid="
				+ menus.getTypeid()+ ",burden='" + menus.getBurden() + "',brief='"
				+ menus.getBrief() + "',price=" + menus.getPrice() + ",price1="
				+ menus.getPrice1() 
				+ " where id=" + menus.getId();
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
		sql = "delete from menus where id=" + id;
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
	public Menus getMenusById(int id) {
		String sql = "select a.id as id,a.name as name,typeid,b.name as typename,burden,price,sums,price1,sums1 ,brief,imgpath as imgpath from  menus a,types b where a.typeid=b.id and a.id="+id;
		conn = DBConn.getConn();
		Menus menus=null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()){
				menus = new Menus();
				menus.setId(Integer.parseInt(rs.getString("id")));
				menus.setName(rs.getString("name"));
				menus.setTypeid(Integer.parseInt(rs.getString("typeid")));
				menus.setTypename(rs.getString("typename"));
				menus.setBurden(rs.getString("burden"));
				menus.setBrief(rs.getString("brief"));
				menus.setPrice(Float.parseFloat(rs.getString("price")));
				menus.setSums(Integer.parseInt(rs.getString("sums")));
				menus.setPrice1(Float.parseFloat(rs.getString("price1")));
				menus.setSums1(Integer.parseInt(rs.getString("sums1")));
				menus.setImgpath(rs.getString("imgpath"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return menus;
	}
	
	

}
