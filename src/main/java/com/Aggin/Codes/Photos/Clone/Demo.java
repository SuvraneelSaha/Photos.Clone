package com.Aggin.Codes.Photos.Clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @GetMapping("/demo")
    // even if we dont give explicitly mapping it will open up the root
    public static String Hello(){
        return "Hello Aggin Codes";
    }
}
