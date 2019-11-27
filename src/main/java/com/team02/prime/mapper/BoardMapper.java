package com.team02.prime.mapper;

import com.team02.prime.model.BoardVO;
import com.team02.prime.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.team02.prime.model.BoardPaging;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BoardMapper {

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
     * @param board_num
     */
    void deleteBoard(int board_num);

    /**
     * 게시물 조회
     * @param board_num
     * @return
     */
    BoardVO selectBoard(int board_num);

    /**
     * 게시물 목록 조회
     * @return
     */
    List<BoardVO> selectBoardList(BoardPaging boardPaging);



    /**
     * 게시물 갯수 조회
     * @return
     */
    int selectBoardListCount(BoardPaging boardPaging);

    /**
     * 게시물 수정 비번 확인.
     * @return
     */
    BoardVO password(BoardVO boardVO);

}