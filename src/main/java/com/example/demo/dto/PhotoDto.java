package com.example.demo.dto;

public class PhotoDto {

    private String url;

    public PhotoDto(String url) {
        this.url = url;
    }

    public PhotoDto() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
