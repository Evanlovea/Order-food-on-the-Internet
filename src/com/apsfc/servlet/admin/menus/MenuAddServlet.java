package com.apsfc.servlet.admin.menus;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.apsfc.dao.MenusDao;
import com.apsfc.po.Menus;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class MenuAddServlet
 */
@WebServlet("/MenuAddServlet")
public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServletConfig config;
	/**
	 * Constructor of the object.
	 */
	final public void init(ServletConfig config) throws ServletException
	{
		this.config = config;
	}
	final public ServletConfig getServletConfig()
	{
		return config;
	}
    public MenuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = "";
		String burden = "";
		String price = "";
		String price1 = "";
		String brief = "";
		String typeid = "";
//	 上传图片插件调用
		SmartUpload mySmartUpload = new SmartUpload();
		mySmartUpload.initialize(config,request,response);
		try {
			/**
			 * 从表单获取参数
			 */
			mySmartUpload.upload();
			name = mySmartUpload.getRequest().getParameter("name").trim();
			burden = mySmartUpload.getRequest().getParameter("burden").trim();
			price = mySmartUpload.getRequest().getParameter("price").trim();
			price1 = mySmartUpload.getRequest().getParameter("price1").trim();
			brief = mySmartUpload.getRequest().getParameter("brief").trim();
			typeid = mySmartUpload.getRequest().getParameter("typeid").trim();
			SmartFile file = mySmartUpload.getFiles().getFile(0);
			Menus menus=new Menus();
			menus.setName(name);
			menus.setTypeid(Integer.parseInt(typeid));
			menus.setBurden(burden);
			menus.setBrief(brief);
			menus.setPrice(Integer.parseInt(price));
			menus.setPrice1(Integer.parseInt(price1));
			menus.setImgpath("img/"+file.getFileName());
			/**
			 * 与数据进行交互，返回-1失败
			 */
			MenusDao md=new MenusDao();
			int flag = md.add(menus);
			if (flag == -1) {
				/**
				 * 添加失败
				 */
				out.write("<script>alert('添加失败!');window.navigate('./admin/menus_add.jsp');</script>");
			} else {
				/**
				 * 保存图片，进行跳转
				 */
				mySmartUpload.save("/img");
				out.write("<script>alert('添加成功!');window.navigate('./admin/menus.jsp');</script>");
			}	
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}
	
	

}
