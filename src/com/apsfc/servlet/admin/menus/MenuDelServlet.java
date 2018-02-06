package com.apsfc.servlet.admin.menus;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.apsfc.dao.MenusDao;

/**
 * Servlet implementation class MenuDelServlet
 */
@WebServlet("/MenuDelServlet")
public class MenuDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDelServlet() {
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
		MenusDao mdao=new MenusDao();
		
		int flag = mdao.delete(id);
		PrintWriter out = response.getWriter();
		if (flag == -1) {
			out.write("<script>alert('删除失败!');window.navigate('./admin/menus.jsp');</script>");
		} else {
			out.write("<script>window.navigate('./admin/menus.jsp');</script>");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
