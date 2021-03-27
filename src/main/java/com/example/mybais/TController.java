package com.example.mybais;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tencent")
@RestController
public class TController {

    @GetMapping("hi")
    public String tencent(){
        return "da ju  ju";
    }
}
