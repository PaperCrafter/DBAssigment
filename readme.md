# �����ͺ��̽� ������ ������ ���� ��������

------
## ���� ���

1. ������ ��Ʈ ������Ʈ ����

2. localhost:8092/home ����


## URL

##Page Controller


###Home Controller

|page |HTTP method|rout|
|-----------|------|------|
|����������|get|/home|

###LoginControll

|page |HTTP method|rout|
|-----------|------|------|
|�α��� ������|get|/login/login|
|�α��� ���|post|/login/login_result|
|�α׾ƿ� |get|/login/logout|


## RESTful api

#### Board

|CRUD|HTTP method|Rout|
|-----------|------|------|
|Ư�� ���忡 ���� ��� ��ü ��������|get|/boards/{board_num}/replies|

#### Reply

|CRUD|HTTP method|Rout|
|-----------|------|------|
|���� ���|post|/replies|
|���� ����|patch|/replies|
|���� ����|delete|/replies/{reply_num}


#### Reservation

|CRUD|HTTP method|Rout|
|-----------|------|------|
|��ü ���� ��������|get|/reservations|
|���� �ϳ� ��������|get|/reservations/{reservation_num}|
|���� ����|post|/memos/{{reservation_num}}|

#### Seat

|CRUD|HTTP method|Rout|
|-----------|------|------|
|��ü �¼� ��������|get|/seats|
|Ư�� �¼� ��������|get|/seats/{seat_num}|
|�¼� ���� ����(���డ��/����Ұ�)||/seats/{seatnum}|

