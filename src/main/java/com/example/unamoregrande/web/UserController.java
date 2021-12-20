package com.example.unamoregrande.web;

import com.example.unamoregrande.model.view.GrandmasSecretViewModel;
import com.example.unamoregrande.model.view.PicturesViewModel;
import com.example.unamoregrande.model.view.UserViewModel;
import com.example.unamoregrande.model.view.VideoViewModel;
import com.example.unamoregrande.service.*;
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

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PicturesService picturesService;
    private final GrandmasSecretArticlesService grandmasSecretArticlesService;
    private final VideoService videoService;
    private final CloudinaryService cloudinaryService;

    public UserController(UserService userService, ModelMapper modelMapper, PicturesService picturesService,
                          GrandmasSecretArticlesService grandmasSecretArticlesService,
                          VideoService videoService, CloudinaryService cloudinaryService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.picturesService = picturesService;
        this.grandmasSecretArticlesService = grandmasSecretArticlesService;
        this.videoService = videoService;
        this.cloudinaryService = cloudinaryService;
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
        attributes.addFlashAttribute("username", userName);

        return "redirect:/users/login";
    }


    @GetMapping("/users/profile")
    private String profile(Model model, @AuthenticationPrincipal UnAmoreUsers user) {


        UserViewModel userViewModel = userService.userDetails(user.getUserIdentified());
        List<PicturesViewModel> userPictures = picturesService.onlyPicturesOfUser(user.getUsername());
        List<GrandmasSecretViewModel> userArticles = grandmasSecretArticlesService.onlyArticlesUser(user.getUsername());
        List<VideoViewModel> userVideo = videoService.onlyVideoUser(user.getUsername());

        model.addAttribute("userPictures", userPictures);
        model.addAttribute("userViewModel", userViewModel);
        model.addAttribute("userArticles", userArticles);
        model.addAttribute("userVideo", userVideo);

        return "profile";
    }

}
