package com.iHotel.dao;

import com.iHotel.entity.AdminUser;

public interface LoginDao {
    AdminUser login(String userId, String passwordss) throws Exception;
}
