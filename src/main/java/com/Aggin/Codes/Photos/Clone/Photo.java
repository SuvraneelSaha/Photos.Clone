package com.Aggin.Codes.Photos.Clone;

public class Photo {
    private String id;
    private String fileName ;

    // empty constructor is need for objects analyse by the SpringBoot for Beans
    public Photo() {
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getId() {
        return id;
    }
}
