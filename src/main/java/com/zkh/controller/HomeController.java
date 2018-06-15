package com.zkh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nfc on 2018-06-14.
 */
@Controller
@RequestMapping("/main")
public class HomeController extends  BaseController {

@GetMapping("/home")
    public String home(){
        return View("home");
    }


}

