package com.apsfc.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;

import javax.servlet.http.Cookie;

import com.apsfc.dao.AdminDao;
import com.apsfc.po.Admin;



@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

	/**
	 * 管理员进行登录
	 * 
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AdminLoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet.
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name").trim();
		String pwd = request.getParameter("pwd").trim();
		//String adminNameString = request.getParameter("name").trim();
		
		
		/**
		 * 有关中文编码的问题
		 * 中文采用的是unicode编码
		 * 而英文采用的是ASCII编码
		 * 所以当COOkie保存中文的时候需要对中文进行编码
		 * 而且从Cookie中取出内容的时候也要进行解码，编码和解码可以使用
		 */
		//解码操作
		//String  pwd =java.net.URLEncoder.encode(passwordString, "UTF-8");
		//String name=URLDecoder.decode(adminNameString, "utf-8");
	/*	String name=java.net.URLEncoder.encode(adminNameString, "UTF-8");
		//System.out.println(name);
		name=java.net.URLEncoder.encode(name,"UTF-8");
		//System.out.println(name);
		name=java.net.URLDecoder.decode(name, "UTF-8");
		//System.out.println(name);
		//System.out.println(java.net.URLDecoder.decode(name, "UTF-8"));
*/		AdminDao ad=new AdminDao();
		Admin admin=ad.login(name,pwd);
		if(admin!=null){
			HttpSession session = request.getSession();
			/**
			 * 将获取到的admin信息储存到session中
			 * 以备后用
			 */
			session.setAttribute("admin", admin);
			String autologin = "";
			//5天内自动登录
			autologin = request.getParameter("AutoLogin");
			if (autologin != null || autologin != "") {
				/**
				 * 设置cookies
				 */
				
				/**
				 * 解决cookies无法存储中文的问题
				 */
				Cookie ck1 = new Cookie("name",java.net.URLEncoder.encode(name,"utf-8")); 
				//Cookie ck1 = new Cookie("name", name);
				Cookie ck2 = new Cookie("pwd", pwd);
				ck1.setMaxAge(60 * 60 * 5*24);
				ck2.setMaxAge(60 * 60 * 5*24);
				response.addCookie(ck1);
				response.addCookie(ck2);
			}
			//不用进行登录直接跳转到管理员主界面
			response.sendRedirect("./admin/main.jsp");
		}else{
			PrintWriter out = response.getWriter();
			out.write("<script>alert('用户名或密码错误，请检查您的相关信息!');window.navigate('./admin/index.jsp');</script>");
		}	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
