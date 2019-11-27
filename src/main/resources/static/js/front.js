$(function(){

    //硫붾돱踰꾪듉
    var menuBtn = $('header nav h2');
    menuBtn.on('click', function(){
        $(this).toggleClass('open');
        $(this).next('ul').toggle();
    });

    //�ㅽ겕濡ㅼ씠�� 踰꾪듉
    var scrMoveBtn = $('.scr_move');
    scrMoveBtn.on('click', function(){
        var thisHref = $(this).attr("href").replace("#",".");
        $('body, html').animate({
            scrollTop:$(thisHref).offset().top - $('header').height()
        },500);
    });

    //濡쒓퀬 �대┃�� �곷떒�쇰줈 �ㅽ겕濡� �대룞
    $('header h1 a').on('click', function(){
        $('body, html').animate({
            scrollTop:0
        },500);
    });

    //�곷떒 �곷떞�섍린 踰꾪듉
    var counselBtn = $('.counsel_btn'),
        counselPop = $('.counsel_pop');
    counselBtn.on('click', function(){
        counselPop.show();
    });
    counselPop.find('> a').on('click', function(){
        counselPop.hide();
    });


    //諛섏쓳�� ����
    var $win = $(window),
        mainVisual = $('.main_visual');

    $win.on('resize', function(){
        //硫붿씤 鍮꾩��� �믪씠 吏���
        mainVisual.height($win.height());

        if ($win.width() < 640){
            mainVisual.height(450);
        }

        if ($win.width() < 768){
            $('header nav li a').on('click', function(){
                menuBtn.removeClass('open');
                menuBtn.next('ul').hide();
            });

            counselPop.css("top",$('header').innerHeight() - $('.gnb').position().top - 1);
            return false;
        }

        counselPop.css("top",$('header').innerHeight());
    }).resize();


    //怨듦컙�뚭컻 �щ씪�대뱶
    var spaceSlide = $('.space_slide > div > ul');
    spaceSlide.slick({
        arrows:false,
        dots:true
    });

    //吏��� �щ씪�대뱶
    $('.branch .branch_photo').slick({
        dots:true
    });

    $('.slick-dots li').on('mouseover', function(){
        $(this).parents('.slick-slider').slick('goTo', $(this).index());
    });


    //寃뚯떆�� �щ씪�대뱶
    $('.board_latest ul').slick({
        slidesToShow:1,
        rows:6
    });

    //寃뚯떆�� �쇱퀜蹂닿린
    $('.board_latest ul li a').on('click', function(){
        $(this).next('.board_con').slideToggle();
    });
});