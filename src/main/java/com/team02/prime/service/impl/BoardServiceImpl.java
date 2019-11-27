package com.team02.prime.service.impl;

import com.team02.prime.mapper.BoardMapper;
import com.team02.prime.mapper.ReplyMapper;
import com.team02.prime.mapper.UserMapper;
import com.team02.prime.model.BoardPaging;
import com.team02.prime.model.BoardVO;
import com.team02.prime.model.ReplyVO;
import com.team02.prime.model.UserVO;
import com.team02.prime.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ListUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void insertBoard(BoardVO boardVO) {
        this.boardMapper.insertBoard(boardVO);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        this.boardMapper.updateBoard(boardVO);
    }

    @Override
    public void deleteBoard(HttpServletRequest request, int board_num) {

        /*
        // session을 통해 사용자 인증정보 조회
        MemberVO memberVO = (MemberVO)request.getSession().getAttribute("memberVO");

        // 해당 게시물 조회하여 등록된 사용자의 삭제 요청인지 비교
        BoardVO board = this.boardMapper.selectBoard(qna_no);
        if(board.getM_no() == memberVO.getM_no()){
            this.boardMapper.deleteBoard(qna_no);
        }
        */

        this.boardMapper.deleteBoard(board_num);

    }

    @Override
    public BoardVO selectBoard(int board_num) {
        return this.boardMapper.selectBoard(board_num);
    }

    @Override
    public Map<String,Object> selectBoardList(BoardPaging boardPaging) {

        Map<String, Object> map = new HashMap<>();

        /**
         * 처음 진입한 경우 currentPage 등 초기화 해줍니다.
         */
        if (boardPaging.getCurrentPage() == 0) {
            boardPaging.setCurrentPage(1); // 1page 부터 조회
            boardPaging.setArticleCount(20); // 페이지당 게시물 갯수
        }

        boardPaging.setTotalCount(this.boardMapper.selectBoardListCount(boardPaging));

        map.put("boardPaging", boardPaging);
        map.put("boardList", this.boardMapper.selectBoardList(boardPaging));


       /*
           for (int i = 0; i <= boardVOList.size() - 1; i++) {
                //boardVOList.add(i, this.boardMapper.selectBoardId((BoardVO) boardVOList.get(i)));
                String id = this.boardMapper.selectBoardId((BoardVO) boardVOList.get(i));
                System.out.println(id);
                System.out.println("===============================================");
                boardVOList.add(i,id);
                System.out.println("Okay 여기까지는 된다.");
            }
            boardVOList.addAll(ids);
        */

        return map;

    }



    @Override
    public List<ReplyVO> getReplyList(int board_num) {

        return this.replyMapper.getReplyList(board_num);

    }

    @Override
    public void updateReply(ReplyVO replyVO){

        this.replyMapper.updateReply(replyVO);

    }



    @Override
    public void saveReply(ReplyVO replyVO){

        this.replyMapper.saveReply(replyVO);

    }




    @Override
    public int deleteReply(int reply_num,String reply_id){

        return this.replyMapper.deleteReply(reply_num,reply_id);

    }

   @Override
    public BoardVO passConfirm(BoardVO boardVO){
        return this.boardMapper.password(boardVO);
    }







}
