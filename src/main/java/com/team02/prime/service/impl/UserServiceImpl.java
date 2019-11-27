package com.team02.prime.service.impl;

import com.team02.prime.mapper.UserMapper;
import com.team02.prime.model.UserVO;
import com.team02.prime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public UserVO login(UserVO userVO, HttpServletRequest request){

        log.debug("############ 로그인 요청 정보 #############");
//        System.out.println(userVO.getId());
//        System.out.println(userVO.toString());
        log.debug(userVO.toString());

        /**
         * Mapper 통해 Database 에서 조회한 회원정보
         */
       /*

        userVO.setAddress("서울");
        userVO.setGender("m");
        userVO.setUser_number(1);
        userVO.setPhonenumber("010-1234-5678");
        userVO.setName("홍길동");

        */


        if(userVO!=null){
            request.getSession().setAttribute("user", userVO);

        }
        else{
            // log out 도 동일하게 처리 가능합니다.
            request.getSession().removeAttribute("user");

        }

        return userVO;






    }


    @Override
    public void insertUser(UserVO userVO) {
        this.userMapper.insertUser(userVO);
    }

    @Override
    public void updateUserInfo(UserVO userVO) {
        this.userMapper.updateUserInfo(userVO);
    }

    @Override
    public void deleteUser(HttpServletRequest request,int user_number) {

        //session을 통해 관리자 인증정보 조회
        UserVO userVO = (UserVO)request.getSession().getAttribute("userVo");


        UserVO user = this.userMapper.selectUser(user_number);

        if(user.getId() == userVO.getId()){
            this.userMapper.deleteUser(user_number);
        }


        this.userMapper.deleteUser(user_number);
    }
    @Override
    public void delete_b_User(HttpServletRequest request,int user_number){

        this.userMapper.delete_b_User(user_number);
    }

    @Override
    public UserVO selectUser(int user_number) {
        return this.userMapper.selectUser(user_number);
    }

    @Override
    public UserVO selectUserLogin(String id,String passwd) {


        return this.userMapper.selectUserLogin(id,passwd);


    }




    @Override
    public List<UserVO> selectUserList() {
        return this.userMapper.selectUserList();
    }
}