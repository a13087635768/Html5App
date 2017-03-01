package com.html5app.headfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
/**
 * 处理访问头文件实现json跨域请求
 * @author SQ
 * 2017年2月22日
 * 上午10:39:28
 */
public class HeadFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse	response=(HttpServletResponse)res;
		response.setContentType("application/json; charset=utf-8");

		response.setHeader("Access-Control-Allow-Origin", "*");

		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

		response.setHeader("Access-Control-Max-Age", "0");

		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

		response.setHeader("Access-Control-Allow-Credentials", "true");

		response.setHeader("XDomainRequestAllowed","1");
		chain.doFilter(req, res);
		
	}

}
