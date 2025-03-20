package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CommentDTO;
import com.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
@Validated
public class CommentController {
	
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService)
	{
		this.commentService=commentService;
	}
	@PostMapping("/{id}/comment")
	public ResponseEntity<CommentDTO> addComment(@PathVariable int id, @Valid @RequestBody  CommentDTO commentDTO)
	{
		CommentDTO createdComment=commentService.createComment(id, commentDTO);
		return new ResponseEntity<CommentDTO>(createdComment,HttpStatus.CREATED);
	}
	
	

}
