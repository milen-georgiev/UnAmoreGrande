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
public class MakeupController {

    private final PicturesService picturesService;
    private final CloudinaryService cloudinaryService;

    public MakeupController(PicturesService picturesService, CloudinaryService cloudinaryService) {
        this.picturesService = picturesService;
        this.cloudinaryService = cloudinaryService;
    }

    @PutMapping("/resources/likesMakeup")
    public String likesMakeup(@RequestParam("likes") Long id) {

        picturesService.likePictures(id);

        return "redirect:/resources/makeup";
    }

    @GetMapping("/resources/makeup")
    public String makeup(Model model) {

        List<PicturesViewModel> allPictures = picturesService.allPicturesViewMakeup();

        model.addAttribute("allPictures", allPictures);

        return "makeup";
    }

    @PostMapping("/resources/makeup")
    public String makeupFilter(FilterBindingModel filterBindingModel, Model model) {


        List<PicturesViewModel> allPictures = picturesService
                .filterPicturesViewMakeup(filterBindingModel.getCategoryStyle());
        model.addAttribute("allPictures", allPictures);

        return "makeup";

    }

//     Delete image --------------------------
//     ---------------------------------------

    @Transactional
    @DeleteMapping("/resources/deleteMakeup")
    public String delete(@RequestParam("public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            picturesService.deletePictures(publicId);
        }

        return "redirect:/resources/makeup";
    }

    @ModelAttribute("filterBindingModel")
    public FilterBindingModel filterBindingModel() {
        return new FilterBindingModel();
    }
}
