package com.pierceecom.blog.common;

public class HttpResponseCodeStringConstants {

    public static final int SC_OK = 200;
    public static final int SC_NO_CONTENT = 204;
    public static final int SC_INVALID_INPUT = 405;
    public static final int SC_CREATED = 201;

    public static final String STATUS_OK = "200";
    public static final String STATUS_CREATED = "201";
    public static final String STATUS_NO_CONTENT = "204";
    public static final String STATUS_INVALID_INPUT = "405";

    public static final String DESC_SC_INVALID_INPUT = "Invalid input";
    public static final String DESC_SC_NO_CONTENT = "SC_NO_CONTENT";
    public static final String DESC_SC_CREATED = "SUCCESSFULLY CREATED POST";
    public static final String DESC_SC_OK = "SC_NO_CONTENT";

    private HttpResponseCodeStringConstants() {
    }
}
