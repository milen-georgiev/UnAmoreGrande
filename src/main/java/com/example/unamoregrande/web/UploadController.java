package com.example.unamoregrande.web;

import com.example.unamoregrande.model.binding.GrandmasSecretArticlesBindingModel;
import com.example.unamoregrande.model.binding.PicturesBindingModel;
import com.example.unamoregrande.model.binding.VideoBindingModel;
import com.example.unamoregrande.model.service.GrandmasSecretArticlesServiceModel;
import com.example.unamoregrande.model.service.PicturesServiceModel;
import com.example.unamoregrande.model.service.VideoServiceModel;
import com.example.unamoregrande.service.GrandmasSecretArticlesService;
import com.example.unamoregrande.service.PicturesService;
import com.example.unamoregrande.service.VideoService;
import com.example.unamoregrande.service.impl.UnAmoreUsers;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class UploadController {

    private final PicturesService picturesService;
    private final GrandmasSecretArticlesService grandmasSecretArticlesService;
    private final VideoService videoService;
    private final ModelMapper modelMapper;

    public UploadController(PicturesService picturesService,
                            GrandmasSecretArticlesService grandmasSecretArticlesService,
                            VideoService videoService, ModelMapper modelMapper) {
        this.grandmasSecretArticlesService = grandmasSecretArticlesService;
        this.videoService = videoService;
        this.modelMapper = modelMapper;
        this.picturesService = picturesService;
    }


//  Pictures add -----------------
//  ------------------------------

    @GetMapping("/add/pictures")
    public String addPictures() {
        return "add-pictures";
    }

    @PostMapping("/add/pictures")
    public String addPictures(PicturesBindingModel picturesBindingModel,
                              @AuthenticationPrincipal UnAmoreUsers user) throws IOException {


        PicturesServiceModel picturesServiceModel =
                modelMapper.map(picturesBindingModel, PicturesServiceModel.class);

        picturesService.uploadPictures(picturesServiceModel, user.getUserIdentified());


        return "redirect:/add/pictures";
    }

//  Video add --------------------
//  ------------------------------

    @GetMapping("/add/video")
    public String addVideo(Model model) {

        return "add-video";
    }

    @PostMapping("/add/video")
    public String addVideo(@Valid VideoBindingModel videoBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal UnAmoreUsers user){

        if (bindingResult.hasErrors() ) {
            redirectAttributes
                    .addFlashAttribute("videoBindingModel", videoBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.videoBindingModel",
                            bindingResult);

            return "redirect:/add/video";
        }

        VideoServiceModel videoModel =
                modelMapper.map(videoBindingModel, VideoServiceModel.class);

        videoService.addVideo(videoModel,user.getUserIdentified());

        return "redirect:/resources/video";
    }

//  Articles add -----------------
//  ------------------------------

    @GetMapping("/add/articles")
    public String addArticles(Model model) {


        return "add-articles";
    }

    @PostMapping("/add/articles")
    public String addArticles(@Valid GrandmasSecretArticlesBindingModel grandmasSecretArticlesBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              @AuthenticationPrincipal UnAmoreUsers user) throws IOException {



        if (bindingResult.hasErrors() ) {
            redirectAttributes
                    .addFlashAttribute("grandmasSecretArticlesBindingModel", grandmasSecretArticlesBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.grandmasSecretArticlesBindingModel",
                            bindingResult);

            return "redirect:/add/articles";
        }

        GrandmasSecretArticlesServiceModel grandmasServiceModel =
                modelMapper.map(grandmasSecretArticlesBindingModel, GrandmasSecretArticlesServiceModel.class);

        grandmasSecretArticlesService.addGrandmasSecret(grandmasServiceModel,user.getUserIdentified());


        return "redirect:/resources/grandmother";
    }


    @ModelAttribute("picturesBindingModel")
    public PicturesBindingModel picturesBindingModel() {
        return new PicturesBindingModel();
    }

    @ModelAttribute("videoBindingModel")
    public VideoBindingModel videoBindingModel() {
        return new VideoBindingModel();
    }

    @ModelAttribute("grandmasSecretArticlesBindingModel")
    public GrandmasSecretArticlesBindingModel grandmasSecretArticlesBindingModel () {
        return new GrandmasSecretArticlesBindingModel();
    }

}
