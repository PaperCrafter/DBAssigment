package com.team02.prime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

    @GetMapping("/reservation")
    public String reservationPage(){
        return "/reservation/main.html";
    }
}
