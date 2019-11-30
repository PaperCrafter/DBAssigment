package com.team02.prime.service.impl;

import com.team02.prime.mapper.ReplyMapper;
import com.team02.prime.model.ReplyVO;
import com.team02.prime.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;


    @Override
    public void saveReply(ReplyVO replyVO) {
        this.replyMapper.saveReply(replyVO);
    }

    @Override
    public void updateReply(ReplyVO replyVO) {
        this.replyMapper.updateReply(replyVO);
    }

    @Override
    public int deleteReply(int reply_num, String reply_id) {
        return this.replyMapper.deleteReply(reply_num);
    }
}
