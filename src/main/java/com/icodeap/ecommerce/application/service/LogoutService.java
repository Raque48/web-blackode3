package com.icodeap.ecommerce.application.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class LogoutService {
    public LogoutService() {
    }

    public void logout(HttpSession httpSession){
        httpSession.removeAttribute("iduser");
    }
}
