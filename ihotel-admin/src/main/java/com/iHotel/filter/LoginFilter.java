package com.iHotel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iHotel.entity.AdminUser;

public class LoginFilter implements Filter {
	private String loginUri;

	public void destroy() {
		loginUri = null;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletReq = (HttpServletRequest) req;
		HttpServletResponse servletRes = (HttpServletResponse) resp;
		HttpSession session = servletReq.getSession(false);
		
		if (session != null) {
			Object user = session.getAttribute("adminUser");
			
			if (user == null) {
				String path = servletReq.getContextPath();
				servletRes.sendRedirect(path + loginUri);
			}
		}
		
		chain.doFilter(servletReq, servletRes);

	}

	public void init(FilterConfig config) throws ServletException {
		loginUri = config.getInitParameter("loginUri");
	}

	public String getLoginUri() {
		return loginUri;
	}

	public void setLoginUri(String loginUri) {
		this.loginUri = loginUri;
	}

	
}
