package com.devin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: devin
 * Date: 2020/2/20
 * Time: 12:11
 * Description: No Description
 */
@Controller
public class PageController {

    @GetMapping(value = {"","index"})
    public String getPage() {
        return "Lobby";
    }
}
