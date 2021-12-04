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
public class ManicureController {

    private final PicturesService picturesService;
    private final CloudinaryService cloudinaryService;

    public ManicureController(PicturesService picturesService, CloudinaryService cloudinaryService) {
        this.picturesService = picturesService;
        this.cloudinaryService = cloudinaryService;
    }

    @PutMapping("/resources/likesManicure")
    public String likesManicure(@RequestParam("likes") Long id) {

        picturesService.likePictures(id);

        return "redirect:/resources/manicure";
    }

    @GetMapping("/resources/manicure")
    public String manicure(Model model) {

        List<PicturesViewModel> allPictures = picturesService.allPicturesViewManicure();

        model.addAttribute("allPictures", allPictures);

        return "manicure";
    }

    @PostMapping("/resources/manicure")
    public String manicureFilter(FilterBindingModel filterBindingModel, Model model) {


        List<PicturesViewModel> allPictures = picturesService
                .filterPicturesViewManicure(filterBindingModel.getCategoryStyle());
        model.addAttribute("allPictures", allPictures);

        return "manicure";

    }

    @Transactional
    @DeleteMapping("/resources/deleteManicure")
    public String delete(@RequestParam("public_id") String publicId) {
        if (cloudinaryService.delete(publicId)) {
            picturesService.deletePictures(publicId);
        }

        return "redirect:/resources/manicure";
    }

    @ModelAttribute("filterBindingModel")
    public FilterBindingModel filterBindingModel() {
        return new FilterBindingModel();
    }
}
