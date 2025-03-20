package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CommentDTO;
import com.entity.BlogEntity;
import com.entity.CommentEntity;
import com.exception.ResourceNotFoundException;
import com.repository.BlogRepository;
import com.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    public CommentDTO convertEntityToDTO(CommentEntity comment) {
        return new CommentDTO(
                comment.getCommentId(),
                comment.getBlog().getBlogId(),
                comment.getComment()
        );
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
      
        BlogEntity blog = blogRepository.findById(commentDTO.getBlogId())
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + commentDTO.getBlogId()));

        
        CommentEntity comment = new CommentEntity();
        comment.setComment(commentDTO.getComment());
        comment.setBlog(blog);

        CommentEntity savedComment = commentRepository.save(comment);
        return convertEntityToDTO(savedComment);
    }
    
    public List<CommentDTO> getCommentsByBlogId(Integer blogId) {
        BlogEntity blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id " + blogId));

        List<CommentEntity> comments = commentRepository.findByBlog(blog);

        List<CommentDTO> commentDTOs = new ArrayList<>();
        for (CommentEntity comment : comments) {
            commentDTOs.add(convertEntityToDTO(comment));
        }

        return commentDTOs;
    }

}


