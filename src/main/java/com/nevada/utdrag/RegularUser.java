package com.nevada.utdrag;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;

@Entity
@RooJavaBean
@RooToString
@RooEntity(finders = { "findRegularUsersByName", "findRegularUsersByNameAndPw" })
public class RegularUser {

    public RegularUser(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    private String name;

    private String email;

    private String pw;
}
