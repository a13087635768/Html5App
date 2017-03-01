package com.html5app.loginfilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

public class LoginFilter  implements Filter{

	/**
	 * @error ÇëµÇÂ¼´íÎóÂë1004
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		StringBuffer pathInfo = request.getRequestURL();
		if(pathInfo.indexOf("login")==-1){
			
			HttpSession session = request.getSession();
			if(session.getAttribute("username")==null){
				PrintWriter out = res.getWriter();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("error","1004");
				out.print(jsonObject.toString());
			}else{
				chain.doFilter(req, res);
			}
			
		}else{
			chain.doFilter(req, res);
		}
	
		
		
	}

}
