package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String postUrl;

    @Transient
    private String userName;

    @Transient
    private int voteCount;

    private Integer userId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    private List<Comment> comments;

    public Post(Integer id, String title, String postUrl, String userName, int voteCount, Integer userId) {
        this.id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.userName = userName;
        this.voteCount = voteCount;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public String getUserName() {
        return userName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return getVoteCount() == post.getVoteCount() && Objects.equals(getId(), post.getId()) && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getPostUrl(), post.getPostUrl()) && Objects.equals(getUserName(), post.getUserName()) && Objects.equals(getUserId(), post.getUserId()) && Objects.equals(getPostedAt(), post.getPostedAt()) && Objects.equals(getUpdatedAt(), post.getUpdatedAt()) && Objects.equals(getComments(), post.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getPostUrl(), getUserName(), getVoteCount(), getUserId(), getPostedAt(), getUpdatedAt(), getComments());
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}
