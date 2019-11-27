package com.team02.prime.service;

import com.team02.prime.model.BoardPaging;
import com.team02.prime.model.BoardVO;
import com.team02.prime.model.ReplyVO;
import com.team02.prime.model.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface BoardService {

    /**
     * 게시물 등록
     * @param boardVO
     */
    void insertBoard(BoardVO boardVO);

    /**
     * 게시물 수정
     * @param boardVO
     */
    void updateBoard(BoardVO boardVO);

    /**
     * 게시물 삭제
     * @param board_number
     */
    void deleteBoard(HttpServletRequest request, int board_number);

    /**
     * 게시물 조회
     * @param board_number
     * @return
     */
    BoardVO selectBoard(int board_number);

    /**
     * 게시물 목록 조회
     * @return
     */
    Map<String,Object> selectBoardList(BoardPaging boardPaging);




    /**
     * 댓글조회
     * @param board_num
     * @return
     */

    List<ReplyVO> getReplyList(int board_num);


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

    /**
     * 게시물 수정 비번확인
     * @param boardVO
     * @return
     */
    BoardVO passConfirm(BoardVO boardVO);
}
