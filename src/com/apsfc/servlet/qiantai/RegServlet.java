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

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897539409669341344L;

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
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
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
    	User user=new User();
        user.setName(request.getParameter("name"));
		user.setPwd(request.getParameter("pwd"));
		user.setRealname(request.getParameter("realname"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setSex(request.getParameter("sex"));
		user.setCard(request.getParameter("card"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setCode(request.getParameter("code"));
		UserDao ud=new UserDao();
		int flag=ud.add(user);
		PrintWriter out = response.getWriter();
		if (flag == -1) {
			out.write("<script>alert('对不起,注册未成功!');window.navigate('./qiantai/reg.jsp');</script>");
		} else {
    		session.setAttribute("user", user);
			out.write("<script>alert('恭喜您,注册成功!');window.navigate('./qiantai/index.jsp');</script>");
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
