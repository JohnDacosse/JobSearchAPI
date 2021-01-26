package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lev_id")
    private Long levelId;

    private String title;

    @OneToMany(mappedBy = "level")
    private List<Language> languages;

    public Level() {
    }

    public Level(Long levelId, String title, List<Language> languages) {
        this.levelId = levelId;
        this.title = title;
        this.languages = languages;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
