package com.ubb.cms.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Alexandra Muresan on 4/10/2017.
 */
@Entity
@javax.persistence.Table(name = "edition")
public class Edition implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "conference_id", referencedColumnName = "id")
    private Conference conference;

    @Column(name = "name")
    private String name;
    @Column(name = "paperSubmissionDeadline")
    private Date paperSubmissionDeadline;
    @Column(name = "finalDeadline")
    private Date finalDeadline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPaperSubmissionDeadline() {
        return paperSubmissionDeadline;
    }

    public void setPaperSubmissionDeadline(Date paperSubmissionDeadline) {
        this.paperSubmissionDeadline = paperSubmissionDeadline;
    }

    public Date getFinalDeadline() {
        return finalDeadline;
    }

    public void setFinalDeadline(Date finalDeadline) {
        this.finalDeadline = finalDeadline;
    }

    private Date beginningDate;
    private Date endingDate;

    public Edition(Conference conference, Date beginningDate, Date endingDate, String name, Date paperSubmissionDeadline, Date finalDeadline) {
        this.conference = conference;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
        this.name = name;
        this.paperSubmissionDeadline = paperSubmissionDeadline;
        this.finalDeadline = finalDeadline;
    }

    public Edition(){

    }
}