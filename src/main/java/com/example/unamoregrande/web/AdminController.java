package com.example.unamoregrande.web;

import com.example.unamoregrande.service.StatsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private final StatsService statsService;

    public AdminController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/users/admin")
    public ModelAndView statistics() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stats", statsService.getStats());
        modelAndView.setViewName("admin-panel");
        return modelAndView;
    }

}
