package com.apsfc.servlet.admin.menus;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.apsfc.dao.MenusDao;
import com.apsfc.po.Menus;

/**
 * Servlet implementation class MenuUpdateServlet
 */
@WebServlet("/MenuUpdateServlet")
public class MenuUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuUpdateServlet() {
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
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		String burden=request.getParameter("burden");
		String brief=request.getParameter("brief");
		Float price=Float.parseFloat(request.getParameter("price"));
		Float price1=Float.parseFloat(request.getParameter("price1"));
		
		MenusDao mdao=new MenusDao();
		Menus menus =new Menus();
		menus.setId(id);
		menus.setName(name);
		menus.setTypeid(typeid);
		menus.setBurden(burden);
		menus.setBrief(brief);
		menus.setPrice(price);
		menus.setPrice1(price1);
		int flag = mdao.update(menus);
		if (flag == -1) {
			out.write("<script>alert('更新失败!');window.navigate('./admin/menus.jsp');</script>");
		} else {
			out.write("<script>alert('更新成功!');window.navigate('./admin/menus.jsp');</script>");
		}	
	}

}
