package com.codefellowship.codefellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;


// followed along with the video from class 16, 17 as well as referenced the class 16,17 demo for this project
@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;


    // a list of all posts by the user using one to many
    @OneToMany(mappedBy = "applicationUser")
    List<Post> post;

    //getter
    public List<Post>getPost(){

        return this.post;
    }



    String username;
    String password;
    String birthdate;
    String firstName;
    String secondName;
    String bio;


    public ApplicationUser(String username, String password, String birthdate,String firstName,String secondName, String bio){
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.secondName = secondName;
        this.bio = bio;
    }

    public ApplicationUser() {};

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

    @Override
    public String getPassword() {

        return this.password;
    }

    @Override
    public String getUsername() {

        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
