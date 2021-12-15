package com.pierceecom.blog.service.impl;

import com.pierceecom.blog.dto.BlogEntity;
import com.pierceecom.blog.repository.BlogPostRepository;
import com.pierceecom.blog.service.BlogPostService;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.SC_CREATED;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.SC_NO_CONTENT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.SC_OK;

@RequestScoped
public class BlogPostServiceImpl implements BlogPostService {
    protected final static String POSTS_URL = "http://localhost:8080/blog-web/posts/";

    public BlogPostServiceImpl() {
        //Needed for Injection
    }

    private BlogPostRepository blogPostRepository;

    @Inject
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public Response addPost(BlogEntity blogEntity) {
        return Response.status(SC_CREATED).entity("OK of post")
                .location(URI.create(POSTS_URL + blogPostRepository.addPost(blogEntity)))
                .build();
    }

    @Override
    public Response deletePostById(String id) {
        blogPostRepository.deletePostById(id);
        return Response.status(SC_OK).entity("Deleted").build();
    }

    @Override
    public Response findPostById(String id) {
        Optional<BlogEntity> postById = blogPostRepository.findPostById(id);
        if (postById.isPresent()) {
            return Response.status(SC_OK).entity(postById).build();
        }
        return Response.status(SC_NO_CONTENT).entity(Collections.EMPTY_LIST).build();
    }

    @Override
    public Response findAllPosts() {
        List<BlogEntity> allPosts = blogPostRepository.findAllPosts();
        if (allPosts.isEmpty()) {
            return Response.status(SC_NO_CONTENT).entity(Collections.EMPTY_LIST).build();
        }
        return Response.status(SC_OK).entity(allPosts).build();
    }
}
