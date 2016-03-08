package com.blogger.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Nikolay Yashchenko
 */
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @SequenceGenerator(name = "comment_seq_gen", sequenceName = "comment_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "comment_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate localDate) {
        this.creationDate = localDate;
    }
}
