package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lic_id")
    private Long licenseId;

    private String type;

    @ManyToMany(targetEntity = Cv.class, mappedBy = "licenses")
    private List<Cv> cvs;

    public License() {
    }

    public License(Long licenseId, String type, List<Cv> cvs) {
        this.licenseId = licenseId;
        this.type = type;
        this.cvs = cvs;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
