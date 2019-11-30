package com.team02.prime.controller.api;

import com.team02.prime.model.SeatVO;
import com.team02.prime.service.ReservationService;
import com.team02.prime.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatApiController {

    @Autowired
    SeatService seatService;

//    @Autowired
//    ReservationService reservationService;

    @GetMapping("/{seat_num}")
    public Object readSeats(@PathVariable("seat_num") int seat_num){
        Object seat = seatService.read(seat_num);
        return seat;
    }

    @GetMapping("")
    public List<SeatVO> read(){
        return seatService.read();
    }

    @PatchMapping("/{seat_num}")
    public SeatVO update(@PathVariable int seat_num ){
        return seatService.updateSeatAvailable(seat_num);
    }

}
