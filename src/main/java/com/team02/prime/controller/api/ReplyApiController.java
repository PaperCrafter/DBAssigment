package com.team02.prime.controller.api;

import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.BoardService;
import com.team02.prime.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value ="/replies")
public class ReplyApiController {

    @Autowired
    ReplyService replyService;

    @Autowired
    BoardService boardService;

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

    @PatchMapping(value = "/updateReply")
    public String updateReply(@RequestBody ReplyVO replyVO){


        this.replyService.updateReply(replyVO);
        return "Success";
    }

    @DeleteMapping(value = "/deleteReply/{reply_num}/{reply_id}")
    public void deleteReply(@PathVariable("reply_num")int reply_num,
                            @PathVariable("reply_id")String reply_id){


        this.replyService.deleteReply(reply_num,reply_id);
    }
}
