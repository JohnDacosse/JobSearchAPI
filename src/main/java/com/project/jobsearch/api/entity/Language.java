package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lan_id")
    private Long languageId;

    private String language;

    @ManyToMany(mappedBy = "languages")
    private List<Cv> cvs;

    @ManyToOne
    @JoinColumn(name = "lev_id")
    private Level level;

    public Language() {
    }

    public Language(Long languageId, String language, List<Cv> cvs, Level level) {
        this.languageId = languageId;
        this.language = language;
        this.cvs = cvs;
        this.level = level;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
