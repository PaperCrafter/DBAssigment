package com.team02.prime.controller;


import com.team02.prime.model.UserVO;
import com.team02.prime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //@RequestMapping(value = "/user/insert", method = RequestMethod.GET)
    @GetMapping("/user/insert")
    public String userInsert(){
        return "user/insert";
    }

    @PostMapping("/user/insert")
    public String userInsertExecute(Model model, @ModelAttribute UserVO userVO){


        log.debug("##### 회원 등록 요청 처리 ####");
        log.debug(userVO.toString());

        this.userService.insertUser(userVO);

        log.debug("#### 회원 등록 결과 ####");
        log.debug(userVO.toString());


        //  userVO = this.userService.selectUser(userVO.getUser_number()); // 상세 내역을 다 가져오고 싶으면 이렇게 하면된다.


        model.addAttribute("user", userVO);  // Controller에서 model에 담아 놓기만 해도 (UserMapper.xml 에서
        // key값으로 user_number 지정해줬으니깐 p_k가 지정된 값이 자동으로 set이된다. reference를 따로 반환 받진 않았지만 )
        //user_number를 쓸수있다.

        return "user/join_after";
    }


    @GetMapping("/user/view/{user_number}")
    public String userView(Model model, @PathVariable int user_number){
        model.addAttribute("user", this.userService.selectUser(user_number));
        return "user/view";
    }
    @PostMapping("/user/delete/{user_number}")
    public String userDelete(HttpServletRequest request,@PathVariable int user_number){
        this.userService.deleteUser(request,user_number);
        return "user/delete_after";
    }
    @GetMapping("/user/delete_b/{user_number}")
    public String b_userDelete(HttpServletRequest request,@PathVariable int user_number){
        this.userService.delete_b_User(request,user_number);
        return "user/insert";
    }



    @GetMapping("/user/update/{user_number}")
    public String userUpdate(Model model, @PathVariable int user_number){
        model.addAttribute("user", this.userService.selectUser(user_number));
        return "user/update";
    }

    @PostMapping("/user/update")
    public String userUpdateExecute(Model model, @ModelAttribute UserVO userVO){
        this.userService.updateUserInfo(userVO);
        model.addAttribute("user", this.userService.selectUser(userVO.getUser_number()));
        return "user/join_after";
    }

    @GetMapping("/user/list")
    public String userList(Model model){
        model.addAttribute("userList", this.userService.selectUserList());

       /* List<UserVO> userList = new ArrayList<>();

        for(UserVO userVO:userList){
        }
*/
        return "user/list";
    }
}




