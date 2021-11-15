package SupplementsWeb.com.controller;

import SupplementsWeb.com.biz.UserBiz;
import SupplementsWeb.com.vo.UserVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "LoginConfirm" ,method = {RequestMethod.POST})
    public String login(@RequestParam String userID, @RequestParam String userPassword,
                        Model model, HttpSession session) {
        System.out.println("userID = " + userID);
        System.out.println("userPassword = " + userPassword);
        try {
            if (userID == null || userPassword == null) {
                model.addAttribute("msg", "아이디 또는 비밀번호를 입력해주세요");
                return "login";
            }
            UserVo userVo = new UserVo();
            userVo.setUserID(userID);
            userVo.setUserPassword(userPassword);
//            UserBiz.checkLoginUser(userVo)
            if( userPassword  == userPassword ){
                session.setAttribute("user", userVo);
                return "main";
            }else{
                model.addAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다.");
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
            return "login";
        }
    }

    @GetMapping(path="/logout")
    public String login(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }
}


