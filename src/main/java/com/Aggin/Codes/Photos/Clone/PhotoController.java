package com.Aggin.Codes.Photos.Clone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotoController {

    private Map<String,Photo> db = new HashMap<>(){{
        put("1",new Photo("1", "hello.jpg"));
    }};


    // this method returns all the photos in the db
    @GetMapping("/photoz")
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

    // this method will delete a photo with specific id
    @DeleteMapping("/photoz/{id}")
    public void deletePhoto(@PathVariable String id){
        Photo photo =  db.remove(id);
        if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Photo with the specific Id is not found and Cannot Be deleted");

    }

    // this method is used for posting a photo ie uploading of a photo
    // RequestBody - Take the whole Json and convert it into the Java Object Class that we have defined ;
    // ie it is the Photo Class

    // Uptill now the photo is not persistent ; the photo is not present when the application is again loaded ;

    // without the valid annotation the jSON Object will be posted / Created even if the object does not have a file Name
    @PostMapping("/photoz")
    public Photo createPhoto(@RequestBody @Valid Photo photo){
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(),photo);
        return photo;

    }

}
