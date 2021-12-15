package com.pierceecom.blog.exception;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.DESC_SC_INVALID_INPUT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.DESC_SC_NO_CONTENT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.SC_INVALID_INPUT;
import static com.pierceecom.blog.common.HttpResponseCodeStringConstants.SC_NO_CONTENT;
//TODO Use these Custom Exceptions to throw Known Errors

@Provider
public class BlogPostCustomExceptionMapper implements ExceptionMapper<BlogPostCustomException> {
	@Override
	public Response toResponse(BlogPostCustomException e) {
		Map map = new HashMap();
		map.put("message", e.getMessage());

		if (e.getMessage().equals(DESC_SC_NO_CONTENT)) {
			return Response.status(SC_NO_CONTENT).type(MediaType.APPLICATION_JSON).entity(map).build();
		}
		if (e.getMessage().equals(DESC_SC_INVALID_INPUT)) {
			return Response.status(SC_INVALID_INPUT).type(MediaType.APPLICATION_JSON).entity(map).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).entity(map).build();

	}
}