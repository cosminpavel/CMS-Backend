package com.ubb.cms.model;

import com.ubb.cms.model.utils.UserEditionEmb;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Alexandra Muresan on 4/11/2017.
 */
@Entity
@Table(name = "sessionChair")
public class SessionChair implements Serializable {
    @EmbeddedId
    private UserEditionEmb chair;

    public SessionChair() {
    }

    public SessionChair(UserEditionEmb chair) {
        this.chair = chair;
    }

    public UserEditionEmb getChair() {
        return chair;
    }

    public void setChair(UserEditionEmb chair) {
        this.chair = chair;
    }
}
