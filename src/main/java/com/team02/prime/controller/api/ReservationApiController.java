package com.team02.prime.controller.api;

import com.team02.prime.model.ReservationVO;
import com.team02.prime.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationApiController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("")
    public List<ReservationVO> read(){
        return reservationService.read();
    }

    @GetMapping("/{reservation_num}")
    public ReservationVO readByResNo(@PathVariable int reservation_num){
        return reservationService.readByResNum(reservation_num);
    }

    @PostMapping("")
    public ReservationVO create(@RequestBody ReservationVO reservationVO){
        return reservationService.create(reservationVO);
    }

}
