package com.apsfc.servlet.qiantai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.dao.UserDao;

import com.apsfc.po.User;



@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqtype = request.getParameter("reqtype");
		String str ="";
		HttpSession session = request.getSession();
		if(reqtype.equals("logout")){
			session.removeAttribute("shoppingcar");
			session.removeAttribute("user");	
		}
		str = "./qiantai/index.jsp";
		response.sendRedirect(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		UserDao ad=new UserDao();
		User ur=ad.login(name,pwd);
		if(ur!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", ur);
			response.sendRedirect("./qiantai/index.jsp");
		}else{
			PrintWriter out = response.getWriter();
			out.write("<script>alert('没有该用户!');window.navigate('./qiantai/login.jsp');</script>");
		}	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
