package com.spike.community.controller;

import com.spike.community.dto.CommentDTO;
import com.spike.community.dto.QuestionDto;
import com.spike.community.enums.CommentTypeEnum;
import com.spike.community.service.CommentService;
import com.spike.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDto questionDto = questionService.getById(id);

        List<QuestionDto> relatedQuestions = questionService.selectRelated(questionDto);

        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.QUESTION);

        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDto);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }

    @GetMapping("/del/{id}")
    public String deleteQuestion(@PathVariable(name = "id") Long id){
        questionService.deleteById(id);
        return "redirect:/";
    }
}
