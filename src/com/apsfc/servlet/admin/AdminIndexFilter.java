package com.apsfc.servlet.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.apsfc.po.Admin;

/**
 * Servlet Filter implementation class AdminIndexFilter
 */
public class AdminIndexFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminIndexFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain

		response.setContentType("text/html");
		response.setCharacterEncoding("uft-8");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();
		String resAddr = "../admin/main.jsp";
		if (session.getAttribute("admin") != ""
				&& session.getAttribute("admin") != null) {
			chain.doFilter(request, response);
			httpResp.sendRedirect(resAddr);
			return;
		} else {
			Cookie[] ck = httpReq.getCookies();
			String name = null;
			String pwd = null;
			if (ck != null) {
				for (int i = 0; i < ck.length; i++) {
					if (ck[i].getName().equals("name")) {
						name = ck[i].getValue();
					}
					if (ck[i].getName().equals("pwd")) {
						pwd = ck[i].getValue();
					}
				}
			}
			if (name != null && pwd != null) {
				Admin admin = new Admin();
				admin.setName(name);
				admin.setPwd(pwd);
				session.setAttribute("admin", admin);
				chain.doFilter(request, response);
				httpResp.sendRedirect(resAddr);
				return;
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
