package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private Long cvId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private Boolean vehicle;

    @OneToOne(targetEntity= User.class)
    @JoinColumn(name = "usr_id")
    private User user;

    @ManyToMany(targetEntity = License.class)
    private List<License> licenses;

    @OneToMany(mappedBy = "cv")
    private List<ProExp> proExps;

    @ManyToMany
    private List<Language> languages;

    @OneToMany(mappedBy = "cv")
    private List<Studies> studies;

    @ManyToMany
    private List<Skill> skills;

    public Cv() {
    }

    public Cv(Long cvId, String firstName, String lastName, LocalDate birthDate, Boolean vehicle, User user,
              List<License> licenses, List<ProExp> proExps, List<Language> languages,
              List<Studies> studies, List<Skill> skills) {
        this.cvId = cvId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.vehicle = vehicle;
        this.user = user;
        this.licenses = licenses;
        this.proExps = proExps;
        this.languages = languages;
        this.studies = studies;
        this.skills = skills;
    }

    public Long getCvId() {
        return cvId;
    }

    public void setCvId(Long cvId) {
        this.cvId = cvId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getVehicle() {
        return vehicle;
    }

    public void setVehicle(Boolean vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public List<ProExp> getProExps() {
        return proExps;
    }

    public void setProExps(List<ProExp> proExps) {
        this.proExps = proExps;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguage(List<Language> languages) {
        this.languages = languages;
    }

    public List<Studies> getStudies() {
        return studies;
    }

    public void setStudies(List<Studies> studies) {
        this.studies = studies;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
