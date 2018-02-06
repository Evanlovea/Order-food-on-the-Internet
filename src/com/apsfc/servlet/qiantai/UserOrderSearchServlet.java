package com.apsfc.servlet.qiantai;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.dao.OrderDao;
import com.apsfc.po.Order;
import com.apsfc.po.User;


/**
 * Servlet implementation class UserOrderSearchServlet
 */
@WebServlet("/UserOrderSearchServlet")
public class UserOrderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String delivery = request.getParameter("delivery");
		OrderDao od = new OrderDao();
		List<Order> list = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userid = user.getId();
		if (delivery!=null) {
			if (delivery.equals("0")) {
				list = od.getOrderByDelivery(userid, 0);
				session.setAttribute("userorder", list);
				response.sendRedirect("./qiantai/order.jsp");
				return;
			}
			if (delivery.equals("1")) {
				list = od.getOrderByDelivery(userid, 1);
				session.setAttribute("userorder", list);
				response.sendRedirect("./qiantai/order.jsp");
				return;
			}
		} else {
			list = od.getOrderByUserid(userid);
			session.setAttribute("userorder", list);
			response.sendRedirect("./qiantai/order.jsp");
			return;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String menuname =request.getParameter("menuname");
		String date = request.getParameter("date");
		OrderDao od=new OrderDao();
		List<Order> list=null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userid =user.getId();
		if(menuname != null && !menuname.equals("")){
			list=od.getOrderByMenuname(userid,menuname);
		}
		if(date != null && !date.equals("")){
			
			list=od.getOrderByDate(userid,date);
		}
		session.setAttribute("userorder", list);
		response.sendRedirect("./qiantai/order.jsp");	
		
		
		
//		Validate vd = new Validate();
//	    String menuname = vd.getUnicode(request.getParameter("menuname"));
//		String date = vd.getUnicode(request.getParameter("date"));
//		String delivery = vd.getUnicode(request.getParameter("delivery"));
//		
//		HttpSession session = request.getSession();
//		if(session.getAttribute("login") != null && !session.getAttribute("login").equals("")){
//            ArrayList userinfo = (ArrayList)session.getAttribute("login");
//            String userid = (String)userinfo.get(0);
//            if (userid != null && !userid.equals("")) {
//		        String sql = "select a.id as userid,b.id as menuid,c.id as orderid,realname,phone,address,b.name as menuname,menusum,price1,times,c.delivery as delivery from users a,menus b,orders c where a.id=c.userid and b.id=c.menuid ";
//		        String[] args = {"userid","menuid","orderid","realname","phone","address","menuname","menusum","price1","times","delivery"};
//			    sql += "and a.id='" + userid + "'";
//
//			    if (menuname != null && !menuname.equals("")) {
//				   sql += "and b.name like '%" + menuname + "%'";
//			    }
//			    if (date != null && !date.equals("")) {
//
//				   sql += "and c.times like '%" + date + "%'";
//			    }
//				if (delivery != null && !delivery.equals("")) {
//					if (delivery.equals("1")) {
//
//						sql += "and c.delivery = '1'";
//					}
//					if (delivery.equals("0")) {
//						sql += "and c.delivery = '0'";
//					}
//				}
//			sql+="order by c.times";
//			SelectBean sb = new SelectBean();
//			ArrayList al = sb.select(sql, args);
//			session.setAttribute("orderbyuser", al);
//			response.sendRedirect("../qiantai/order.jsp");
//		}
		
		
//		}
	}

}
