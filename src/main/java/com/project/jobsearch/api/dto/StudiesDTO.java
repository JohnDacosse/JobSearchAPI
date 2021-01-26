package com.project.jobsearch.api.dto;

import java.time.LocalDate;

public class StudiesDTO {

    private Long studiesId;

    private String title;
    private String location;
    private String degree;
    private LocalDate startDate, endDate;

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
}
