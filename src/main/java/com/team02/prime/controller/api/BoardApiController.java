package com.team02.prime.controller.api;


import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping(value ="/boards")
public class BoardApiController {

    private static final Logger logger = LoggerFactory.getLogger(BoardApiController.class);

    @Autowired
    private BoardService boardService;


    @GetMapping("/{board_num}/replies")
    public List<ReplyVO> getReplyList(@PathVariable("board_num")int board_num){
        // System.out.println("여기까지도 안오겠지??rest");

        List<ReplyVO> replyVOList = new ArrayList<>();
        replyVOList = boardService.getReplyList(board_num);
//        System.out.println(replyVOList.get(1));
//        System.out.println(replyVOList.get(2));
        return replyVOList;
    }

    @PostMapping("")
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

    @PatchMapping("")
    public ReplyVO updateReply(@RequestBody ReplyVO replyVO){
        this.boardService.updateReply(replyVO);
        String comment = replyVO.comment;
        return replyVO;
    }

    @DeleteMapping(value = "/{reply_num}")
    public void deleteReply(@PathVariable("reply_num") int reply_num){


        this.boardService.deleteReply(reply_num);
    }



}
