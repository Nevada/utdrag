package com.nevada.utdrag;

import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.Query;

privileged aspect RegularUser_Roo_Finder {
    
    public static Query RegularUser.findRegularUsersByName(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        EntityManager em = RegularUser.entityManager();
        Query q = em.createQuery("SELECT RegularUser FROM RegularUser AS regularuser WHERE regularuser.name = :name");
        q.setParameter("name", name);
        return q;
    }
    
    public static Query RegularUser.findRegularUsersByNameAndPw(String name, String pw) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        if (pw == null || pw.length() == 0) throw new IllegalArgumentException("The pw argument is required");
        EntityManager em = RegularUser.entityManager();
        Query q = em.createQuery("SELECT RegularUser FROM RegularUser AS regularuser WHERE regularuser.name = :name AND regularuser.pw = :pw");
        q.setParameter("name", name);
        q.setParameter("pw", pw);
        return q;
    }
    
}
