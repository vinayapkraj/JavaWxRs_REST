package com.pierceecom.blog.repository;

import com.pierceecom.blog.dto.BlogEntity;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class BlogPostRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogPost");
    private EntityManager em;


    public BlogPostRepository() {
        em = emf.createEntityManager();
    }

    public String addPost(BlogEntity blogEntity) {
        em.getTransaction().begin();
        em.persist(blogEntity);
        em.merge(blogEntity);
        em.getTransaction().commit();
        return blogEntity.getId();
    }

    public Optional<BlogEntity> findPostById(String id) {
        em.getTransaction().begin();
        BlogEntity blogEntity = em.find(BlogEntity.class, id);
        em.getTransaction().commit();
        return blogEntity != null ? Optional.of(blogEntity) : Optional.empty();
    }


    public List<BlogEntity> findAllPosts() {
        return em.createQuery("SELECT a FROM BlogEntity a", BlogEntity.class).getResultList();
    }

    public void deletePostById(String id) {
        em.getTransaction().begin();
        em.remove(em.find(BlogEntity.class, id));
        em.getTransaction().commit();
    }
    public void close() {
        emf.close();
    }

}
