package com.apsfc.servlet.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apsfc.dao.NoticeDao;
import com.apsfc.po.Notice;




/**
 * Servlet implementation class NoticeServlet
 */

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id =Integer.parseInt(request.getParameter("id"));
		NoticeDao tdao=new NoticeDao();
		int flag = tdao.delete(id);
		PrintWriter out = response.getWriter();
		if (flag == -1) {
			out.write("<script>alert('删除失败!');window.navigate('./admin/notice.jsp');</script>");
		} else {
			out.write("<script>window.navigate('./admin/notice.jsp');</script>");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name =request.getParameter("name");
		String content = request.getParameter("content");		
		NoticeDao tdao=new NoticeDao();
		Notice notice =new Notice();
		notice.setName(name);
		notice.setContent(content);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		notice.setTimes(formatter.format(new Date()));
		int flag = tdao.add(notice);
		if (flag == -1) {
			out.write("<script>alert('添加失败!');window.navigate('./admin/notice_add.jsp');</script>");
		} else {
			out.write("<script>alert('添加成功!');window.navigate('./admin/notice.jsp');</script>");
		}	
	}

}
