package com.team02.prime.service;

import com.team02.prime.model.ReservationVO;

import java.util.List;

public interface ReservationService {

    /**
     * 예약 생성
     * @param reservationVO
     */
    ReservationVO create(ReservationVO reservationVO);

    /**
     * 예약 조회
     */
    List<ReservationVO> read();

    /**
     * 예약 하나 조회
     * @param reservation_num
     */
    ReservationVO readByResNum(int reservation_num);

    /**
     * 예약 삭제
     */
    String delete(int reservation_num);

}
