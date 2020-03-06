package com.devin.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: devin
 * Date: 2020/2/20
 * Time: 12:11
 * Description: No Description
 */

@Api(value = "PageController", tags = {"页面导航"})
@Controller
public class PageController {

    @ApiOperation(value = "基本页面",httpMethod = "get")
    @GetMapping(value = {"","index"})
    public String getPage() {
        return "Lobby";
    }
}
