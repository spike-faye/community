package com.spike.community.controller;

import com.spike.community.dto.PaginationDTO;
import com.spike.community.dto.QuestionDto;
import com.spike.community.mapper.QuestionMapper;
import com.spike.community.mapper.UserMapper;
import com.spike.community.model.Question;
import com.spike.community.model.User;
import com.spike.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * created by
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PaginationDTO pagination = questionService.list(page,size);

        model.addAttribute("pagination", pagination);
        return "index";
    }
}
