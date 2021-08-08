package com.rudnev.Jnews.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Title;
    public long getId(){
        return id;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String title){
        this.Title =title;
    }

}
