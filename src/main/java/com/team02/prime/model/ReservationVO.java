package com.team02.prime.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVO {
    //pk
    private Integer reservation_num;

    //
    private LocalDateTime reservation_regdate;
    private LocalDateTime reservation_starttime;
    private LocalDateTime reservation_endtime;

    //fk
    private Integer user_number;
    private Integer seat_num;
}
