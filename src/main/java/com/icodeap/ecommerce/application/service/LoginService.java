package com.icodeap.ecommerce.application.service;

import org.springframework.stereotype.Service;

import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.domain.UserType;


@Service
public class LoginService {
	
	
    private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    //retorna true si encuentra el user
    public boolean existUser(String email){
        try {
        	userService.findByEmail(email);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    //obtenemos el id del usuario
    public Integer getUserId(String email){
        try{
            return userService.findByEmail(email).getId();
        }catch (Exception e){
            return 0;
        }
    }

    //obtener tipo de usuario
    public UserType getUserType(String email){
        return userService.findByEmail(email).getUserType();
    }

    //obtenemos el user por email
    public User getuser(String email){
        try{
            return userService.findByEmail(email);
        }catch (Exception e){
            return new User();
        }
    }

    //obtenemos el user por id
    public User getUser(Integer id){
        try{
            return userService.findById(id);
        }catch (Exception e){
            return new User();
        }
    }

}
