package com.luv2code.cmr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jack Tran
 */
@Controller
public class LoginController {

    @GetMapping(value = "/showMyLoginPage")
    public String showMyLoginPage() {
        return "fancy-login";
    }

    @GetMapping(value = "/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
