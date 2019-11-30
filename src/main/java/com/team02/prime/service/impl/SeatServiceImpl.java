package com.team02.prime.service.impl;

import com.team02.prime.mapper.SeatMapper;
import com.team02.prime.model.SeatVO;
import com.team02.prime.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatMapper seatMapper;

    @Override
    public List<SeatVO> read() {
        return this.seatMapper.findAll();
    }

    @Override
    public Object read(int seat_num) {
        return seatMapper.findBySeatNum(seat_num);
    }

    @Override
    public SeatVO updateSeatAvailable(int seat_num) {
        SeatVO seat = seatMapper.findBySeatNum(seat_num);

        seat.setSeat_available(seat.getSeat_available() == true ? false : true);
        seatMapper.updateSeat(seat);
        System.out.println(seat.getSeat_available());
        SeatVO retrunSeat = SeatVO.builder()
                .seat_available(seat.getSeat_available())
                .seat_num(seat_num)
                .build();
        return retrunSeat;
    }
//    @Override
//    public String updateSeatAvailable(int seat_num, Object data){
//        SeatVO seat = seatMapper.findBySeatNum(seat_num);
//        if(seat.getSeat_available() == true){
//            seat.setSeat_available(false);
//        }else{
//            seat.setSeat_available(true);
//            seat.getSeat_starttime(data.starttime);
//        }
//        seatMapper.save(seat);
//    }

}
