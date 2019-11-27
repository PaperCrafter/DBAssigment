package com.team02.prime.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplyVO {

    public int board_num;
    public int reply_num;
    public String comment;
    public String reply_id;
    public String register_date;
    public int user_number;

    @Override
    public String toString() {
        return "ReplyVO{" +
                "board_num=" + board_num +
                ", reply_num=" + reply_num +
                ", comment='" + comment + '\'' +
                ", reply_id='" + reply_id + '\'' +
                ", register_date=" + register_date +
                ", user_number=" + user_number +
                '}';
    }

    public int getBoard_num() {
        return board_num;
    }

    public void setBoard_num(int board_num) {
        this.board_num = board_num;
    }

    public int getReply_num() {
        return reply_num;
    }

    public void setReply_num(int reply_num) {
        this.reply_num = reply_num;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id;
    }

    public String getRegister_date() {
        return register_date;
    }

    /*public String getRegister_date_str(){
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return transFormat.format(this.register_date);
    }*/

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public int getUser_number() {
        return user_number;
    }

    public void setUser_number(int user_number) {
        this.user_number = user_number;
    }
}
