package devin.controller;

import com.devin.model.enums.ResultCodeEnum;
import devin.model.dto.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * User: devin
 * Date: 2020/2/19
 * Time: 17:25
 * Description: No Description
 */
@Slf4j
@Controller
public class Hello {
    private static final Log logger = LogFactory.getLog(Hello.class);

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String sayHello() {
        return "hello world";
    }

    @RequestMapping(value = "page")
    public ModelAndView getPage(ModelAndView mv) {
        mv.setViewName("Lobby");
        return mv;
    }

//    @ResponseBody
//    public JsonResult getResult(@ModelAttribute("test") String test){
//        log.info(test);
//        return new JsonResult(ResultCodeEnum.SUCCESS.getCode(), localeMessageUtil.getMessage("code.admin.login.success"));
//    }

}
