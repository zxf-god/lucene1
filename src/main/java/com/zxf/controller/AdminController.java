package com.zxf.controller;

import com.zxf.entity.Admin;
import com.zxf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    public String login(Admin admin){
        Admin login= adminService.login(admin.getA_name(), admin.getA_password());
        return "add";
    }
}
