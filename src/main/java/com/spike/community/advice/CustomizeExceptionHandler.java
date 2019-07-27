package com.spike.community.advice;

import com.alibaba.fastjson.JSON;
import com.spike.community.dto.ResultDTO;
import com.spike.community.exception.CustomizeErrorCode;
import com.spike.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
   ModelAndView handle(HttpServletRequest request, Throwable e, Model model, HttpServletResponse response) {

        String contentType = request.getContentType();

        if ("application/json".equals(contentType)){
            ResultDTO resultDTO;
            //返回json
            if (e instanceof CustomizeException){
                resultDTO = ResultDTO.errorOf((CustomizeException)e);
            }else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYSTEM_ERROR);
            }

            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe) {
            }
            return null;
        }else {
            //做错误页面跳转
            if (e instanceof CustomizeException){
                model.addAttribute("message",e.getMessage());
            }else {
                model.addAttribute("message",CustomizeErrorCode.SYSTEM_ERROR.getMessage());
            }

            return new ModelAndView("error");
        }
    }
}
