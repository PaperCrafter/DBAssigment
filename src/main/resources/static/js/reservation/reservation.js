var settings = {
    seatCss: 'seat',
    selectedSeatCss: 'selectedSeat',
    selectingSeatCss: 'selectingSeat'
};

$('.' + settings.seatCss).click(function() {
    if ($(this).hasClass(settings.selectedSeatCss)) {
        alert('This seat is already reserved');
    } else {
        $(this).toggleClass(settings.selectingSeatCss);
    }
});

$('#btnShow').click(function() {
    var str = [];
    $.each($('#place li.' + settings.selectedSeatCss + ' a, #place li.' + settings.selectingSeatCss + ' a'), function(index, value) {
        str.push($(this).attr('title'));
    });
    alert(str.join(','));
})

$('#btnShowNew').click(function() {
    var str = [],
        item;
    $.each($('#place li.' + settings.selectingSeatCss + ' a'), function(index, value) {
        item = $(this).attr('title');
        str.push(item);
    });
    alert(str.join(','));
})

$(function () {
    $.ajax({
        url :'/seats',
        method:'GET',
        success: function(seats) {
            console.log(seats);
            seat_table = $("#seat_table_body");
            var column_idx = 0
            var seat_tr;
            seats.map((seat, index) => {
                if(index % 10 === 0){
                    column_idx++;
                    var seat_tr = document.createElement("tr");
                    seat_tr.setAttribute("id", "column"+column_idx);
                    seat_table.append(seat_tr);
                }
                seat_tr = document.getElementById("column"+column_idx);

                var seat_td = document.createElement("td");
                seat_td.setAttribute("id", index);
                seat_td.setAttribute("class", "seat"+seat.seat_num);
                var seat_a = document.createElement("a");
                seat_a.setAttribute("class",  seat.seat_available);
                seat_a.textContent = seat.seat_num;


                if(seat.seat_available == false){
                    seat_a.setAttribute( "href","#");
                    //seat_a.addEventListener("click", reserved);
                }else{
                    var href = "seats/" + seat.seat_num;
                    //선택좌석 설정
                    $("#seat_num").val(seat.seat_num);


                    //seat_a.setAttribute( "href","#open");
                    //seat_a.addEventListener("click", reserve);
                }

                seat_td.appendChild(seat_a);
                seat_tr.appendChild(seat_td);
            });
            changePopupStatus();
            addReserveevent();
        }

    })
});

//
function changePopupStatus() {
    //TODO 유저넘버 임시 설정 => 세션으로 바꿔줘야함
    var user =8;
    if(user != "") {
        $(".true").on("click", function () {
            console.log("상태전환함수 클릭!");
            console.log(this);
            if (this.getAttribute("class") == "true") {
                console.log("함수 내부 접속!");
                console.log(this.textContent)
                $("#seat_num").text(this.textContent);
                location.href = "#open";
            } else {
                console.log("함수 내부 접속 실패!");
                return false;
            }
        });
    }else{
        $(".true").on("click", function () {
            alert("로그인을 해 주세요.");
        });
    }
}

function addReserveevent() {
    $("#btn_submit").on("click", function () {

        //TODO 유저넘버 임시 설정 => 세션으로 바꿔줘야함
        var user = 8

        console.log(this.parentElement);
        console.log(this);
        if(user) {
            var data = JSON.stringify({
                user_number : user,
                seat_num : $("#seat_num").text(),
                reservation_starttime : "2016-01-25T21:34:55",
                reservation_endtime : "2016-01-25T21:34:55",
            });

            $.ajax({
                url: '/reservations',
                contentType: "application/json",
                header:{
                    "Accept" : "application/json",
                    "charset":"UTF-8"
                },
                method: 'POST',
                data: data,
                success: function (seats) {
                    this.class = false;
                    console.log("Success");
                    location.href = '/reservation';
                    alert("에약되었습니다.");
                }
            })
        }else{
            return false;
        }
    });
}

// $("td").each(function(){
//     console.log(this);
//     $("td", this).live("click", function(){
//         console.log(this);
//     });
// });