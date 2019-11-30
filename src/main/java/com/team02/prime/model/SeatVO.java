package com.team02.prime.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatVO {
    //pk
    private Integer seat_num;
    //fk
    private Boolean seat_available;
}
