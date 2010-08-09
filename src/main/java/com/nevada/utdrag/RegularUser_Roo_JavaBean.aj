package com.nevada.utdrag;

import java.lang.String;

privileged aspect RegularUser_Roo_JavaBean {
    
    public String RegularUser.getName() {
        return this.name;
    }
    
    public void RegularUser.setName(String name) {
        this.name = name;
    }
    
    public String RegularUser.getEmail() {
        return this.email;
    }
    
    public void RegularUser.setEmail(String email) {
        this.email = email;
    }
    
    public String RegularUser.getPw() {
        return this.pw;
    }
    
    public void RegularUser.setPw(String pw) {
        this.pw = pw;
    }
    
}
