package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Studies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private Long studiesId;

    private String title;
    private String location;
    private String degree;
    private LocalDate startDate, endDate;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;


    public Studies() {
    }

    public Studies(Long studiesId, String title, String location,
                   String degree, LocalDate startDate, LocalDate endDate, Cv cv) {
        this.studiesId = studiesId;
        this.title = title;
        this.location = location;
        this.degree = degree;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cv = cv;
    }

    public Long getStudiesId() {
        return studiesId;
    }

    public void setStudiesId(Long studiesId) {
        this.studiesId = studiesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }
}
