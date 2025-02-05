package com.Aggin.Codes.Photos.Clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PhotoController {

    private List<Photo> db = List.of(new Photo("1", "hello.jpg"));

    @GetMapping("/photoz")
    public List<Photo> getPhoto(){
        return db;
    }

}
