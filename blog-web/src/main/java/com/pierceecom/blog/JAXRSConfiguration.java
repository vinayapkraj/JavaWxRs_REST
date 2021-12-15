package com.pierceecom.blog;

import com.pierceecom.blog.controller.BlogApiController;
import com.pierceecom.blog.dto.BlogEntity;
import com.pierceecom.blog.repository.BlogPostRepository;
import com.pierceecom.blog.service.BlogPostService;
import com.pierceecom.blog.service.impl.BlogPostServiceImpl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.v3.jaxrs2.SwaggerSerializers;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;


@ApplicationPath("/")
public class JAXRSConfiguration extends Application {
    public JAXRSConfiguration() {
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("Blog POST API");
        beanConfig.setHost("localhost:8082");
        beanConfig.setResourcePackage("com.pierceecom.blog");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(HelloPierceResource.class);
        classes.add(BlogApiController.class);
        classes.add(BlogPostRepository.class);
        classes.add(BlogPostService.class);
        classes.add(BlogPostServiceImpl.class);
        classes.add(BlogEntity.class);
        classes.add(ApiListingResource.class);
        classes.add(SwaggerSerializers.class);
        classes.add(OpenApiResource.class);
        return classes;
    }
}
