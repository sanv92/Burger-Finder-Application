package com.example.foursquareapi.model;


public class ResponseApi {

    private String response;

    private Integer code;

    private String header;

    public ResponseApi(String response, Integer code, String header) {
        this.response = response;
        this.code = code;
        this.header = header;
    }

    public String getResponse() {
        return response;
    }

    public Integer getCode() {
        return code;
    }

    public String getHeader() {
        return header;
    }
}
