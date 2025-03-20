package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="blogs")
public class BlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="blogId")
	private int blogId;
	private String title;
	private String content;
	
	@OneToMany(mappedBy = "blog" ,cascade =CascadeType.ALL)
	private List<CommentEntity> comments;

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

	public BlogEntity( String title, String content) {
		super();
		
		this.title = title;
		this.content = content;
	}

	public BlogEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
