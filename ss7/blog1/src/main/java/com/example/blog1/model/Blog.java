package com.example.blog1.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "blogs")
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String image;
    @Column(name = "create_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "is_deleted")
    private boolean flagDelete;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Blog(){

    }

    public Blog(Integer id, String title, String image, LocalDateTime date, String content, boolean flagDelete, Category category) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.date = date;
        this.content = content;
        this.flagDelete = flagDelete;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean getFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
