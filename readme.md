# 데이터베이스 과제용 독서실 예약 웹페이지

------
## 실행 방법

1. 스프링 부트 프로젝트 실행

2. localhost:8092/home 접속


## URL

##Page Controller


###Home Controller

|page |HTTP method|rout|
|-----------|------|------|
|메인페이지|get|/home/home_main|

###LoginControll

|page |HTTP method|rout|
|-----------|------|------|
|로그인 페이지|get|/login/login|
|로그인 결과|post|/login/login_result|
|로그아웃 |get|/login/logout|


## RESTful api

#### Board

|CRUD|HTTP method|Rout|
|-----------|------|------|
|특정 보드에 대한 댓글 전체 가져오기|get|/boards/{board_num}/replies|

#### Reply

|CRUD|HTTP method|Rout|
|-----------|------|------|
|응답 등록|post|/replies|
|응답 수정|patch|/replies|
|응답 삭제|delete|/replies/{reply_num}


#### Reservation

|CRUD|HTTP method|Rout|
|-----------|------|------|
|전체 예약 가져오기|get|/reservations|
|예약 하나 가져오기|get|/reservations/{reservation_num}|
|예약 생성|post|/memos/{{reservation_num}}|

#### Seat

|CRUD|HTTP method|Rout|
|-----------|------|------|
|전체 좌석 가져오기|get|/seats|
|특정 좌석 가져오기|get|/seats/{seat_num}|
|좌석 상태 수정(예약가능/예약불가)||/seats/{seatnum}|

