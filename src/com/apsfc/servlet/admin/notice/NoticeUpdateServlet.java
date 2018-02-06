package com.apsfc.servlet.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apsfc.dao.NoticeDao;
import com.apsfc.dao.TypeDao;
import com.apsfc.po.Notice;
import com.apsfc.po.Type;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/NoticeUpdateServlet")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String times=request.getParameter("times");
		NoticeDao ndao=new NoticeDao();
		Notice notice =new Notice();
		notice.setId(id);
		notice.setName(name);
		notice.setContent(content);
		notice.setTimes(times);
		int flag = ndao.update(notice);
		if (flag == -1) {
			out.write("<script>alert('更新失败!');window.navigate('./admin/notice.jsp');</script>");
		} else {
			out.write("<script>alert('更新成功!');window.navigate('./admin/notice.jsp');</script>");
		}
		
		
		
	}

}
