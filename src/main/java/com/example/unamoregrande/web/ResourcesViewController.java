package com.example.unamoregrande.web;

import com.example.unamoregrande.model.view.GrandmasSecretViewModel;
import com.example.unamoregrande.model.view.VideoViewModel;
import com.example.unamoregrande.service.CloudinaryService;
import com.example.unamoregrande.service.GrandmasSecretArticlesService;
import com.example.unamoregrande.service.PicturesService;
import com.example.unamoregrande.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class ResourcesViewController {

    private final VideoService videoService;
    private final GrandmasSecretArticlesService grandmasSecretArticlesService;
    private final CloudinaryService cloudinaryService;
    private final PicturesService picturesService;

    public ResourcesViewController(VideoService videoService, GrandmasSecretArticlesService grandmasSecretArticlesService, CloudinaryService cloudinaryService, PicturesService picturesService) {
        this.videoService = videoService;
        this.grandmasSecretArticlesService = grandmasSecretArticlesService;
        this.cloudinaryService = cloudinaryService;
        this.picturesService = picturesService;
    }

    //     Video page  ---------------------------
//     ---------------------------------------

    @GetMapping("/resources/video")
    public String video(Model model) {

        List<VideoViewModel> viewVideo = videoService.viewVideo();

        model.addAttribute("viewVideo", viewVideo);

        return "video";
    }

    @Transactional
    @DeleteMapping("/deleteUserPictures")
    public String deletePictures(@RequestParam("public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            picturesService.deletePictures(publicId);
        }

        return "redirect:/users/profile";
    }

    @GetMapping("/resources/grandmother")
    public String grandmotherSecret(Model model) {

        List<GrandmasSecretViewModel> articles = grandmasSecretArticlesService.grandmasSecretView();

        model.addAttribute("articles", articles);

        return "grandmother-secrets";
    }

    @GetMapping("/details/{id}")
    public String detailsArticles(@PathVariable("id") Long id, Model model) {

//        if (grandmasSecretArticlesService.findArticlesById(id) == null) {
//            throw new ObjectNotFoundException("Обект с номер " + id + " не е намерен!");
//        }

//        try {
//            int idNumber = Integer.parseInt(id.toString());w
//        } catch (NumberFormatException exception){
//            throw new NumberFormatException("В номера на обекта " + id + " е намерен текст!");
//        }

        model.addAttribute("articles", grandmasSecretArticlesService.findArticlesById(id));

        return "articles-details";
    }


}
