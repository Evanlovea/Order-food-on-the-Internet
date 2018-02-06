package com.apsfc.servlet.qiantai;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.dao.MenusDao;
import com.apsfc.po.Menus;
import com.apsfc.po.ShoppingCart;
/**
 * 
 * @author Evan
 * @description 购物车处理servlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ShoppingServlet() {
		super();
	}

	/**
	 * 销毁方法
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 解决乱码问题
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String menuId = request.getParameter("menuId");// 获取菜单号
		String del = request.getParameter("del");// 获取删除商品的记号
		String del1 = request.getParameter("del1");// 获取删除商品的记号
		String remove = request.getParameter("remove");// 获取清空购物车的记号
		String remove1 = request.getParameter("remove1");// 获取清空购物车的记号
		String url = "";
		HttpSession session = request.getSession();
		//定义餐车List
		List<ShoppingCart> shoppingcar = new ArrayList<ShoppingCart>();
		/**
		 * 如果餐车中信息不为Null,就获取购物车信息
		 * 否则，反馈相关信息，跳转回首页
		 */
		if (session.getAttribute("shoppingcar") != null) {
			shoppingcar = (List<ShoppingCart>) session
					.getAttribute("shoppingcar");// 获取购物车信息
		}else{
			out.write("<script>alert('您的餐车是空的哦!快快去选购吧！');window.navigate('./qiantai/index.jsp');</script>");
		}

		if (menuId != null && !menuId.equals("")) {
			int id = Integer.parseInt(menuId);
			MenusDao md = new MenusDao();
			Menus menu = md.getMenusById(id);
			// 购物车为空时
			if (shoppingcar == null || shoppingcar.size() == 0) {
				
				ShoppingCart sc = new ShoppingCart();
				sc.setId(menu.getId());
				sc.setName(menu.getName());
				sc.setPrice(menu.getPrice1());
				sc.setSums(1);
				shoppingcar.add(sc);
			} else {
				boolean bool = true;
				for (int i = 0; i < shoppingcar.size(); i++) {// 查找是否有相同的商品，有的话数目加1
					ShoppingCart sc = shoppingcar.get(i);
					if (id == sc.getId()) {
						sc.setSums(sc.getSums() + 1);
						bool = false;
						break;
					}
				}
				if (bool) {// 没有的话，加入一个新商品
					ShoppingCart sc = new ShoppingCart();
					sc.setId(menu.getId());
					sc.setName(menu.getName());
					sc.setPrice(menu.getPrice1());
					sc.setSums(1);
					shoppingcar.add(sc);
				}
			}
			//储存session参数，跳转回首页
			session.setAttribute("shoppingcar", shoppingcar);
			url = "./qiantai/index.jsp";
			response.sendRedirect(url);
		}
		if (del != null && !del.equals("") && shoppingcar != null
				&& shoppingcar.size() != 0) {

			shoppingcar.remove(Integer.parseInt(del));// 删除商品
			url = "./qiantai/index.jsp";
			response.sendRedirect(url);
		}
		if (del1 != null && !del1.equals("") && shoppingcar != null
				&& shoppingcar.size() != 0) {

			shoppingcar.remove(Integer.parseInt(del1));// 删除商品
			url = "./qiantai/shoppingcar.jsp";
			response.sendRedirect(url);
		}
		if (remove != null && !remove.equals("")
				&& session.getAttribute("shoppingcar") != null
				&& !session.getAttribute("shoppingcar").equals("")) {
			session.removeAttribute("shoppingcar");// 清空购物车
			url = "./qiantai/index.jsp";
			response.sendRedirect(url);

		}else{
			// remove参数为空时
		}
		if (remove1 != null && !remove1.equals("")
				&& session.getAttribute("shoppingcar") != null
				&& !session.getAttribute("shoppingcar").equals("")) {
			session.removeAttribute("shoppingcar");// 清空购物车
			url = "./qiantai/shoppingcar.jsp";
			response.sendRedirect(url);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request,response);
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
