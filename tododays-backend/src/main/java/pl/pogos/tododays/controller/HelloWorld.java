package pl.pogos.tododays.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sebastian on 16.03.2016.
 */
@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String home() {
        return "Hello world!!";
    }
}
