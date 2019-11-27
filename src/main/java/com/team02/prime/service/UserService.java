package com.team02.prime.service;

import com.team02.prime.model.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface UserService {

    /*public static final int ID_AND_PASSWD_OK =1;
    public static final int ONLY_PASSWD_FAIL =0;
    public static final int ID_AND_PASSWD_FAIL =-1;*/


   /* *//**
     *    로그인
   //  *    @param userVO,request
     */
    // UserVO login(UserVO userVO, HttpServletRequest request);

   UserVO login(UserVO userVO, HttpServletRequest request);


    /**
     *     회원가입_등록_확인후
     *    @param userVO
     */
    void insertUser(UserVO userVO);


    /**
     *     회원정보_수정
     *    @param userVO
     */
    void updateUserInfo(UserVO userVO);

    /**
     *     회원탈퇴
     *     @param user_number
     */
    void deleteUser(HttpServletRequest request,int user_number);

    /**
     *     가입전 회원 삭제
     *     @param user_number
     */
    void delete_b_User(HttpServletRequest request,int user_number);

    /**
     * 회원조회
     * @param user_number
     * @return
     */
    UserVO selectUser(int user_number);

    /**
     * 로그인한 회원 조회.
     * @param id
     * @return
     */
    UserVO selectUserLogin(String id,String passwd);


    /**
     * 회원 목록 조회
     * @return
     */
    List<UserVO> selectUserList();

}