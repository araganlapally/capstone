package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BlogDTO;
import com.service.BlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
@Validated
public class BlogController {

	@Autowired
	private BlogService blogService;

	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	@GetMapping
	public ResponseEntity<List<BlogDTO>> getAllBlogs() {
		List<BlogDTO> savedBlog=blogService.findAll();
		return new ResponseEntity<>(savedBlog,HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BlogDTO> getBlogById(@PathVariable("id") Integer id) {
		BlogDTO getBlog=blogService.findById(id);
		return new ResponseEntity<>(getBlog,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BlogDTO> saveBlog( @Valid @RequestBody BlogDTO blogDto) {
		BlogDTO savedBlog=blogService.save(blogDto);
		
		return new ResponseEntity<>(savedBlog,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BlogDTO> updateBlog(@PathVariable("id") Integer id, @Valid @RequestBody BlogDTO blogDto)
	{
		BlogDTO updatedBlog=blogService.update(id, blogDto);
		return new ResponseEntity<>(updatedBlog,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Integer id) {
        blogService.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	

}
