package com.team02.prime.controller;
import com.team02.prime.model.UserVO;
import com.team02.prime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/user/insert", method = RequestMethod.GET)
    @GetMapping("/home")
    public String homeMain(HttpServletRequest request) {
       UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        return "home/main";
    }
}