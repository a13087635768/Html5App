package com.html5app.users.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.html5app.users.entity.Users;
import com.html5app.users.entity.UsersExample;
import com.html5app.users.entity.UsersExample.Criteria;
import com.html5app.users.mapper.UsersMapper;
import com.html5app.users.service.UsersService;

public class UsersServiceImpl implements UsersService {

	@Resource
	UsersMapper usersMapper;
	
	@Override
	public boolean login(String username, String password) throws Exception {
		UsersExample usersExample =  new UsersExample();
		 Criteria createCriteria = usersExample.createCriteria();
		createCriteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<Users> selectByExample = usersMapper.selectByExample(usersExample);
		if(selectByExample.size()==1){
			return true;
		}else{
		return false;
		}
	}

	public UsersMapper getUsersMapper() {
		return usersMapper;
	}

	public void setUsersMapper(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	
	
}
