package com.team02.prime.mapper;

import com.team02.prime.model.SeatVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SeatMapper {
    List<SeatVO> findAll();

    SeatVO findBySeatNum(int seat_num);

    void updateSeat(SeatVO seatVO);
}
