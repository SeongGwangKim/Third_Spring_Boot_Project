package SupplementsWeb.com.controller;

import SupplementsWeb.com.biz.UserBiz;
import SupplementsWeb.com.vo.UserVo;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "LoginConfirm" ,method = {RequestMethod.POST})
    public String login(@RequestParam String userID, @RequestParam UserVo userPassword,
                        Model model, HttpSession session) {
        System.out.println("userID = " + userID);
        System.out.println("userPassword = " + userPassword);

        UserBiz userBiz = new UserBiz();

        System.out.println("컨트롤러니?" + userBiz.checkLoginUser(userID));
        if( userBiz.checkLoginUser(userID).equals(userPassword)) {
            session.setAttribute("user", userID);
            return "main";
        }
        return "login";
    }

    @GetMapping(path="/logout")
    public String login(@NotNull HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/myPage")
    public String myPage() {
        return "myPage";
    }

}
