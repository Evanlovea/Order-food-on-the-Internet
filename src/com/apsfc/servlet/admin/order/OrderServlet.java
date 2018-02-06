package com.apsfc.servlet.admin.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.dao.OrderDao;
import com.apsfc.po.Order;


/**
 * Servlet implementation class OrderServlet
 */

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id =request.getParameter("id");
	
		String reqtype = request.getParameter("reqtype");
		String url="";
		OrderDao od=new OrderDao();
		if(reqtype.equals("delivery")){
			od.update(Integer.parseInt(id));
			url="./admin/order.jsp";
			response.sendRedirect(url);
		}
        if(reqtype.equals("del")){
			od.delete(Integer.parseInt(id));
			url="./admin/order.jsp";
			response.sendRedirect(url);
		}
        if(reqtype.equals("statistic")){
        	SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd kk:mm",Locale.getDefault());
    		String currentdate = formatter.format(new Date());
    		currentdate=currentdate.substring(0, 10);
    		List<Order> list=null;	
    		list=od.getOrderByDate(currentdate);
    		HttpSession session = request.getSession();
    		session.setAttribute("orderstatistic", list);
    		url="./admin/order_statistic.jsp";
    		response.sendRedirect(url);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String menuname =request.getParameter("menuname");
		String date = request.getParameter("date");
		OrderDao od=new OrderDao();
		List<Order> list=null;	
		if(userid != null && !userid.equals("")){
			list=od.getOrderByUserid(Integer.parseInt(userid));
		}
		if(menuname != null && !menuname.equals("")){
			list=od.getOrderByMenuname(menuname);
		}
		if(date != null && !date.equals("")){
			
			list=od.getOrderByDate(date);
		}

		HttpSession session = request.getSession();
		session.setAttribute("ordersearch", list);
		response.sendRedirect("./admin/order_search.jsp");	
	}

}
