package com.html5app.users.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.html5app.datassource.DataSourceContextHolder;
import com.html5app.users.service.UsersService;

import net.sf.json.JSONObject;

@Controller
public class LoginAction {
	@Resource
	UsersService usesrService;
	
	
	/**
	 * 用户登录 session保存
	 * @param username
	 * @param password
	 * @param session
	 * @param response
	 * @throws Exception
	 * @return 账户是否存在
	 */
	@RequestMapping("login")
	public void login(String username, String password,HttpSession session,HttpServletResponse response) throws Exception{
		DataSourceContextHolder.setDbType("dataSource2");
		JSONObject jsonObject = new  JSONObject();
		PrintWriter out = response.getWriter();
		boolean login = usesrService.login(username, password);
		if(login){
			session.setAttribute("username", username);
			jsonObject.put("data", "true");
			out.print(jsonObject.toString());
		}else{
			jsonObject.put("data", "false");
			out.print(jsonObject.toString());
		}
	}


	public UsersService getUsesrService() {
		return usesrService;
	}


	public void setUsesrService(UsersService usesrService) {
		this.usesrService = usesrService;
	}


	

}
