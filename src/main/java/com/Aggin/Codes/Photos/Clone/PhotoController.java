package com.Aggin.Codes.Photos.Clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotoController {

    private Map<String,Photo> db = new HashMap<>(){{
        put("1",new Photo("1", "hello.jpg"));
    }};


    // this method returns all the photos in the db
    @GetMapping("/photoz/")
    public Collection<Photo> getPhoto(){
        return db.values();
        // values is a method of the Collection Framework
    }

    // this method will return only the specific id
    @GetMapping("/photoz/{id}")
    public Photo getPhoto(@PathVariable String id){
        Photo photo =  db.get(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with the specific Id is not found");
        return photo;
    }


}
