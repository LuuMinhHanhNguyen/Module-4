package com.example.ex2.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDTO implements Validator {

    private Integer id;

    @NotNull
    @Size(max = 800)
    @Pattern(regexp = "^[\\w ]+$", message = "Happy New Year")
    private String name;

    @NotNull
    @Size(max = 300)
    @Pattern(regexp = "^[\\w ]+$", message = "Happy New Year")
    private String singer;


    @NotNull
    @Size(max = 1000)
    @Pattern(regexp = "^[\\w ,]+$", message = "Only accept alphanumeric characters, white spaces, and commas!")
    private String type;

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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
