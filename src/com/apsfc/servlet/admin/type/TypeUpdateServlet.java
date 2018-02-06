package com.apsfc.servlet.admin.type;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.apsfc.dao.TypeDao;
import com.apsfc.po.Type;

/**
 * Servlet implementation class TypeUpdateServlet
 */
@WebServlet("/TypeUpdateServlet")
public class TypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeUpdateServlet() {
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
		TypeDao tdao=new TypeDao();
		Type type =new Type();
		type.setId(id);
		type.setName(name);
		int flag = tdao.update(type);
		if (flag == -1) {
			out.write("<script>alert('对不起,修改未成功!');window.navigate('./admin/type.jsp');</script>");
		} else {
			out.write("<script>alert('恭喜您,修改成功!');window.navigate('./admin/type.jsp');</script>");
		}
	}

}
