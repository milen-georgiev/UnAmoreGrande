package com.example.unamoregrande.web;

import com.example.unamoregrande.model.view.UserViewModel;
import com.example.unamoregrande.service.UserService;
import com.example.unamoregrande.service.impl.UnAmoreUsers;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserLoginController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserLoginController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users/login")
    public String login() {
        return "login";
    }

    @PostMapping("/users/login-error")
    public String failedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
            String userName,
            RedirectAttributes attributes
    ) {

        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username",userName);

        return "redirect:/users/login";
    }


   @GetMapping("/users/profile")
   private String profile(Model model,  @AuthenticationPrincipal UnAmoreUsers user) {

       UserViewModel userViewModel = userService.userDetails(user.getUserIdentified());

       model.addAttribute("userViewModel", userViewModel);

        return "profile";
    }


}
