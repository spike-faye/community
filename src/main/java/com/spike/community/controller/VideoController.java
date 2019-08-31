package com.spike.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by
 */
@Controller
public class VideoController {
    @GetMapping("/videos")
    public String index() {

        return "videos";
    }

    @GetMapping("/video")
    public String index(@RequestParam(name = "aid") String aid,
                        @RequestParam(name = "page",defaultValue = "1") String page,
                        Model model) {
        model.addAttribute("aid",aid);
        model.addAttribute("page",page);
        return "video";
    }
}
