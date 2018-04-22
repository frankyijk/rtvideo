package me.fansir.rtvideo.web.controller;

import me.fansir.rtvideo.constant.IRequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: fanlinyu
 * @Date 1/25/18
 */
@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "redirect:" + IRequestMapping.API_VIDEO_ALL;
    }
}
