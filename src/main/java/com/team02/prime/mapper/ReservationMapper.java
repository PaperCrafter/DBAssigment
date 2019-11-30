package com.team02.prime.mapper;

import com.team02.prime.model.ReservationVO;
import com.team02.prime.model.SeatVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
@Repository
public interface ReservationMapper {
    void create(ReservationVO reservationVO);

    List<ReservationVO> findAll();

    ReservationVO findByResNum(int reservation_num);

    String delete(int reservation_num);
}
