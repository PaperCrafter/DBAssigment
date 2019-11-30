package com.team02.prime.service;

import com.team02.prime.model.ReplyVO;

public interface ReplyService {
    /**
     * 댓글등록
     * @param replyVO
     * @return
     */
    void saveReply(ReplyVO replyVO);

    /**
     * 댓글수정
     * @param replyVO
     * @return
     */
    void updateReply(ReplyVO replyVO);

    /**
     * 댓글삭제
     * @param reply_num
     * @return
     */
    int deleteReply(int reply_num,String reply_id);
}
