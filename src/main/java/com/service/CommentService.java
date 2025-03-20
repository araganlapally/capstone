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
	private BlogRepository blogrepository;

	private CommentRepository commentRepository;

	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public CommentDTO convertEntityToDTO(CommentEntity comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setCommentId(comment.getCommentId());
		commentDTO.setBlogId(comment.getBlog().getBlogId());
		commentDTO.setComment(comment.getComment());
		return commentDTO;
	}
	
	public CommentDTO createComment(int id,CommentDTO commentDTO)
	{
		BlogEntity blog=blogrepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("blog not found with id"+commentDTO.getBlogId()));
		
		CommentEntity comment =new CommentEntity();
		comment.setComment(commentDTO.getComment());
		comment.setBlog(blog);
		CommentEntity savedComment =commentRepository.save(comment);
		return convertEntityToDTO(savedComment);
		
		
	}
	
	
				
				
	}


