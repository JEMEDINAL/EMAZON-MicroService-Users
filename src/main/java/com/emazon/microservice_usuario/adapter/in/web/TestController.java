package com.emazon.microservice_usuario.adapter.in.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestController {

    @GetMapping("/get")
    public String callGet(){
        return "Method Called With GET";
    }

    @PostMapping("/post")
    public String callPost(){
        return "Method Called With POST";
    }

    @PutMapping("/put")
    public String callPut(){
        return "Method Called With PUT";
    }

    @DeleteMapping("/delete")
    public String callDelete(){
        return "Method Called With DELETE";
    }

    @GetMapping("/gestis")
    public String testRole(){
        return "sos admin whacho";
    }

    @GetMapping("/asissts")
    public String auxBodega(){
        return "sos aux_BODEGA";
    }
}
