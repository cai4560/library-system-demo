package com.thoughtworks.library.model;

public class Book {
    public static final Integer INVALID_STATUS = 0;
    public static final Integer VALID_STATUS = 1;

    private Integer id;
    private String name;
    private String author;
    private Boolean isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer availableStatus) {
        isAvailable = VALID_STATUS.equals(availableStatus);
    }
}
