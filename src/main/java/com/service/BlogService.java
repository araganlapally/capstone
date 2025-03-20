package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.BlogDTO;
import com.entity.BlogEntity;
import com.exception.ResourceNotFoundException;
import com.repository.BlogRepository;

@Service
public class BlogService {

	 
	private BlogRepository blogRepository;

	@Autowired
	public BlogService(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	// method to convert Entity to DTO
	private BlogDTO mapEntityToDto(BlogEntity blogEntity) {
		BlogDTO blogDto = new BlogDTO();

		blogDto.setBlogId(blogEntity.getBlogId());
		blogDto.setContent(blogEntity.getContent());
		blogDto.setTitle(blogEntity.getTitle());

		return blogDto;
	}

	// get all blogs
	public List<BlogDTO> findAll() {
		List<BlogEntity> blogEntities = blogRepository.findAll();
		List<BlogDTO> blogDTOs = new ArrayList<>();

		for (BlogEntity entity : blogEntities) {
			blogDTOs.add(mapEntityToDto(entity));
		}

		return blogDTOs;
	}

	// get blogs by Id
	public BlogDTO findById(Integer id) {
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found with id " + id));
		return mapEntityToDto(blog);
	}

	// save blog
	public BlogDTO save(BlogDTO blogDto) {
		BlogEntity blog = new BlogEntity();
		blog.setTitle(blogDto.getTitle());
		blog.setContent(blogDto.getContent());
		BlogEntity savedBlog = blogRepository.save(blog);
		return mapEntityToDto(savedBlog);
	}

	// update blog

	public BlogDTO update(Integer id, BlogDTO blogDto) {
		BlogEntity blog = blogRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Blog not found with id " + id));

		blog.setTitle(blogDto.getTitle());
		blog.setContent(blogDto.getContent());
		BlogEntity updatedBlog = blogRepository.save(blog);
		return mapEntityToDto(updatedBlog);

	}
	
	//deleteBlog
	 public void deleteBlog(Integer id) {
	        BlogEntity blog = blogRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id " + id));
	        blogRepository.delete(blog);
	    }

	
	

}
