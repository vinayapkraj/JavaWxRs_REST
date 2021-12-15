package com.pierceecom.blog.controller;

import com.pierceecom.blog.dto.BlogEntity;
import com.pierceecom.blog.service.BlogPostService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.DESC_SC_INVALID_INPUT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.DESC_SC_NO_CONTENT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.DESC_SC_OK;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.DESC_SC_CREATED;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.STATUS_INVALID_INPUT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.STATUS_OK;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.STATUS_CREATED;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.STATUS_NO_CONTENT;

/**
 * Root Path as /blog-web
 */
@RequestScoped
@Path("/posts")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class BlogApiController {

    public BlogApiController() {
        //Needed for Injection
    }

    private BlogPostService blogPostService;

    @Inject
    public BlogApiController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GET
    @Operation(summary = "Get All Posts", description = "Get All the Post created in Blog", tags = "post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = DESC_SC_OK, content = @Content(schema = @Schema(implementation = BlogEntity.class))),
            @ApiResponse(responseCode = STATUS_NO_CONTENT, description = DESC_SC_NO_CONTENT, content = @Content(schema = @Schema(implementation = BlogEntity.class)))
    })
    public Response getAllPosts() {
        return blogPostService.findAllPosts();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get Post By Id", description = "Get Post By ID", tags = "post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = DESC_SC_OK, content = @Content(schema = @Schema(implementation = BlogEntity.class))),
            @ApiResponse(responseCode = STATUS_NO_CONTENT, description = DESC_SC_NO_CONTENT, content = @Content(schema = @Schema(implementation = BlogEntity.class)))
    })
    public Response getPostById(@PathParam(value = "id") String id) {
        return blogPostService.findPostById(id);
    }

    @POST
    @Path("/addPost")
    @Operation(summary = "Add a new post", description = "Add New Post", tags = "post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_CREATED, description = DESC_SC_CREATED, content = @Content(schema = @Schema(implementation = BlogEntity.class))),
            @ApiResponse(responseCode = STATUS_INVALID_INPUT, description = DESC_SC_INVALID_INPUT, content = @Content(schema = @Schema(implementation = BlogEntity.class)))
    })
    public Response createPost(@Valid BlogEntity blogEntity) {
        return blogPostService.addPost(blogEntity);
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Delete post", description = "Delete Post from Blog using ID", tags = "post")
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = DESC_SC_OK, content = @Content(schema = @Schema(implementation = BlogEntity.class)))
    })
    public Response deleteProduct(@PathParam(value = "id") String id) {
        return blogPostService.deletePostById(id);
    }
}
