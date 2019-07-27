package com.spike.community.controller;

import com.spike.community.dto.CommentDTO;
import com.spike.community.dto.ResultDTO;
import com.spike.community.exception.CustomizeErrorCode;
import com.spike.community.mapper.CommentMapper;
import com.spike.community.model.Comment;
import com.spike.community.model.User;
import com.spike.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){

        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.OkOf();
    }
}
