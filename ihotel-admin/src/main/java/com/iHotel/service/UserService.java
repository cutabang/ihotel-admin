package com.iHotel.service;

import com.iHotel.entity.AdminUser;

public interface UserService {
    AdminUser login(String userId, String password) throws Exception;
}
