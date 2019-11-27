/**
 *gnb 硫붾돱 �좏깮
 */
var navFun = {
  init: function() {
    this.navAction();
    this.navAction2();
  },
  navAction: function() {
    var gnb_link = $('.pc_gnb_wrap .depth01').children('a');
    var gnb_link_depth02 = $('.sub_menu_list li a');
    var gnb_link_depth02_sub = $('.sub_menu_type_c .li_02 .des_con li a');

    var url = window.location.href;

    var src = url.split('/')[url.split('/').length - 1].split('.')[0] /*. �ㅼ뿉 �먮쫫*/ ;

    /*[0]:�먮Ⅴ怨� �섎㉧吏� [1]:�섎씪吏� 議곌컖*/

    // console.log("�곸뒪1 "+src_depth01);
    // console.log("�곸뒪2 "+src_depth02);

    src01 = src.split('?')[0].split('-')[0].split('_')[0];
    src02 = src.split('?')[0].split('-')[0].slice(0, -3);
    src03 = src.split('?')[0].split('-')[0];

    // console.log("�곸뒪1 "+src01);
    // console.log("�곸뒪2 "+src02);
    // console.log("�곸뒪3 "+src03);r

    /*�곸뒪 1 �쒖꽦��*/
    gnb_link.each(function() {
      var this_href = $(this).attr('href');
      var href = this_href.split('/')[this_href.split('/').length - 1].split('.')[0].split('_')[0];
      console.log("泥ル쾲吏� "+href);
      if (href == src01) {
        $(this).addClass('active');
      } else {
        $(this).removeClass('active')
      }
    });

    /*�곸뒪 2 �뺤꽦��*/

    gnb_link_depth02.each(function() {
      var this_href = $(this).attr('href');
      var href = this_href.split('/')[this_href.split('/').length - 1].split('.')[0].split('-')[0].slice(0, -3);

      console.log("�먮쾲吏� " + href);
      if (href == src02) {

        $(this).addClass('on');

      } else {
        $(this).removeClass('on')
      }

    });
    gnb_link_depth02_sub.each(function() {
      var this_href = $(this).attr('href');
      var href = this_href.split('/')[this_href.split('/').length - 1].split('.')[0].split('-')[0].slice(0, -3);

      console.log("�먮쾲吏� " + href);
      if (href == src02) {

        $(this).addClass('on');

      } else {
        $(this).removeClass('on')
      }

    });

  },
  navAction2: function() {
    var gnb_link = $('.gnb_wrap .depth01').children('a');
    var all_a = $('.gnb_wrap .gnb-box .all-link');
    var depth_02 = $('.gnb_wrap .depth01 .depth02');
    var gnb_wrap = $('.gnb_wrap');

    var nav_bg = $('.nav_bg_pc');
    var nav_line = $('.nav_line');

    gnb_link.on('mouseover focus', onOn);
    // depth_02_a.on('mouseover focus',onOn2);

    $(gnb_wrap).on('mouseleave', function() {

      $(depth_02).stop().slideUp(100);
    });

    function onOn() {
      var next = $(this).next();

      $(depth_02).stop().slideUp(100);
      $(next).stop().slideDown(100);
    }

  }
};

//  mobile smNav
//�꾩퐫�붿뼵

var navMobile = {
  init: function() {
    this.moAction();
  },
  moAction: function() {
    var depth_1 = $('.gnb_mobile .depth01');
    var depth_2 = $('.gnb_mobile .depth02');
    var depth_3 = $('.gnb_mobile .depth03');
    var depth_1_down = $('.gnb_mobile .depth01_down');
    var depth_2_down = $('.gnb_mobile .depth02_down');
    var nav_close = $('.nav_close');
    var nav_bg = $('.nav_bg');

    $(depth_2).hide();
    $(depth_3).hide();
    $(nav_bg).hide();

    $(depth_1).each(function() {

      if ($(this).children("div").length > 0) {

        $(this).children('a').click(function() {

          if ($(this).next('div').css('display') === 'none') {
            $(depth_1).children('a').removeClass('selected1');
            $(this).addClass('selected1');
            $(depth_2).slideUp(300);
            $(this).next().stop().slideDown(300);
          } else {
            $(this).next('div').slideUp(200);
            $(depth_1).children('a').removeClass('selected1');
          }

          return false;

        });

      } else {

        $(this).find('a').addClass('no');

      }
    });

    $('.gnb_mobile .lang_list').slideUp(100);

    // 硫붾돱

    $('.nav_btn').on('click', function() {

      if ($('.gnb_mobile').hasClass('on') === false) {
        $('.gnb_mobile').addClass('on');

        $(nav_bg).fadeIn(300);

        $(this).addClass('on');

      } else {

        $(this).removeClass('on');

        $('.gnb_mobile').removeClass('on');
        $(nav_bg).fadeOut(100);
        $(depth_2).hide();
        $(depth_3).hide();
        $(depth_1).children('a').removeClass('selected1');
        $(depth_2_down).children('a').removeClass('selected2');
      }

    });

    $('.nav_btn_off').on('click', function() {

      $('.gnb_mobile').removeClass('on');
      $(nav_bg).fadeOut(100);
      $(depth_2).hide();
      $(depth_3).hide();
      $(depth_1).children('a').removeClass('selected1');
      $(depth_2_down).children('a').removeClass('selected2');

      $('.gnb_mobile .lang_list').slideUp(100);

    });

  }
};

var conShow = {
  init: function() {
    this.click01(); //�ъ씠�몃㏊


  },
  click01: function() {

    var btn = $('.btn_sitemap');
    var con = $('#sitemap');

    $(btn).click(function() {

      $(con).fadeToggle();

    })

  }

};

/**
 * qna
 * �꾩퐫�붿뼵
 */
var qnaFun = {
  init: function() {
    this.q();
    this.s();
    this.t();
  },
  q: function() {
    var qna = $('.qna'),
        header = qna.find('.qna-header'),
        header_a = qna.find('.qna-header a'),
        body = qna.find('.qna-body'),
        faq_chk = '';

    body.hide();

    header.on('click', function(event) {
      event.preventDefault();
      header.removeClass('select');
      header_a.removeClass('select'); //�ㅻⅨ履� �붿궡�� �놁븷湲�
      body.slideUp(200);

      if (faq_chk != $(this).text()) {
        faq_chk = $(this).text();
        $(this).addClass('select');
        $(this).children('a').addClass('select'); //�ㅻⅨ履� �붿궡�� �앷린湲�
        $(this).next('.qna-body').slideDown(200);
      } else {
        faq_chk = '';
      }

    });
  },
  s: function() {
    var seach = $('.search_ul').find('.search_li'),
        header = seach.find('.search_header'),
        header_a = seach.find('.search_header .txt_chk'),
        body = seach.find('.search_body'),
        body_a = seach.find('.search_body .close_btn'),
        search_chk = '';

    body.hide();

    header_a.on('click', function(event) {
      event.preventDefault();
      header_a.removeClass('on');
      // body.slideUp(300);
      body.not($(this).parent().parent().next('.search_body')).slideUp(300);
      // $(this).parent().parent().next('.search_body').slideDown(300);
      $(this).parent().parent().next('.search_body').slideToggle(300);
      $(this).addClass('on');
    });

    body_a.on('click', function(event) {
      header_a.removeClass('on');
      event.preventDefault();
      body.slideUp(300);
    });
  },

  t: function() {
    var table = $('.table_wrap'),
        t_head = table.find('.t_head'),
        t_head_a = table.find('.sear_btn'),
        t_body = table.find('.detail'),
        btn_01 = table.find('.btn_01'),
        btn_02 = table.find('.btn_02'),
        table_chk = '';

    t_body.hide();

    /*btn_01.on('click', function(event) {
      event.preventDefault();
      btn_01.ToggleClass('minus_01');
      t_body.slideToggle(300);
    });*/
  }
};

$('.btn_01').click(function() {
  $(".detail_1").slideToggle(200);
  $('.btn_01').toggleClass('minus_01');
  $('.sear_01').toggleClass('open');
});

$('.btn_02').click(function() {
  $(".detail_2").slideToggle(200);
  $('.btn_02').toggleClass('minus_02');
  $('.sear_02').toggleClass('open');
});

$('.m_btn_01').click(function() {
  $(".detail_1").slideToggle();
  $('.sear_01').toggleClass('open');
  $(this).toggleClass('open');
});

$('.m_btn_02').click(function() {
  $(".detail_2").slideToggle();
  $('.sear_02').toggleClass('open');
  $(this).toggleClass('open');
});



/*�щ씪�대뜑*/

var slick = {
  init: function() {
    this.slick_01(); //硫붿씤 �댁뒪
    this.slick_02(); //硫붿씤
    this.slick_03(); //�쒗뭹 �곸꽭
    this.slick_04(); //硫붿씤
    this.slick_05(); //硫붿씤
  },
  slick_01: function() {
    /*
        $('.big_vertical_slick').slick({
          slidesToShow: 1,
          slidesToScroll: 1,
          arrows: false,
          // fade: true,
          asNavFor: '.vertical_slick',
              focusOnSelect:true,
          autoplay: true,
              inifinite:true,
        });
        $('.vertical_slick').slick({

              inifinite:true,
          slidesToShow: 4,
          arrows: false,
          slidesToScroll: 1,
          vertical: true,
          //autoplay: false,
          asNavFor: '.big_vertical_slick',
          dots: true,
          //centerMode: false,
          focusOnSelect: true,
          responsive: [

          {
            breakpoint: 1024,
            settings: {
              slidesToShow: 2,
              slidesToScroll: 1,
              vertical: false,
            }
          },
          {
            breakpoint: 500,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1,
              vertical: false,
            }
          }
          ]

        });
        $('.tab_menu_wrap .tab_menu_list a').click(function(){
          $('.big_vertical_slick').slick('setPosition');
          $('.vertical_slick').slick('setPosition');
          $('.main_tabbox_wrap').find('.wow').css({'visibility': 'visible', 'animation-delay': '0s', 'animation-name': 'fadeInUp'});
          $('.main_tabbox_wrap').find('.wow').addClass('animated');
           $('.big_vertical_slick').slick('slickGoTo', 0);
           $('.vertical_slick').slick('slickGoTo', 0);
           console.log('click')
        });
    */

    $('#big_vertical_slick_1').slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      arrows: false,
      asNavFor: '#vertical_slick_1',
      focusOnSelect:true,
      autoplay: true,
      inifinite:true,
      adaptiveHeight:true,
    });
    $('#vertical_slick_1').slick({
      inifinite:true,
      slidesToShow: 4,
      arrows: false,
      slidesToScroll: 1,
      vertical: true,
      asNavFor: '#big_vertical_slick_1',
      dots: true,
      focusOnSelect: true,adaptiveHeight:true,
      responsive: [{
        breakpoint: 1024,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
          vertical: false,
        }
      },{
        breakpoint: 500,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          vertical: false,
        }
      }]
    });$('#big_vertical_slick_2').slick({
      slidesToShow: 1,
      slidesToScroll: 1,
      arrows: false,
      asNavFor: '#vertical_slick_2',
      focusOnSelect:true,
      autoplay: true,
      inifinite:true,adaptiveHeight:true,
    });
    $('#vertical_slick_2').slick({
      inifinite:true,
      slidesToShow: 4,
      arrows: false,
      slidesToScroll: 1,
      vertical: true,
      asNavFor: '#big_vertical_slick_2',
      dots: true,adaptiveHeight:true,
      focusOnSelect: true,
      responsive: [{
        breakpoint: 1024,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
          vertical: false,
        }
      },{
        breakpoint: 500,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
          vertical: false,
        }
      }]
    });

    $('.tab_menu_wrap .tab_menu_list a').click(function(){
      $('#big_vertical_slick_1').slick('setPosition');
      $('#vertical_slick_1').slick('setPosition');
      $('#big_vertical_slick_1').slick('slickGoTo', 0);
      $('#vertical_slick_1').slick('slickGoTo', 0);
      $('#big_vertical_slick_2').slick('setPosition');
      $('#vertical_slick_2').slick('setPosition');
      $('#big_vertical_slick_2').slick('slickGoTo', 0);
      $('#vertical_slick_2').slick('slickGoTo', 0);

      $('.main_tabbox_wrap').find('.wow').css({'visibility': 'visible', 'animation-delay': '0s', 'animation-name': 'fadeInUp'});
      $('.main_tabbox_wrap').find('.wow').addClass('animated');
    });

  },
  slick_02: function() {

    $('#main_slider').slick({
      autoplay: true,
      autoplaySpeed: 6000,
      dots: true,
      fade: true,
      arrows: false,
      speed: 800
    });


  },
  slick_03: function() {

    $('.view_slider').slick({
      autoplay: true,
      autoplaySpeed: 5000,
      dots: true,
      // fade: true,
      arrows: false,
      speed: 800,
      slidesToShow: 4,
      slidesToScroll: 1,
      responsive: [{
        breakpoint: 1024,
        settings: {
          // slidesPerRow: 3,
          slidesToScroll: 1,
          slidesToShow: 3,
          dots: true,
          arrows: false,
        }
      },
        {
          breakpoint: 768,
          settings: {
            centerMode: true,
            centerPadding: '60px',
            // slidesPerRow: 3,
            slidesToScroll: 1,
            slidesToShow: 1,
            dots: true,
            arrows: false,
          }
        }
      ]

    });
    $('.live_inquiry_slick ul').slick({
      slidesToShow:5,
      slidesToScroll:1,
      vertical:true,
      autoplay:true,
      arrows:false,
    })

  },
  slick_04: function() {

    $('.logo_slick').slick({
      autoplay: true,
      autoplaySpeed: 5000,
      dots: false,
      // fade: true,
      arrows: true,
      prevArrow : '<div class="slick-prev"></div>',
      nextArrow : '<div class="slick-next"></div>',
      speed: 800,
      slidesToShow: 6,

      slidesToScroll: 1,
      responsive: [{
        breakpoint: 1250,
        settings: {
          // slidesPerRow: 3,
          slidesToScroll: 1,
          slidesToShow: 3,
          arrows: true,
        }
      }
      ]

    });

  },

  slick_05: function() {

    $('.com_logo_slick').slick({
      autoplay: true,
      autoplaySpeed: 3000,
      dots: false,
      // fade: true,
      arrows: true,
      speed: 1000,
      slidesToShow: 1,
      slidesToScroll: 1

    });
  }

};

$('.type_c_p').click(function(){
  $(".li_over").slideToggle();
  $('.p_m_01').toggleClass('on');
});

var Tab1 = {
  init: function() {
    this.tab01();
    // this.tab02();
  },
  tab01: function() {
    var tabBtn = $('.tab_menu_wrap .tab_menu_list li > a');
    var tab1st = $('.tab_menu_wrap .tab_menu_list li').eq(0).find('a');
    var conAll = $('.main_board .tab_wrap');
    var con1st = $('.main_board .tab_wrap').eq(0);
    $(tab1st).addClass('on');
    $(conAll).hide();
    $(con1st).show();
    $(tabBtn).click(function() {

      $(conAll).hide();
      tabHref = $(this).attr('href');
      $(tabHref).show();
      $(tabBtn).removeClass('on');
      $(this).addClass('on');
      return false;
    });
  }
};



var menuTab = {
  init: function() {
    this.type01(); //���꿣 湲곕낯�� -> 紐⑤컮�� �쒕∼�ㅼ슫
  },

  type01: function() {
    var btn = $('.sub_menu_type_c .btn_sub_menu');
    var des = $('.sub_menu_type_c .updown_list .des_con');
    var btn_list = $('.sub_menu_type_c .updown_list .des_con a');
    $('.sub_menu_type_c .updown_list > li').each(function() {
      var onLinkText = $(this).find('.on').text(); //�꾩옱 �꾩튂  �띿뒪��
      console.log('留곹겕 �대쫫 ', onLinkText);
      $(this).find('.btn_sub_menu').text(onLinkText);
      $(this).find('.btn_sub_menu').click(function() {
        if ($(this).hasClass('on') == true) {
          $(this).removeClass('on');
          $(this).next().stop().slideUp();
        } else {
          $(des).stop().slideUp();
          $(btn).removeClass('on');
          $(this).next().stop().slideDown();
          $(this).addClass('on');
        }
        return false;
      });
      $(this).find('.des_con a').click(function() {
        $(this).find('.des_con a').removeClass('on');
        var onLinkTextThis = $(this).text();
        $(this).addClass('on');
        $(this).parent().parent().parent().prev().text(onLinkTextThis);
        $(this).parent().parent().parent().slideUp();
        $(btn).removeClass('on');
      });
    })
  }
}

$(".sear_img_01 span").click(function() {
  $(this).addClass('on');
});

$(".check_sty .sub_info1").click(function() {
  $(".check_sty .item").css({
    "position" : "absolute",
    "top" : "0",
    "left" : "0"
  })
});


var showCon = {
  init: function() {
    this.show02();
  },
  show02: function() {

    $(".sitemap_btn").click(function() {
      $(".sitemap-menu").stop().slideToggle();
      /*$(".sitemap-menu").toggleClass('on');*/

    });
  }
};

/*
popup plugins
 */
(function(){
  'use strict';
  $('.popup_link').magnificPopup({
    type: 'ajax',
    overflowY: 'scroll',
    callbacks: {
      // beforeOpen: function() {
      // $.fn.fullpage.setAllowScrolling(false);
      // },
      // beforeClose: function() {
      // $.fn.fullpage.setAllowScrolling(true);
      // }
    }
  });
})();


//蹂��� 遺덈윭�ㅺ린
$(document).ready(function() {
  navFun.init(); // pc nav
  navMobile.init(); //m nav
  conShow.init(); //click
  qnaFun.init(); //qna
  showCon.init(); //硫붾돱
  menuTab.init(); //硫붾돱
  Tab1.init(); //硫붿씤 ��
  slick.init(); //slider

  $(window).resize(function() {
  });

  /* �뚯씪泥⑤� */
  function file_upload() {
    var tmp = $(this).val();
    $(this).siblings('p').text(tmp);
  };
  $('.file_box > input').change(file_upload);

  /*new WOW().init({
    boxClass: 'wow', // default
    animateClass: 'animated', // default
    offset: 150,
    mobile: true, // default
    live: true // default
  });*/

  $(document).ready(function(){
    wow.init();
    wowrap.init();
  })




  var wow = new WOW({
    boxClass:     'wow',      // animated element css class (default is wow)
    animateClass: 'animated', // animation css class (default is animated)
    offset:       50,          // distance to the element when triggering the animation (default is 0)
    mobile:       true,       // trigger animations on mobile devices (default is true)
    live:         true,       // act on asynchronously loaded content (default is true)
    callback:     function(box) {
      // the callback is fired every time an animation is started
      // the argument that is passed in is the DOM node being animated
    },
    scrollContainer: null // optional scroll container selector, otherwise use window
  });

  var wowrap = $('.wowrap');
  $(wowrap).each(function() {
    $(this).find('.wow').each(function(index){
      var eq = (index)/6+"s"; //2.5s    �곕떽
      $(this).attr('data-wow-delay',eq);
    });
    $(this).find('.animated').each(function(index){
      var eq = (index)*250;
      $(this).attr('data-id','delay-'+eq);
    });
  });

  /* --------------------------------------------------------------------- */

  /*理쒖긽�쇰줈媛�湲�*/
  $("#top_btn").hide();

  // fade in .section_minibasket
  $(function() {
    $(window).scroll(function() {
      if ($(this).scrollTop() > 100) {
        $('#top_btn').fadeIn();

      } else {
        $('#top_btn').fadeOut();
      }

    });

    // scroll body to 0px on click
    $('#top_btn a').click(function() {
      $('body,html').animate({
        scrollTop: 0
      }, 800);
      return false;
    });

  });


  $(function() {
    var offset = $("#side_quick").offset().top;
    var topPadding = 400;
    $(window).scroll(function() {
      if ($(window).scrollTop() > offset) {

        $('#side_quick').stop().animate({

          "top": $(window).scrollTop() - offset + topPadding
        },500);


      } else {


        $('#side_quick').stop().animate({
          "top": 500
        },500);
      };
    });
  });

  /*�ㅽ겕濡� 怨좎젙*/

  $(function() {
    $(window).scroll(function() {
      if ($(this).scrollTop() > 100) {
        $('#header').addClass('on');
      } else {
        $('#header').removeClass('on');
      }
    });
  });

  /*硫붿씤�앹뾽*/

  function startPoP(){


    var winW = $(window).width();

    if (winW > 1024) {

      $(".start_pop").draggable({
        containment:"body",
        handle: ".modal-header"
      });


    }

  }startPoP();
  $(window).resize(function() {
    startPoP();
  })


});
