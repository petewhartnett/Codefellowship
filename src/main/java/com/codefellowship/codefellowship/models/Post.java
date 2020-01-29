package com.codefellowship.codefellowship.models;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @ManyToOne
    ApplicationUser applicationUser;

    String body;

    public Post (ApplicationUser applicationUser, String body ){
        this.applicationUser = applicationUser;
        this.body = body;

    }

    public Post(){

    }

    public long getId(){

        return Id;
    }

    public ApplicationUser getApplicationUser(){
        return applicationUser;
    }


    public String getBody(){
        return body;
    }





}
