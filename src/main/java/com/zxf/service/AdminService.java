package com.zxf.service;

import com.zxf.dao.AdminDAO;
import com.zxf.entity.Admin;

public interface AdminService  {
   public Admin login(String name, String password);

}
