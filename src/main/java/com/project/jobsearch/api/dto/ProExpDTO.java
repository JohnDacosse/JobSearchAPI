package com.project.jobsearch.api.dto;

import java.time.LocalDate;

public class ProExpDTO {

    private Long proExpId;
    private String title;
    private String location;
    private LocalDate startDate, endDate;

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
}
