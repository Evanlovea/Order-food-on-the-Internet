package com.apsfc.servlet.qiantai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.dao.OrderDao;
import com.apsfc.po.Order;
import com.apsfc.po.ShoppingCart;
import com.apsfc.po.User;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Servlet implementation class UserOrderingServlet
 */
@WebServlet("/UserOrderingServlet")
public class UserOrderingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 解决乱码问题
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		PrintWriter out = response.getWriter();
		if (user != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date=formatter.format(new Date()); // 将日期时间格式化
			List<ShoppingCart> list = (List<ShoppingCart>)session.getAttribute("shoppingcar");
			OrderDao odao=new OrderDao();
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					ShoppingCart sc = list.get(i);
					Order od=new Order();
					od.setUserid(user.getId());
					od.setMenuid(sc.getId());
					od.setPrice1(sc.getPrice());
				    od.setMenusum(sc.getSums());
				    od.setTimes(date);
				    od.setDelivery(0);
				    odao.add(od);
				}
				session.removeAttribute("shoppingcar");
				out.write("<script>alert('订单已提交,稍后将有客服给予确认并派送!');window.navigate('./qiantai/index.jsp');</script>");
				return;
			}else{
				out.write("<script>alert('您的餐车是空的哦!快快去选购吧！');window.navigate('./qiantai/index.jsp');</script>");
			}
		} else {
			out.write("<script>alert('对不起，请登录后再提交订单!');window.navigate('./qiantai/login.jsp');</script>");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
