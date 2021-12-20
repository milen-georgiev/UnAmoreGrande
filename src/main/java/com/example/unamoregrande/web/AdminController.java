package com.example.unamoregrande.web;

import com.example.unamoregrande.model.binding.AddAdminBindingModel;
import com.example.unamoregrande.service.StatsService;
import com.example.unamoregrande.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AdminController {

    private final StatsService statsService;
    private final UserService userService;

    public AdminController(StatsService statsService, UserService userService) {
        this.statsService = statsService;
        this.userService = userService;
    }

    @GetMapping("/users/admin")
    public ModelAndView statistics() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("stats", statsService.getStats());
        modelAndView.setViewName("admin-panel");
        return modelAndView;
    }

    @PostMapping("/users/admin")
    public String addAdmin (@Valid AddAdminBindingModel addAdminBindingModel) {
        userService.addAdmin(addAdminBindingModel.getUsername());

//        UserViewModel user = userService.userDetails(username);
//
//        if (user.getRoles().contains(RoleNameEnum.ADMIN)) {
//            modelAndView.addObject("adminInfo", "Вие добавихте " +
//                    username + " като администратор!");
//            modelAndView.setViewName("admin-panel");
//        }

        return "redirect:/users/admin";
    }

    @ModelAttribute("addAdminBindingModel")
    public AddAdminBindingModel userModel() {
        return new AddAdminBindingModel();
    }

}
