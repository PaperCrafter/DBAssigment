var reply_save = function(){

    var comment = $('#comment').val();
    var url = "/boards";
    /*
    //var board_num = {"board_num" : [[ ${board.board_num} ]]};
    //var reply_id ={"reply_id":[[ ${user.id} ]]};

    // 8.20 왜 위 주석 처럼 하면 안되고, 그 밑에 거처럼 하면 은 되는지 물어보기.
     ---> 검색과 추측해서 내린 결론은 JSON.stringify에서 스트링화해주는건데
    var paramData = JSON.stringify({
        "comment": comment
        , "reply_id": reply_id
        , "board_num": board_num
    });
    위의 방식대로 하면 여기서 "1.reply_id": 2.reply_id 에서  2.reply_id가 @Requestbody로 받아질때 replyVO 객체랑
    안맞아서 그런가?  근데 그러면 reply_id는 원래 스트링인데 replyVO 에서도 string인데....
    */
    var reply_id = [[${user.id}]];
    board_num = [[${board.board_num}]];

    var reply = JSON.stringify({
        "comment": comment ,
        "reply_id": reply_id,
        "board_num": board_num
    });

    var headers = {"Content-Type" : "application/json"};

    $.ajax({
        url: url
        , headers : headers
        , data : reply
        , type : "POST"
        , dataType : 'JSON'
        , success: function(result){
            showReplyList();
            $('#comment').val('');
            $('#reply_id').val('');
        }
        , error: function(error){
            console.log("에러 : " + error);
        }
    });
};


// ================================================================================================
// 게시판 수정/ 삭제 눌렀을 때 실행되는 script

var modifyBoard = function(){
    var board_num = /*[[ ${board.board_num} ]]*/;

    $('#viewForm')
        .attr('action','/board/update/' + board_num)
        .attr('method','get')
        .submit();
};

var deleteBoard = function(){
    var board_num = /*[[ ${board.board_num} ]]*/;
    if(confirm('삭제하시겠습니까?')){
        $('#viewForm')
            .attr('action','/board/delete/' + board_num)
            .attr('method','post')
            .submit();
    }
};

var listBoard = function(){
    location.href='/board/list';
};

<!--================================================================================================-->
<!--
            댓글 수정버튼만 눌렀을때 실행되는 스크립트
-->

function fn_editReply(reply_num, reply_id, comment){
    var r_htmls = "";
    r_htmls += '<div class="media text-muted pt-3" id="reply_num' + reply_num + '">';
    r_htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
    r_htmls += '<title>Placeholder</title>';
    r_htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
    r_htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
    r_htmls += '</svg>';
    r_htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
    r_htmls += '<span class="d-block">';
    r_htmls += '<strong class="text-gray-dark">' + reply_id + '</strong>';
    r_htmls += '<span style="padding-left: 7px; font-size: 9pt">';
    r_htmls += '<a href="javascript:void(0)" onclick="fn_updateReply('+ reply_num +')" style="padding-right:5px">저장</a>';
    r_htmls += '<a href="javascript:void(0)" onclick="showReplyList()">취소<a>';
    r_htmls += '</span>';
    r_htmls += '</span>';
    r_htmls += '<textarea name="editComment" id="editComment" class="form-control" rows="3">';
    r_htmls += comment;
    r_htmls += '</textarea>';

    r_htmls += '</p>';
    r_htmls += '</div>';

    $('#reply_num' + reply_num).replaceWith(r_htmls);
    $('#reply_num' + reply_num + ' #editComment').focus();
}



    <!--================================================================================================-->
    <!--
    댓글 수정하기 눌렀을때 실행되는 스크립트
    -->
function fn_updateReply(reply_num){
    var replyEditComment = $('#editComment').val();
    var url = "/boards";
    var data = JSON.stringify(
        {
            "comment": replyEditComment,
            "reply_num": reply_num
        }
    );

    var headers = {"Content-Type" : "application/json"};
    $.ajax({
        url: url,
        headers : headers,
        data : data,
        type : "PATCH",
        dataType : 'JSON',
        success: function(result){
            console.log(123);
            var elem = $('reply_num' + reply_num).parent().children('editComment');
            elem.val(replyEditComment);
            showReplyList();
        },
        error: function(error){
            console.log("에러 : " + error);
        }
    });
}

function fn_deleteReply(reply_num){
    var url = "/boards" + "/" + reply_num ;
    $.ajax({
        url: url,
        type : 'DELETE',
        success: function(result){
            showReplyList();
        },
        error: function(error){
            console.log("에러 : " + error);
        }
    });
}


$(document).ready(function(){
    showReplyList();
});

function showReplyList(){
    var url = "/boards" ;
    var board_num = [[${board.board_num}]] ;
    url = url + "/" + board_num + "/replies";
    // var board_num = {"board_num" : [[ ${board.board_num} ]]};
    var user_id = [[${user.id}]];

    // var board_num = [[${board.board_num}]];
    $.ajax({
        type: "GET",
        url: url,
        dataType:'json',
        success: function(result) {
            var r_htmls = "";
            if(result.length < 1){
                r_htmls += '<p>등록된 댓글이 없습니다. </p>';

            } else {
                $(result).each(function () {
                    r_htmls += '<div class="media text-muted pt-3" id="reply_num' + this.reply_num + '">';
                    r_htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';
                    r_htmls += '<title>Placeholder</title>';
                    r_htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';
                    r_htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';
                    r_htmls += '</svg>';
                    r_htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';
                    r_htmls += '<span class="d-block">';
                    r_htmls += '<strong class="text-gray-dark">' + this.reply_id + '</strong>';
                    r_htmls += '<span style="padding-left: 7px; font-size: 9pt">';

                    // 본인 댓글일때
                    if(user_id == this.reply_id){
                        r_htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.reply_num + ', \'' + this.reply_id + '\', \'' + this.comment + '\' )" style="padding-right:5px">수정</a>';
                        r_htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply('+this.reply_num+')" >삭제</a>';
                    }
                    else{
                    }
                    r_htmls += '</span>';
                    r_htmls += '</span>';
                    r_htmls += this.comment;

                    r_htmls += '</p>';
                    // <span th:text="${#dates.format(board.board_register_date, 'YYYY-mm-dd HH:mm')}">
                    r_htmls += '<span style="padding-right:4px; font-size:small">' + this.register_date +'</span>';
                    r_htmls += '</div>';
                });	//each end
            }
            $("#replyList").html(r_htmls);
        }	   // Ajax success end
    });	// Ajax end
}