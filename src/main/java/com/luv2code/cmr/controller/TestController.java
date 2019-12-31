package com.luv2code.cmr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jack Tran
 */

@Controller
public class TestController {

    @GetMapping({"/", "/hello"})
    public String hello() {
        return "hello";
    }

    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }
}
