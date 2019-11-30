package com.team02.prime.service;

import com.team02.prime.model.SeatVO;

import java.util.List;


public interface SeatService {

    /**
     * 전체 자리 조회
     */
    List<SeatVO> read();

    /**
     * 선택 자리 조회
     * @param seat_num
     */
    Object read(int seat_num);

    /**
     * 선택 상태 업데이트
     * @param seat_num
     */
    SeatVO updateSeatAvailable(int seat_num);
}
