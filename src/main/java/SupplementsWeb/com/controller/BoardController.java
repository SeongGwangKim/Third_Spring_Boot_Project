package SupplementsWeb.com.controller;


import SupplementsWeb.com.vo.UserVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
//@RequestMapping("/bbs")
public class BoardController {

    @RequestMapping(value = "/bbs", method = RequestMethod.GET)
    public String bbs(UserVo userVo, HttpServletRequest req,  RedirectAttributes rttr) throws Exception {

        HttpSession session = req.getSession();

        if(userVo == null) {
            session.setAttribute("member", null);
            rttr.addFlashAttribute("msg", false);
        } else {
//            session.setAttribute("member", member);
        }

        return "bbs";
    }

    @GetMapping("/bbs2")
    public String bbs2() {
        return "bbs2";
    }

}
