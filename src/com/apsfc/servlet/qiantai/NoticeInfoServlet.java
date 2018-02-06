package com.apsfc.servlet.qiantai;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class NoticeInfoServlet
 */
@WebServlet("/servlet/NoticeInfoServlet")
public class NoticeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		
//		Validate vd = new Validate();
//		String id = vd.getUnicode(request.getParameter("id"));
//		HttpSession session = request.getSession();
//		ArrayList notice = (ArrayList) session.getAttribute("notice");
//		for (int i = 0; i < notice.size(); i++) {
//			ArrayList noticeinfo= (ArrayList) notice.get(i);
//			if (id.equals(noticeinfo.get(0))) {
//				session.setAttribute("noticeinfo", noticeinfo);
//				break;
//			}
//		}
//		response.sendRedirect("../qiantai/notice.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
