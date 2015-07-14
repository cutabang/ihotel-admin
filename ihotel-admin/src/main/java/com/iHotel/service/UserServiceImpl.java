package com.iHotel.service;


import com.iHotel.dao.LoginDao;
import com.iHotel.dao.LoginDaoImpl;
import com.iHotel.entity.AdminUser;

public class UserServiceImpl implements UserService {
	LoginDao loginDao;

	public AdminUser login(String userId, String password) throws Exception {
		AdminUser user = null;
		loginDao = new LoginDaoImpl();
		
		user = loginDao.login(userId, password);
		
		return user;
	}

}
