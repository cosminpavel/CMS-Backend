package com.ubb.cms.model.utils;

import com.ubb.cms.model.Paper;
import com.ubb.cms.model.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Alexandra Muresan on 4/11/2017.
 */
@Embeddable
public class UserPaperEmb implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="paper_id", referencedColumnName = "id")
    private Paper paper;

    public UserPaperEmb() {

    }

    public UserPaperEmb(User user, Paper paper) {
        this.user = user;
        this.paper = paper;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
