package com.team02.prime.controller;

import com.team02.prime.model.UserVO;
import com.team02.prime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * -------------------------------------------------------------
     * login form HTML
     *
     * @return
     */
    @GetMapping("/login/login")
    public String login() {

        return "login/login";
    }

    /**
     * ------------------------------------------------------------
     * login 수행
     *
     * @param userVO
     * @param model
     * @param request
     * @return
     */

    @PostMapping("/login/login")
    public String loginExecute(@ModelAttribute UserVO userVO, Model model, HttpServletRequest request) {

        userVO = this.userService.selectUserLogin(userVO.getId(), userVO.getPasswd());
        System.out.println(userVO); // 여기서 찍어보면 알겠지만 null 이라고 뜬다. 그래서 이대로 쓰면 null pointException 이뜬다.
        // 그래서 아래처럼 null 일 경우, 빈 userVO를 하나 만들어주는걸 추가해서 오류 안뜨게 해줬다.
        if (userVO == null) {
            userVO = new UserVO();
        }

        this.userService.login(userVO, request);

        // 여기서 서비스Impl.login에서 request 세션 저장해줬고.
        // System.out.println(userVO.getId());
        //  model.addAttribute("is_user",this.userService.selectUserLogin(userVO.getId(),userVO.getPasswd()));
        return "login/login_result";
    }

    // ----------------------- 아래는 로그인 비교 전 강사님이 해주신 코드
    /* @PostMapping("/login/login")
    public String loginExecute(@ModelAttribute UserVO userVO, Model model, HttpServletRequest request){

        //model.addAttribute("user", this.userService.login(userVO, request));

        this.userService.login(userVO, request);
        //   System.out.println(userVO.getId());
        return "login/login_result";
    }*/


/* -- ------------ 아래는 내가 @RequestParam으로 userVo에 담지말고 할라 시도한 코드인데,
            코드만 지저분해져서 그냥 @ModelAttribute 로 userVO 에 담기로 함.
   @PostMapping("/login/login")
    public String loginExecute(@RequestParam("id") String id,
                               @RequestParam("passwd") String passwd,
                               Model model, HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session) throws Exception{

        int check = userService.userCheck(id,passwd);

        if(check != UserService.ID_AND_PASSWD_OK){
            // 아이디 , 패스워드 모두 일치하지 않을 경우.
            String message ="";
            switch (check){
                case UserService.ONLY_PASSWD_FAIL:
                    message = "패스워드 틀림";
                    break;
                case UserService.ID_AND_PASSWD_FAIL:
                    message="아이디 없음";
                    break;
             }
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<script>");
            out.println("alert('" + message + "');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
            return null;

        }
        // 아이디 패스워드 일치하면 session 값 만들기
        // 추후에 UserVO userVO 에다 @modelAttribute 로 담을 예정.
        session.setAttribute("id",id);

        return "redirect:/login/main";

*/


//
//        userVO = this.userService.selectUserLogin(userVO.getId());
//        this.userService.login(userVO, request);
//        // 여기서 서비스Impl.login에서 request 세션 저장해줬고.
//
//
//
//        // System.out.println(userVO.getId());
//
//        model.addAttribute("is_user",this.userService.selectUserLogin(userVO.getId()));


//    }
    /*public String main(HttpSession session){
        String id = (String) session.getAttribute("id");
        // 세션에 id 값이 없으면 loginForm으로 이동.
        if(id==null){
            return "redirect:/login/login";
        }
        return "board/list";
        // return 값 추후에 main페이지로 바꿀 예정.
    }*/

    @RequestMapping("/logout")
    public ModelAndView logoutExecute(HttpServletRequest request) {

        UserVO user = (UserVO) request.getSession().getAttribute("user");

        System.out.println(user.getId());
        ModelAndView mv = new ModelAndView();
        System.out.println("여기까지 오나?");
        mv.setViewName("login/logout_result");
        // 이렇게 setViewName 해줘도 되고 아니면 new ModelAndview("login/logout_result") 이렇게 해줘도 된다.

        mv.addObject("id", user.getId());

        request.getSession().removeAttribute("user");
        // 위에는 "user"만 지우는거
        // request.getSession().invalidate();
        // 아래에는 Session 전부 삭제.

        // session.invalidate();
        return mv;

    }
}