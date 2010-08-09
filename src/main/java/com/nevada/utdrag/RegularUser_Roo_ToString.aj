package com.nevada.utdrag;

import java.lang.String;

privileged aspect RegularUser_Roo_ToString {
    
    public String RegularUser.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Email: ").append(getEmail()).append(", ");
        sb.append("Pw: ").append(getPw());
        return sb.toString();
    }
    
}
