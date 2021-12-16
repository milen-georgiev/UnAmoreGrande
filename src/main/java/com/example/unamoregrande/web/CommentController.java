package com.example.unamoregrande.web;

import com.example.unamoregrande.model.binding.CommentBindingModel;
import com.example.unamoregrande.model.service.CommentServiceModel;
import com.example.unamoregrande.model.view.CommentsViewModel;
import com.example.unamoregrande.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class CommentController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }
    
    @GetMapping("/api/{articleId}/comments")
    public ResponseEntity<List<CommentsViewModel>> getComments(
            @PathVariable Long articleId,
            Principal principal) {


        return ResponseEntity.ok(commentService.getComments(articleId));
    }

    @PostMapping("/api/{articleId}/comments")
    public ResponseEntity<List<CommentsViewModel>> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long articleId,
            @RequestBody CommentBindingModel commentBindingModel
    ) {
        CommentServiceModel commentServiceModel =
                modelMapper.map(commentBindingModel, CommentServiceModel.class);
        commentServiceModel.setUser(principal.getUsername());
        commentServiceModel.setArticleId(articleId);

        CommentsViewModel newComment =
                commentService.createComment(commentServiceModel);

        return ResponseEntity.ok(commentService.getComments(articleId));
    }

//    @PostMapping("/api/{articleId}/comments")
//    public ResponseEntity<CommentsViewModel> newComment(
//            @AuthenticationPrincipal UserDetails principal,
//            @PathVariable Long articleId,
//            @RequestBody CommentBindingModel commentBindingModel
//    ) {
//
//
//        CommentServiceModel commentServiceModel =
//                modelMapper.map(commentBindingModel, CommentServiceModel.class);
//        commentServiceModel.setUser(principal.getUsername());
//        commentServiceModel.setArticleId(articleId);
//
//        CommentsViewModel newComment =
//                commentService.createComment(commentServiceModel);
//
//        URI locationOfNewComment =
//                URI.create(String.format("/api/%s/comments/%s", articleId, newComment.getCommentId()));
//
//        return ResponseEntity.
//                created(locationOfNewComment).
//                body(newComment);
//    }



}
