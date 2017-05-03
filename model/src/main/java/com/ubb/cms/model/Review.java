package com.ubb.cms.model;

import com.ubb.cms.model.utils.ReviewStatus;
import com.ubb.cms.model.utils.UserPaperEmb;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Alexandra Muresan on 4/11/2017.
 */
@Entity
@Table(name = "review")
public class Review implements Serializable {

    @EmbeddedId
    private UserPaperEmb userPaper;

    @Column(name = "status")
    private ReviewStatus status;

    @Column(name = "comment")
    private String comment;

    public Review() {
    }

    public Review(UserPaperEmb userPaper, ReviewStatus status, String comment) {
        this.userPaper = userPaper;
        this.status = status;
        this.comment = comment;
    }

    public UserPaperEmb getUserPaper() {
        return userPaper;
    }

    public void setUserPaper(UserPaperEmb userPaper) {
        this.userPaper = userPaper;
    }

    public ReviewStatus getStatus() {
        return status;
    }

    public void setStatus(ReviewStatus status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
