package com.spike.community.controller;

import com.spike.community.mapper.UserMapper;
import com.spike.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * created by
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request){

        //获得cookie数组
        Cookie[] cookies = request.getCookies();
        //得到包含token键值对的cookie，取其token值
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                request.getSession().setAttribute("user",user);
                }
                break;
            }
        }

        return "index";
    }
}
