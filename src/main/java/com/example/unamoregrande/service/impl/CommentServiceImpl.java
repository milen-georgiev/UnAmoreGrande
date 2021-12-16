package com.example.unamoregrande.service.impl;

import com.example.unamoregrande.model.entity.CommentsEntity;
import com.example.unamoregrande.model.service.CommentServiceModel;
import com.example.unamoregrande.model.view.CommentsViewModel;
import com.example.unamoregrande.repository.CommentRepository;
import com.example.unamoregrande.repository.GrandmasSecretArticlesRepository;
import com.example.unamoregrande.repository.UserRepository;
import com.example.unamoregrande.service.CommentService;
import com.example.unamoregrande.web.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final GrandmasSecretArticlesRepository grandmasSecretArticlesRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(GrandmasSecretArticlesRepository grandmasSecretArticlesRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.grandmasSecretArticlesRepository = grandmasSecretArticlesRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentsViewModel createComment(CommentServiceModel commentServiceModel) {
        Objects.requireNonNull(commentServiceModel.getUser());

        var article = grandmasSecretArticlesRepository.
                findById(commentServiceModel.getArticleId())
                .orElseThrow(() -> new ObjectNotFoundException("Article with id " + commentServiceModel.getArticleId() + " not found!"));

        var user = userRepository.
                findByUsername(commentServiceModel.getUser())
                .orElseThrow(() -> new ObjectNotFoundException("User with eamil " + commentServiceModel.getUser() + " not found!"));

        CommentsEntity newComment = new CommentsEntity();
        newComment.setDescription(commentServiceModel.getDescription());
        newComment.setUser(user);
        newComment.setArticles(article);
        newComment.setAlerts("unverified");
        newComment.setAdded(LocalDateTime.now());

        CommentsEntity savedComment = commentRepository.save(newComment);

        return mapAsComment(savedComment);
    }

    @Transactional
    @Override
    public List<CommentsViewModel> getComments(Long articleId) {

        var articleOptional = grandmasSecretArticlesRepository
                .findById(articleId);

        if (articleOptional.isEmpty()) {
            throw new ObjectNotFoundException("Article with id " + articleOptional + " was not found!");
        }

        return articleOptional
                .get()
                .getComments()
                .stream()
                .map(this::mapAsComment)
                .collect(Collectors.toList());
    }

    private CommentsViewModel mapAsComment(CommentsEntity commentsEntity) {
        CommentsViewModel commentsViewModel = new CommentsViewModel();

        commentsViewModel
                .setCommentId(commentsEntity.getId())
                .setDescription(commentsEntity.getDescription())
                .setUser(commentsEntity.getUser().getUsername())
                .setAlerts(commentsEntity.getAlerts())
                .setAdded(commentsEntity.getAdded())
                .setCanDelete(true);

        return commentsViewModel;
    }
}
