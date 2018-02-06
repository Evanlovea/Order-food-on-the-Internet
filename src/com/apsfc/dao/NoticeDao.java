package com.apsfc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.apsfc.po.Notice;
import com.apsfc.util.DBConn;

public class NoticeDao {

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;

	public Notice getNoticeById(int id) {
		String sql = "SELECT * FROM notice t where id="+id;
		conn = DBConn.getConn();
		Notice notice=null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				notice = new Notice();
				notice.setId(Integer.parseInt(rs.getString("id")));
				notice.setName(rs.getString("name"));
				notice.setContent(rs.getString("content"));
				notice.setTimes(rs.getString("times"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return notice;
	}
	
	public List<Notice> select() {
		String sql = "SELECT * FROM notice";
		List<Notice> noticelist = new ArrayList<Notice>();
		conn = DBConn.getConn();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setId(Integer.parseInt(rs.getString("id")));
				notice.setName(rs.getString("name"));
				notice.setContent(rs.getString("content"));
				notice.setTimes(rs.getString("times"));
				noticelist.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, st, rs);
		}
		return noticelist;
	}

	public int update(Notice notice) {
		String sql = "";
		sql = "update notice set name='" + notice.getName()+"',content='"+notice.getContent()+"',times='"+ notice.getTimes()+ "' where id="
				+ notice.getId();
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

	public int add(Notice notice) {
		String sql = "";	
		sql = "insert into notice(name,content,times)" + " values('" + notice.getName() +"','"+notice.getContent()+"','"+notice.getTimes()+ "')";
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
		sql = "delete from notice where id=" + id;
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
