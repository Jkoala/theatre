package com.devin.web.controller.User;


import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.devin.model.domain.User;
import com.devin.model.dto.JsonResult;
import com.devin.model.enums.ResultCodeEnum;
import com.devin.service.UserService;
import com.devin.util.LocaleMessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.devin.model.dto.TheatreConst.USER_SESSION_KEY;

/**
 * User: devin
 * Date: 2020/2/19
 * Time: 20:59
 * Description: No Description
 */

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private LocaleMessageUtil localeMessageUtil;

    @Autowired
    private UserService userService;


    /**
    *@Description:  导航页面
    *@Param:
    *@return:
    *@date: 2020/2/22
    */
    @GetMapping(value = {"","index"})
    public String index(Model model){
        /*
        * 获取数据
        *
        * */

        return "Lobby";
    }

    /**
     * 处理跳转到登录页的请求
     *
     * @param session session
     * @return 模板路径user/user_login
     */
    @GetMapping(value = "/login")
    public String login(HttpSession session) {
        final User user = (User) session.getAttribute(USER_SESSION_KEY);
        //如果session存在，跳转到后台首页
        if (null != user) {
            return "redirect:/user";
        }
        return "user/user_login";
    }

    @PostMapping(value = "getLogin")
    @ResponseBody
    public JsonResult getLogin(@ModelAttribute("loginName")String loginName,
                               @ModelAttribute("loginPwd")String loginPwd,
                               HttpSession session
                               ){
        //已注册账号 单用户
        User auser = userService.findUser();
        log.info("----------------用户验证------------------");
        log.info(loginName);
        log.info(loginPwd);
        log.info("------------------------------------");
        User user = null;

        if(Validator.isEmpty(loginName)){
            user = userService.userLoginByEmail(loginName, SecureUtil.md5(loginPwd));
        }else{
            //11ef1590a74e1ab26c31a4e13f52d71b
            user = userService.userLoginByName(loginName, SecureUtil.md5(loginPwd));
        }
        //更新登入时间
        //userService.updateUserLoginLast(DateUtil.date());
        //判断对象是否相等
        if(ObjectUtil.equal(auser,user)){
            session.setAttribute(USER_SESSION_KEY,auser);
            userService.updateUserNormal();
            return new JsonResult(ResultCodeEnum.SUCCESS.getCode(), localeMessageUtil.getMessage("code.admin.login.success"));
        }else{
            return new JsonResult(ResultCodeEnum.FAIL.getCode(), localeMessageUtil.getMessage("code.admin.login.failed"));
        }
    }


}
