package com.blogger.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Nikolay Yashchenko
 */
public class CommentDTO {

    @Size(min = 2, max = 15)
    @NotNull
    private String authorName;

    @Size(min = 2, max = 100)
    private String text;

    private String creationDate;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
