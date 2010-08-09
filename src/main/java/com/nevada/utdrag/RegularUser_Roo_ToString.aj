package com.nevada.utdrag;

import java.lang.String;

privileged aspect RegularUser_Roo_ToString {
    
    public String RegularUser.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
