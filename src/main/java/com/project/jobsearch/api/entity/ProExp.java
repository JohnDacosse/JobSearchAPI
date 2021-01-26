package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ProExp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long proExpId;

    private String title;
    private String location;
    private LocalDate startDate, endDate;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    public ProExp() {
    }

    public ProExp(Long proExpId, String title, String location, LocalDate startDate, LocalDate endDate, Cv cv) {
        this.proExpId = proExpId;
        this.title = title;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cv = cv;
    }

    public Long getProExpId() {
        return proExpId;
    }

    public void setProExpId(Long proExpId) {
        this.proExpId = proExpId;
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
