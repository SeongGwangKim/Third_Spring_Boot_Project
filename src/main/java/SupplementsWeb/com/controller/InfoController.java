package SupplementsWeb.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping("/infoENS")
    public String infoENS() {
        return "infoENS";
    }

    @GetMapping("/infoECS")
    public String infoECS() {
        return "infoECS";
    }

    @GetMapping("/infoNGNS")
    public String infoNGNS() {
        return "infoNGNS";
    }

}
