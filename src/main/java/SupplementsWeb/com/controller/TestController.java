package SupplementsWeb.com.controller;

import SupplementsWeb.com.biz.UserBiz;
import SupplementsWeb.com.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/viewTest")
    public String input(){
        return "viewTest";
    }

    @GetMapping("/input")
    public String test(@RequestParam String userID, @RequestParam String userPassword,
                       Model model){
        String savePassword = null;
        UserVo userVo = new UserVo();

        UserBiz userBiz = new UserBiz();
//        userVo = userBiz.checkLoginUser(userID);
        savePassword =  userBiz.checkLoginUser(userID);

//        model.addAttribute("userVo", userVo);
        model.addAttribute("savePassword", savePassword);

        return "test";
    }


}
