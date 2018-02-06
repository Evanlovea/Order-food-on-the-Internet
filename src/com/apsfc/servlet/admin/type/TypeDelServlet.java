package com.apsfc.servlet.admin.type;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.apsfc.dao.TypeDao;




/**
 * Servlet implementation class TypeDelServlet
 */
@WebServlet("/TypeDelServlet")
public class TypeDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeDelServlet() {
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
		TypeDao tdao=new TypeDao();
		int flag = tdao.delete(id);
		PrintWriter out = response.getWriter();
		if (flag == -1) {
			out.write("<script>alert('更新失败!');window.navigate('./admin/type.jsp');</script>");
		} else {
			out.write("<script>window.navigate('./admin/type.jsp');</script>");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
