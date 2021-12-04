package com.example.unamoregrande.web;

import com.example.unamoregrande.model.view.GrandmasSecretViewModel;
import com.example.unamoregrande.model.view.VideoViewModel;
import com.example.unamoregrande.service.GrandmasSecretArticlesService;
import com.example.unamoregrande.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ResourcesViewController {

    private final VideoService videoService;
    private final GrandmasSecretArticlesService grandmasSecretArticlesService;

    public ResourcesViewController(VideoService videoService, GrandmasSecretArticlesService grandmasSecretArticlesService) {
        this.videoService = videoService;
        this.grandmasSecretArticlesService = grandmasSecretArticlesService;
    }

    //     Video page  ---------------------------
//     ---------------------------------------

    @GetMapping("/resources/video")
    public String video(Model model) {

        List<VideoViewModel> viewVideo = videoService.viewVideo();

        model.addAttribute("viewVideo", viewVideo);

        return "video";
    }


    @GetMapping("/resources/grandmother")
    public String grandmotherSecret(Model model) {

        List<GrandmasSecretViewModel> articles = grandmasSecretArticlesService.grandmasSecretView();

        model.addAttribute("articles", articles);

        return "grandmother-secrets";
    }

    @GetMapping("/details/{id}")
    public String detailsArticles(@PathVariable Long id, Model model) {


        model.addAttribute("articles", grandmasSecretArticlesService.findArticlesById(id));

        return "articles-details";
    }


}
