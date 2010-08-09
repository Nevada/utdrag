package com.nevada.utdrag;

import com.nevada.utdrag.RegularUser;
import java.lang.Integer;
import java.lang.Long;
import java.lang.SuppressWarnings;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

privileged aspect RegularUser_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager RegularUser.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long RegularUser.id;
    
    @Version
    @Column(name = "version")
    private Integer RegularUser.version;
    
    public Long RegularUser.getId() {
        return this.id;
    }
    
    public void RegularUser.setId(Long id) {
        this.id = id;
    }
    
    public Integer RegularUser.getVersion() {
        return this.version;
    }
    
    public void RegularUser.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void RegularUser.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void RegularUser.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            RegularUser attached = this.entityManager.find(this.getClass(), this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void RegularUser.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public RegularUser RegularUser.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        RegularUser merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager RegularUser.entityManager() {
        EntityManager em = new RegularUser().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public static long RegularUser.countRegularUsers() {
        return ((Number) entityManager().createQuery("select count(o) from RegularUser o").getSingleResult()).longValue();
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public static List<RegularUser> RegularUser.findAllRegularUsers() {
        return entityManager().createQuery("select o from RegularUser o").getResultList();
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public static RegularUser RegularUser.findRegularUser(Long id) {
        if (id == null) return null;
        return entityManager().find(RegularUser.class, id);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public static List<RegularUser> RegularUser.findRegularUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from RegularUser o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
