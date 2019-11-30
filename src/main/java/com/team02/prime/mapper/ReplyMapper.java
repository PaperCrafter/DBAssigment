package com.team02.prime.mapper;


import com.team02.prime.model.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    /**
     *     댓글조회
     *    @param board_num
     */
    List<ReplyVO> getReplyList(int board_num);

    /**
     *     댓글등록
     *    @param replyVO
     */
    void saveReply(ReplyVO replyVO);

    /**
     *     댓글수정
     *    @param replyVO
     */
    void updateReply(ReplyVO replyVO);

    /**
     *     댓글삭제
     *    @param reply_num,reply_id
     */
    int deleteReply(int reply_num);



}
