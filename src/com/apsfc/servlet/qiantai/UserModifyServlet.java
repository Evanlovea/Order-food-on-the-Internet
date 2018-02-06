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

/**
 * Servlet implementation class UserModifyServlet
 */
@WebServlet("/UserModifyServlet")
public class UserModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifyServlet() {
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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
    	User user=new User();
    	user=(User)session.getAttribute("user");
		user.setId(Integer.parseInt(request.getParameter("id").trim()));
		user.setPwd(request.getParameter("pwd").trim());
		user.setAge(Integer.parseInt(request.getParameter("age").trim()));
		user.setRealname(request.getParameter("realname").trim());
		user.setCard(request.getParameter("card").trim());
		user.setAddress(request.getParameter("address").trim());
		user.setPhone(request.getParameter("phone").trim());
		user.setEmail(request.getParameter("email").trim());
		user.setCode(request.getParameter("code").trim());
		UserDao ud=new UserDao();
		int flag=ud.update(user);
		PrintWriter out = response.getWriter();
		if (flag == -1) {
			out.write("<script>alert('对不起,修改未成功!');window.navigate('./qiantai/center.jsp');</script>");
		} else {
    		session.setAttribute("user", user);
			out.write("<script>alert('恭喜您,修改成功!');window.navigate('./qiantai/index.jsp');</script>");
		}
	}

}
