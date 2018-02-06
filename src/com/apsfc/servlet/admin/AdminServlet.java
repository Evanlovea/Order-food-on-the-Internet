package com.apsfc.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.dao.AdminDao;
import com.apsfc.po.Admin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] ck=request.getCookies();
		if (ck!=null){
			for(int i=0 ;i<ck.length;i++){
				if (ck[i].getName().equals("name")){
					ck[i].setMaxAge(0);
					response.addCookie(ck[i]);
				}
				if (ck[i].getName().equals("pwd")){
					ck[i].setMaxAge(0);
					response.addCookie(ck[i]);
				}
			}
		}
		HttpSession session = request.getSession();
	    session.removeAttribute("admin");
		PrintWriter out = response.getWriter();
		out.write("<script language=javascript>top.location.href='./admin/index.jsp'</script>");
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
		String pwd = request.getParameter("pwd");
		AdminDao adao=new AdminDao();
		Admin ad =new Admin();
		ad.setId(id);
		ad.setName(name);
		ad.setPwd(pwd);
		int flag = adao.update(ad);
		if (flag == -1) {
			out.write("<script>alert('更新信息失败!');window.navigate('./admin/admin_update.jsp');</script>");
		} else {
			HttpSession session = request.getSession();
			session.removeAttribute("admin");
			session.setAttribute("admin", ad);
			out.write("<script>alert('更新信息成功!');window.navigate('./admin/menus.jsp');</script>");
		}
		
	}

}
