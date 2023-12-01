package com.kholo.FlyAway.controllers;
import com.kholo.FlyAway.models.Admin;
import com.kholo.FlyAway.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins/all")
    public String getAllAdmins(Model model) {
        List<Admin> admins = adminService.getAllAdmins();
        model.addAttribute("admins", admins);
        return "admins";
    }

   
}
