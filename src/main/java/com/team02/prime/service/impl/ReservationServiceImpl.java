package com.team02.prime.service.impl;

import com.team02.prime.mapper.ReservationMapper;
import com.team02.prime.mapper.SeatMapper;
import com.team02.prime.model.ReservationVO;
import com.team02.prime.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;


    @Override
    public ReservationVO create(ReservationVO reservationVO){
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
