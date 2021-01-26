package com.project.jobsearch.api.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ski_id")
    private Long skillId;

    private String title;

    @Column(name= "description")
    private String desc;

    @ManyToMany(mappedBy = "skills")
    private List<Cv> cvs;

    public Skill() {
    }

    public Skill(Long skillId, String title, String desc, List<Cv> cvs) {
        this.skillId = skillId;
        this.title = title;
        this.desc = desc;
        this.cvs = cvs;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
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

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
