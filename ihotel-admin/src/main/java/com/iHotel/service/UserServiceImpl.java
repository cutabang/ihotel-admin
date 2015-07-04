package com.iHotel.service;

import javax.inject.Inject;

import com.iHotel.dao.LoginDao;
import com.iHotel.dao.LoginDaoImpl;
import com.iHotel.entity.AdminUser;

public class UserServiceImpl implements UserService {
	@Inject
	LoginDao loginDao;

	public AdminUser login(String userId, String password) throws Exception {
		AdminUser user = null;
		
		user = loginDao.login(userId, password);
		
		return user;
	}

}
