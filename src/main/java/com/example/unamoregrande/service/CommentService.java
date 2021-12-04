package com.example.unamoregrande.service;

import com.example.unamoregrande.model.service.CommentServiceModel;
import com.example.unamoregrande.model.view.CommentsViewModel;

import java.util.List;

public interface CommentService {

    CommentsViewModel createComment(CommentServiceModel commentServiceModel);

    List<CommentsViewModel> getComments(Long articleId);

}
