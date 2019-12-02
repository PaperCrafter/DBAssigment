package com.team02.prime.service.impl;

import com.team02.prime.mapper.ReservationMapper;
import com.team02.prime.mapper.SeatMapper;
import com.team02.prime.model.ReservationVO;
import com.team02.prime.model.SeatVO;
import com.team02.prime.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private SeatMapper seatMapper;

    @Override
    public ReservationVO create(ReservationVO reservationVO){
        //자리 사용 처리
        int seat_num = reservationVO.getSeat_num();
        SeatVO seatVO = SeatVO.builder()
                .seat_num(seat_num)
                .seat_available(false)
                .build();
        seatMapper.updateSeat(seatVO);
        System.out.println(seatVO.getSeat_available());
        //예약 생성
        reservationMapper.create(reservationVO);
        ReservationVO reservation = new ReservationVO();
        return reservation;
    }

    @Override
    public List<ReservationVO> read(){
        return reservationMapper.findAll();
    }

    @Override
    public ReservationVO readByResNum(int reservation_num) {
        return reservationMapper.findByResNum(reservation_num);
    }

    @Override
    public String delete(int reservation_num){
        reservationMapper.delete(reservation_num);
        return "deleted";
    }

}
