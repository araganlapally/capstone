package com.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BlogDTO {

	private int blogId;
	@NotBlank(message = "Title must not be empty")
	@Size(min = 3, max = 100, message = "Title must be between 3 to 100 characters")
	private String title;

	@NotBlank(message = "Content must not be empty")
	@Size(min = 10, max = 500, message = "Content must be between 10 to 500 characters")
	private String content;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BlogDTO(
		    @NotBlank(message = "Title must not be empty")
		    @Size(min = 3, max = 100, message = "Title must be between 3 to 100 characters") String title,

		    @NotBlank(message = "Content must not be empty")
		    @Size(min = 10, max = 500, message = "Content must be between 10 to 500 characters") String content) {
		    this.title = title;
		    this.content = content;
		}


	public BlogDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
