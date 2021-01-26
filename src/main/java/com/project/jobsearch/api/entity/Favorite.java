package com.project.jobsearch.api.entity;

import javax.persistence.*;

@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fav_id")
    private Long favId;
    @Column(nullable = false)
    private Long jobId;
    @Column(nullable = false)
    private String title;
    @Column(name= "description", nullable = false)
    private String desc;
    private String location;
    private String languageCode;
    private String licenseCode;
    @ManyToOne
    @JoinColumn(name = "usr_id")
    private User user;

    public Favorite() {
    }

    public Favorite(Long favId, Long jobId, String title, String desc,
                    String location, String languageCode, String licenseCode, User user) {
        this.favId = favId;
        this.jobId = jobId;
        this.title = title;
        this.desc = desc;
        this.location = location;
        this.languageCode = languageCode;
        this.licenseCode = licenseCode;
        this.user = user;
    }

    public Long getFavId() {
        return favId;
    }

    public void setFavId(Long favId) {
        this.favId = favId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
