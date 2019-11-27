package com.team02.prime.controller;


import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(value ="/restBoard")
public class RestBoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/getReplyList",method = RequestMethod.POST)
    public List<ReplyVO> getReplyList(@RequestParam("board_num")int board_num){
        // System.out.println("여기까지도 안오겠지??rest");

        List<ReplyVO> replyVOList = new ArrayList<>();
        replyVOList = boardService.getReplyList(board_num);
//        System.out.println(replyVOList.get(1));
//        System.out.println(replyVOList.get(2));
        return replyVOList;
    }

    @RequestMapping(value = "/saveReply", method = RequestMethod.POST)
    public Map<String,Object> saveReply(@RequestBody ReplyVO replyVO){
        //System.out.println("--------여기까지 오긴 올거같은데???");
        Map<String,Object> result = new HashMap<>();

        try {
//            System.out.println("여기는 saveReply");
//            System.out.println(replyVO.toString());
            boardService.saveReply(replyVO);
            result.put("status", "OK");
        }
        catch (Exception e) {
            e.printStackTrace();
            result.put("status", "False");
        }

        return result;
    }
    @RequestMapping(value = "/updateReply",method = RequestMethod.POST)
    public void updateReply(@RequestBody ReplyVO replyVO){


        this.boardService.updateReply(replyVO);
//        System.out.println("여기까지 오나 보자");
    }

    @RequestMapping(value = "/deleteReply",method = RequestMethod.GET)
    public void deleteReply(@RequestParam("reply_num")int reply_num,
                            @RequestParam("reply_id")String reply_id){


        this.boardService.deleteReply(reply_num,reply_id);
    }



}
