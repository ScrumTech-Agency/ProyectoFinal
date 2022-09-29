package com.ciclo3.TodoCompleto.Controllers;


import com.ciclo3.TodoCompleto.Models.UsersApplication;
import com.ciclo3.TodoCompleto.Service.ServiceInterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class frontEndController {

    @Autowired
    private ServiceInterfaceUser UserBDX;


    @GetMapping("/")
    public String getIndex(){
        return "indexNew";
    }


    @GetMapping("/loginUser")
    public String getLogin(Model model){
            model.addAttribute("formUsersLogin",new UsersApplication());
            return "loginUser";
    }


    @GetMapping("/forgotPassword")
    public String getforgotPassword(Model model){
        return "forgotPassword";
    }

    @GetMapping("/WelcomeUser")
    public String getWelcomeUser(Model model){
        return "index";
    }



    @GetMapping("/errorLogin")
    public String getErrorLogin(Model model){
        return "ErrorLogin";
    }


}
