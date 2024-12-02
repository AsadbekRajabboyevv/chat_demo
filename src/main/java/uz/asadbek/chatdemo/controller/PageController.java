package uz.asadbek.chatdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class PageController {
    @GetMapping
    public String chatPage() {
        return "chat";
    }
}
