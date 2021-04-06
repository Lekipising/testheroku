// Authors: Liplan Lekipising and catherine Muthoni
package com.autoparts.autoparts.controllers;

import java.util.List;

import javax.validation.Valid;

import com.autoparts.autoparts.classes.Account;
import com.autoparts.autoparts.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    // protect
    @RequestMapping("/productorder")
    public String productorder() {
        return "productorder";
    }

    // protect
    @RequestMapping("/orders")
    public String orders() {
        return "orders";
    }

    // protect
    @RequestMapping("/accounts")
    public String account() {
        return "account";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    // protect
    @RequestMapping("/admin")
    public String admin(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "You are logged in as " + context.getAuthentication().getName() + context.getAuthentication().getAuthorities());
        return "admin";
    }


    @RequestMapping("/adminlogin")
    public String adminlogin() {
        return "loginAdmin";
    }

    // protect
    @RequestMapping("/myaccount")
    public String myaccount(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("message", "You are logged in as " + context.getAuthentication().getName() + context.getAuthentication().getAuthorities());
        return "myaccount";
    }


}
