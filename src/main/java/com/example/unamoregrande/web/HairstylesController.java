package com.example.unamoregrande.web;

import com.example.unamoregrande.model.binding.FilterBindingModel;
import com.example.unamoregrande.model.view.PicturesViewModel;
import com.example.unamoregrande.service.CloudinaryService;
import com.example.unamoregrande.service.PicturesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class HairstylesController {

    private final PicturesService picturesService;
    private final CloudinaryService cloudinaryService;

    public HairstylesController(PicturesService picturesService, CloudinaryService cloudinaryService) {
        this.picturesService = picturesService;
        this.cloudinaryService = cloudinaryService;
    }

    @PutMapping("/resources/likesHairstyles")
    public String likesHairstyles(@RequestParam("likes") Long id) {

        picturesService.likePictures(id);

        return "redirect:/resources/hairstyles";
    }

    @GetMapping("/resources/hairstyles")
    public String hairstyles(Model model) {

        List<PicturesViewModel> allPictures = picturesService.allPicturesViewHairstyles();

        model.addAttribute("allPictures", allPictures);

        return "hairstyles";
    }

    @PostMapping("/resources/hairstyles")
    public String hairstylesFilter(FilterBindingModel filterBindingModel, Model model) {


        List<PicturesViewModel> allPictures = picturesService
                .filterPicturesViewHairstyles(filterBindingModel.getCategoryStyle());
        model.addAttribute("allPictures", allPictures);

        return "hairstyles";

    }

    @Transactional
    @DeleteMapping("/resources/deleteHairstyles")
    public String delete(@RequestParam("public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            picturesService.deletePictures(publicId);
        }

        return "redirect:/resources/hairstyles";
    }

    @ModelAttribute("filterBindingModel")
    public FilterBindingModel filterBindingModel() {
        return new FilterBindingModel();
    }
}
