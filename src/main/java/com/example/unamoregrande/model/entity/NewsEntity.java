package com.example.unamoregrande.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "news")
public class NewsEntity extends BaseEntity{

    @Column(columnDefinition = "LongText")
    private String description;
    private LocalDate added;

    public NewsEntity() {
    }

    public String getDescription() {
        return description;
    }

    public NewsEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getAdded() {
        return added;
    }

    public NewsEntity setAdded(LocalDate added) {
        this.added = added;
        return this;
    }
}
