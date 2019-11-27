package com.team02.prime.model;

import java.util.Date;

public class BoardVO {

    public int board_num;
    public String board_title;
    public String board_password;
    public Date board_register_date;
    public String board_content;
    public int board_view_cnt;
    public int user_number;
    public String id;

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "board_num=" + board_num +
                ", board_title='" + board_title + '\'' +
                ", board_password='" + board_password + '\'' +
                ", board_register_date=" + board_register_date +
                ", board_content='" + board_content + '\'' +
                ", board_view_cnt=" + board_view_cnt +
                ", user_number=" + user_number +
                '}';
    }


    public int getBoard_num() {
        return board_num;
    }

    public void setBoard_num(int board_num) {
        this.board_num = board_num;
    }

    public String getBoard_title() {
        return board_title;
    }

    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    public String getBoard_password() {
        return board_password;
    }

    public void setBoard_password(String board_password) {
        this.board_password = board_password;
    }

    public Date getBoard_register_date() {
        return board_register_date;
    }

    public void setBoard_register_date(Date board_register_date) {
        this.board_register_date = board_register_date;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public int getBoard_view_cnt() {
        return board_view_cnt;
    }

    public void setBoard_view_cnt(int board_view_cnt) {
        this.board_view_cnt = board_view_cnt;
    }

    public int getUser_number() {
        return user_number;
    }

    public void setUser_number(int user_number) {
        this.user_number = user_number;
    }
}