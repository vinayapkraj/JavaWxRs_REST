package com.pierceecom.blog.service;

import com.pierceecom.blog.dto.BlogEntity;
import com.pierceecom.blog.exception.BlogPostCustomException;

import javax.ws.rs.core.Response;

public interface BlogPostService {
    Response addPost(BlogEntity BlogEntity);

    Response deletePostById(String id);

    Response findPostById(String id) throws BlogPostCustomException;

    Response findAllPosts();
}
