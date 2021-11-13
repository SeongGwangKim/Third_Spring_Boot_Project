package SupplementsWeb.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/NewsVideo")
public class NewsVideoController {

    @GetMapping("/newsVideo")
    public String newsVideo() {
        return "newsVideo";
    }

}
