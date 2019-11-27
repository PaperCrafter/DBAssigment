package com.team02.prime.controller;

import com.team02.prime.model.BoardPaging;
import com.team02.prime.model.BoardVO;
import com.team02.prime.model.UserVO;
import com.team02.prime.service.BoardService;
import com.team02.prime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.team02.prime.model.ReplyVO;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;


    //    @RequestMapping(value = "/board/insert", method = RequestMethod.GET)
    @GetMapping("/board/insert")
    public String boardInsert(@ModelAttribute UserVO userVO, HttpServletRequest request,Model model){


        System.out.println(userVO.toString());
        //  userVO =(UserVO)request.getAttribute("user");
//        System.out.println(user_number);

        model.addAttribute("user",userVO);



        System.out.println("=== user_number 넘어가나?");


                // 이거 안되면 request로 http에서 받아오는 걸로 다시 해보자.


        return "board/insert";
    }

    @PostMapping("/board/insert")
    public String boardInsertExecute(Model model, @ModelAttribute BoardVO boardVO ,HttpServletRequest request){

        log.debug("##### 게시물 등록 요청 처리 ####");
        log.debug(boardVO.toString());
        this.boardService.insertBoard(boardVO);

       /* System.out.println(boardVO.user_number);
        System.out.println(boardVO.board_password);
        System.out.println(boardVO.board_title);
        System.out.println(boardVO.getBoard_num());*/

        log.debug("##### 게시물 등록 결과 ####");

        log.debug(boardVO.toString());

        boardVO = this.boardService.selectBoard(boardVO.getBoard_num());

        model.addAttribute("board", boardVO);

        return "board/insert_after";
    }

    //@ResposeBody
    @GetMapping("/board/view/{board_num}")
    public String boardView(Model model,@PathVariable int board_num,HttpServletRequest request){
        BoardVO boardVO = new BoardVO();
        boardVO = this.boardService.selectBoard(board_num);
        model.addAttribute("board", boardVO);
        System.out.println("제발 왜이러냐나나나나나나나나나ㅏ나난");

        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        System.out.println(userVO.getId());

        model.addAttribute("user",this.userService.selectUser(userVO.getUser_number()));

        System.out.println("===========================================");
        System.out.println("user_number가 제대로 전달되나 한번 보자");
        System.out.println(boardVO.user_number);


        // 아래는 기존 boardView에다가 reply을 위한 replyVO를 model 에다가 담아줬다.
        model.addAttribute("reply", new ReplyVO());

        return "board/view";
    }





    @PostMapping("/board/delete/{board_num}")
    public String boardDelete(HttpServletRequest request, @PathVariable int board_num){
        this.boardService.deleteBoard(request, board_num);
        return "board/delete_after";
    }

    @GetMapping("/board/update/{board_num}")
    public String boardUpdate(Model model, @PathVariable int board_num){
        model.addAttribute("board", this.boardService.selectBoard(board_num));
        return "board/update";
    }

    @PostMapping("/board/update")
    public String boardUpdateExecute(Model model, @ModelAttribute BoardVO boardVO){
        this.boardService.updateBoard(boardVO);
        model.addAttribute("board", this.boardService.selectBoard(boardVO.getBoard_num()));
        return "board/insert_after";
    }

//    게시글 수정 비번 확인
    @PostMapping("/board/update_confirm/{board_num}")
    @ResponseBody
    public Map<String,Object> boardUpdateConfirm(@PathVariable int board_num, @RequestParam("board_password") String board_password){

//        System.out.println("일단 여기까지 오나 보자.");
        //========================================================================
        // 아래는 게시글 수정할때 비번 확인하는 코드.
        //========================================================================
        boolean flag =false;
        Map<String,Object> map = new HashMap<>();

        System.out.println("---------여기는 board_num이랑  사용자가 입력한 password------------");
        System.out.println(board_num);
        System.out.println(board_password);

        BoardVO boardVO = new BoardVO();
        boardVO.setBoard_num(board_num);
        boardVO.setBoard_password(board_password);

        boardVO = this.boardService.passConfirm(boardVO);

        System.out.println("여기는 비번이 맞았을때는 맞게 나오고 틀렸을때는 null 값이 나올거다 아마.");


//        System.out.println(boardVO.getBoard_num());
//        System.out.println(boardVO.getBoard_password());
//        System.out.println(boardVO.user_number);
        // 비번이 틀렸으면 boardVO가 null을 리턴 하므로
        if (boardVO ==null ){
            flag=false;

        }else{
            // 비번이 맞아서 boardVO가 null이 아닐때
            flag =true;
        }
        map.put("flagdata",flag);

        return map;
    }



   /* @GetMapping("/board/list")
        public String boardList(Model model, @ModelAttribute BoardPaging boardPaging){
            // Map<String,Object> map = model.addAllAttributes(this.boardService.selectBoardList(boardPaging));
       *//* BoardVO boardVO;
        boardVO = this.boardService.selectBoard(boardVO.getUser_number());*//*



            model.addAllAttributes(this.boardService.selectBoardList(boardPaging));

            // Map<String,Object> boardlist = new HashMap<>();



            return "board/list";
    }S
*/
    @GetMapping("/board/list")
    public String boardList(Model model, @ModelAttribute BoardPaging boardPaging){
        // Map<String,Object> map =
        // model.addAllAttributes(this.boardService.selectBoardList(boardPaging));
       /* BoardVO boardVO;
        boardVO = this.boardService.selectBoard(boardVO.getUser_number());*/

        model.addAllAttributes(this.boardService.selectBoardList(boardPaging));
//        Map<String,Object> map = new HashMap<>();
//        map = this.boardService.selectBoardList(boardPaging);

//        model.addAttribute("boardList", map.get("boardList"));
//        model.addAttribute("boardPaging", map.get("boardPaging"));

        //model.addAllAttributes("ASD", );

//         Map<String,Object> map = new HashMap<String, Object>();
//         map.put("boardList",model);


        return "board/list";
    }


    @GetMapping("/postcode")
    public String postocde(){
        return "postcode";
    }






}
