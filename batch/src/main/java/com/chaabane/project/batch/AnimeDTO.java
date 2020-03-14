package com.chaabane.project.batch;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
public class AnimeDTO {

    @Id
    private String id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private Date date;

    public AnimeDTO(){
    }
    public AnimeDTO(String id, String title, String description, Date date){
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AnimeDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
