package devin.controller;

import com.devin.model.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static com.devin.model.dto.TheatreConst.USER_SESSION_KEY;
/**
 * User: devin
 * Date: 2020/2/19
 * Time: 20:59
 * Description: No Description
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {




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
            return "redirect:/admin";
        }
        return "admin/admin_login";
    }
}
