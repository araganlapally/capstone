package com.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CommentDTO {

    private int commentId;

    @NotNull(message = "Blog ID cannot be null")
    private Integer blogId; 

    @NotBlank(message = "Comment must not be empty")
    @Size(min = 3, max = 200, message = "Comment must be between 3 to 200 characters")
    private String comment;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentDTO(@NotNull(message = "Blog ID cannot be null") Integer blogId,
                      @NotBlank(message = "Comment must not be empty")
                      @Size(min = 3, max = 200, message = "Comment must be between 3 to 200 characters") String comment) {
        super();
        this.blogId = blogId;
        this.comment = comment;
    }

    public CommentDTO() {
        super();
    }
}
