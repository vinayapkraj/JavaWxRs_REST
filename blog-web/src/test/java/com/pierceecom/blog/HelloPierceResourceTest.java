package com.pierceecom.blog;

import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HelloPierceResourceTest {

    HelloPierceResource resource;

    public HelloPierceResourceTest() {
        resource = new HelloPierceResource();
    }

    @Test
    public void testHello() {
        Response helloResponse = resource.hello();
        String hello = (String) helloResponse.getEntity();
        assertEquals("{\"message\":\"Hello Pierce\"}", hello);
    }

}
