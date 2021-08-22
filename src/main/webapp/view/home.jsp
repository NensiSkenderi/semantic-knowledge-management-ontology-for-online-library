<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <html lang="en">

    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, , initial-scale=1.0">
        <meta name="description" content="Alb Library">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/nensinensi/css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

        <link href="http://kodeforest.net/html/books/library/css/owl.carousel.css" rel="stylesheet" type="text/css">
        <link href="http://kodeforest.net/html/books/library/css/jquery.bxslider.css" rel="stylesheet" type="text/css">
        <link href="http://kodeforest.net/html/books/library/css/bootstrap-slider.css" rel="stylesheet" type="text/css">
        <link href="http://kodeforest.net/html/books/library/style.css" rel="stylesheet" type="text/css">
        
        <style>
            .kode-banner {
                float: left;
                width: 100%;
                position: relative;
            }
            
            .kode-banner:before {}
            
            .kode-banner .bx-wrapper ul li:before {
                content: "";
                position: absolute;
                left: 0px;
                top: 0px;
                background-color: rgba(0, 0, 0, 0.5);
                height: 100%;
                width: 100%;
                z-index: 100;
            }
            
            .kode-banner .bx-pager {
                display: none;
            }
            
            .kode-banner .bx-wrapper .bx-controls-direction a {
                height: 60px;
                width: 30px;
                margin-top: -30px;
            }
            
            .kode-banner .bx-wrapper .bx-controls-direction a:before {
                content: "\f104";
                font-family: FontAwesome;
                font-size: 80px;
                color: #fff;
                position: absolute;
                left: 0px;
                top: 0px;
                width: 100%;
                text-align: center;
                line-height: 60px;
            }
            
            .kode-banner .bx-wrapper .bx-controls-direction a.bx-next:before {
                content: "\f105";
            }
            
            .kode-banner .kode-caption {
                position: absolute;
                left: 0px;
                width: 100%;
                top: 40%;
                text-align: center;
                z-index: 200;
            }
            
            .kode-banner .kode-caption h2 {
                font-size: 90px;
                text-transform: uppercase;
                color: #fff;
            }
            
            .kode-banner .kode-caption h5 {
                font-size: 30px;
                color: #fff;
                text-transform: uppercase;
                padding: 0px 15px;
                position: relative;
                display: inline-block;
            }
            
            .kode-banner .kode-caption h5:before,
            .kode-banner .kode-caption h5:after {
                content: "";
                height: 5px;
                border-top: solid 1px #fff;
                border-bottom: solid 1px #fff;
                width: 100px;
                left: 100%;
                top: 17px;
                position: absolute;
            }
            
            .kode-banner .kode-caption h5:after {
                left: auto;
                right: 100%;
            }
            
            .kode-banner .kode-caption p {
                color: #fff;
            }
            
            .kode-banner .input-container {
                display: inline-block;
                position: relative;
                float: none;
                width: auto;
                margin: 20px 0px 0px 0px;
            }
            
            .kode-banner .input-container input[type="text"] {
                background-color: rgba(0, 0, 0, 0.6);
                height: 50px;
                border-radius: 30px;
                width: 580px;
            }
            
            .add-to-cart:hover {
    color: #000;
    background-color: #fff;
}
           
           .add-to-cart {
    display: inline-block;
    font-size: 14px;
    background: transparent;
    color: white;
    text-transform: uppercase;
    font-weight: bold;
    padding: 10px 20px;
    border: solid 2px #fff;
    text-decoration: none;
    line-height: normal;
}
        
        
            
            .kode-banner .input-container button {
                position: absolute;
                top: 0px;
                right: 0px;
                background-color: #333;
                border-radius: 0px 30px 30px 0px;
                height: 100%;
                color: #fff;
                font-size: 18px;
                text-align: center;
                padding: 10px 20px;
            }
            
            .kode-banner .input-container button:hover {
                background-color: #fff;
            }
            
            .kode-banner .input-container button:hover i {
                color: #000;
            }
            
            .kode-banner .input-container button i {
                color: #fff;
                float: none;
                position: static;
                margin: 0px;
                font-size: 18px;
            }
            
            .input-container button:hover {
                color: #333;
            }
            
           
            .section-content {
                float: left;
                width: 100%;
                text-align: center;
                margin-bottom: 30px;
                padding: 0px 100px;
            }
            
            .section-content h2 {
                font-size: 30px;
                text-transform: uppercase;
                position: relative;
                padding-bottom: 24px;
                margin-bottom: 21px;
                line-height: normal;
                margin-top: -8px;
            }
            
            .section-content.white h2 {
                color: #fff;
            }
            
            .section-content.white h2:before {
                border-color: #fff;
            }
            
            .section-content h2:before {
                content: "";
                width: 30px;
                height: 5px;
                border-top: solid 1px;
                border-bottom: solid 1px;
                position: absolute;
                ;
                left: 0px;
                right: 0px;
                margin: auto;
                bottom: 0px;
            }
            
            .section-content p {
                margin-bottom: 0px;
            }
            
            .author_name {
                position: absolute;
                left: 66px;
                top: 50%;
                height: 50px;
                width: 73.5%;
                overflow: hidden;
                z-index: 1;
                font-size: 24px;
                color: white;
                background: rgba(0, 0, 0, 0.7);
                padding-top: 10px;
            }
            
            .newsletter .form-group {
                float: left;
                margin-bottom: 0;
                position: relative;
                width: 100%;
            }
            
            .newsletter .form-group input[type='email'] {
                border: 0;
                -webkit-border-radius: 0;
                -moz-border-radius: 0;
                border-radius: 0;
                height: 54px;
                padding: 0 150px 0 20px;
                color: #707070;
                outline: none;
            }
            
            .newsletter {
                background-color: #d4d6d8;
            }
            
            section.section-padding {
                padding: 92.5px 0 100px;
            }
            
            .newsletter .form-group input[type='submit'] {
                font-size: 12px;
                height: 34px;
                position: absolute;
                right: 10px;
                top: 10px;
                width: 120px;
                background-color: #ff7236;
                color: #fff;
            }
            
            .news-events .center-content {
                display: block;
                float: none;
            }
            
            .center-content {
                text-align: center;
                width: 100%;
            }
            
            .news-events.banner {
                background-attachment: fixed;
                background-image: url('http://libraria.demo.presstigers.com/images/news-event/home-v1-news-event-banner.jpg');
                background-position: center center;
                background-repeat: no-repeat;
                background-size: cover;
                min-height: 1002px;
            }
            
            @media (max-width: 1024px) {
                .news-events.banner {
                    background-attachment: scroll;
                }
            }
            
            .news-events.banner h2 {
                color: #fff;
            }
            
            .news-events.banner .lead {
                color: #bebebe;
            }
            
            .news-events .center-content {
                display: block;
                float: none;
            }
            
            @media (max-width: 767px) {
                .news-events .center-content {
                    width: 70%;
                    margin: 0 auto;
                }
            }
            
            @media (max-width: 767px) {
                .news-events .center-content .lead {
                    margin-bottom: 35px;
                }
            }
            
            .news-events .news-events-list {
                display: block;
                height: 692px;
                position: relative;
                width: 100%;
            }
            
            @media (max-width: 991px) {
                .news-events .news-events-list {
                    height: auto;
                }
            }
            
            .news-events .news-events-list .single-news-event {
                height: 346px;
                position: absolute;
                width: 570px;
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event {
                    height: 328px;
                    width: 540px;
                }
            }
            
            @media (max-width: 1024px) {
                .news-events .news-events-list .single-news-event {
                    cursor: pointer;
                }
            }
            
            @media (max-width: 991px) {
                .news-events .news-events-list .single-news-event {
                    clear: both;
                    height: 437px;
                    position: relative;
                    width: 100%;
                }
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event {
                    height: auto;
                    width: 70%;
                    margin: 0 auto 30px;
                }
            }
            
            @media (max-width: 480px) {
                .news-events .news-events-list .single-news-event {
                    width: 100%;
                }
            }
            
            .news-events .news-events-list .single-news-event figure {
                float: left;
                width: 50%;
            }
            
            .news-events .news-events-list .single-news-event figure img {
                width: 100%;
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event figure {
                    width: 100%;
                }
            }
            
            .news-events .news-events-list .single-news-event .content-block {
                background-color: #f4f4f4;
                float: left;
                height: 346px;
                position: relative;
                -moz-transition: all 0.3s ease-in-out;
                -ms-transition: all 0.3s ease-in-out;
                -o-transition: all 0.3s ease-in-out;
                transition: all 0.3s ease-in-out;
                -webkit-transition: all 0.3s ease-in-out;
                width: 50%;
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event .content-block {
                    height: 328px;
                }
            }
            
            @media (min-width: 768px) and (max-width: 991px) {
                .news-events .news-events-list .single-news-event .content-block {
                    height: 100%;
                }
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event .content-block {
                    height: auto;
                    width: 100%;
                }
            }
            
            .news-events .news-events-list .single-news-event .content-block::before {
                content: '';
                position: absolute;
                -moz-transition: all 0.3s ease-in-out;
                -ms-transition: all 0.3s ease-in-out;
                -o-transition: all 0.3s ease-in-out;
                transition: all 0.3s ease-in-out;
                -webkit-transition: all 0.3s ease-in-out;
            }
            
            .news-events .news-events-list .single-news-event .content-block .content_meta_category {
                color: #f26d35;
                font-size: 14px;
                font-weight: bold;
                margin-bottom: 10px;
                text-transform: uppercase;
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event .content-block .content_meta_category {
                    position: relative;
                }
            }
            
            .news-events .news-events-list .single-news-event .content-block .content_meta_category a {
                color: #ff7236;
            }
            
            .news-events .news-events-list .single-news-event .content-block .content_meta_category .arrow-right {
                border-bottom: 7px solid rgba(0, 0, 0, 0);
                border-left: 7px solid #ff7236;
                border-top: 7px solid rgba(0, 0, 0, 0);
                height: 0;
                left: 0;
                position: absolute;
                top: 2px;
                width: 0;
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event .content-block .content_meta_category .arrow-right {
                    left: -20px;
                    top: 2px;
                }
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info {
                color: #2f2f2f;
                left: 0;
                padding: 0 20px;
                position: absolute;
                right: 0;
                top: 50%;
                -webkit-transform: translateY(-50%);
                -moz-transform: translateY(-50%);
                -o-transform: translateY(-50%);
                -ms-transform: translateY(-50%);
                transform: translateY(-50%);
                -moz-transition: all 0.3s ease-in-out;
                -ms-transition: all 0.3s ease-in-out;
                -o-transition: all 0.3s ease-in-out;
                transition: all 0.3s ease-in-out;
                -webkit-transition: all 0.3s ease-in-out;
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event .content-block .member-info {
                    padding: 27px 20px 30px;
                    position: initial;
                    top: auto;
                    -webkit-transform: translateY(0);
                    -moz-transform: translateY(0);
                    -o-transform: translateY(0);
                    -ms-transform: translateY(0);
                    transform: translateY(0);
                }
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info h3 {
                color: #282828;
                font-size: 16px;
                margin-bottom: 7px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info h3 a {
                color: #282828;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info h3 a:hover {
                color: #ff7236;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info p {
                line-height: 2.15;
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event .content-block .member-info p {
                    line-height: 1.8;
                    margin-bottom: 15px;
                }
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul {
                list-style: none;
                margin: 0;
                padding: 0;
                margin-bottom: 12px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul li {
                color: #6b6b6b;
                display: inline-block;
                font-size: 12px;
                margin: 0 1px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul li a {
                color: #6b6b6b;
                display: inline-block;
                padding: 2px 0 3px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul li a i {
                margin-right: 3px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul li a:hover {
                color: #ff7236;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul li:after {
                display: inline-block;
                content: "|";
                margin: 0 10px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info ul li:last-child:after {
                content: "";
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info .btn-primary {
                background-color: #fff;
                color: #282828;
                font-size: 12px;
                padding: 9px 26px;
            }
            
            .news-events .news-events-list .single-news-event .content-block .member-info .btn-primary:hover {
                background-color: #ff7236;
                color: #fff;
            }
            
            .news-events .news-events-list .single-news-event:first-child {
                height: 692px;
                left: 0;
                top: 0;
                width: 600px;
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event:first-child {
                    height: auto;
                    width: 400px;
                }
            }
            
            @media (max-width: 991px) {
                .news-events .news-events-list .single-news-event:first-child {
                    height: 414px;
                    width: 100%;
                }
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event:first-child {
                    height: auto;
                    width: 70%;
                }
            }
            
            @media (max-width: 480px) {
                .news-events .news-events-list .single-news-event:first-child {
                    width: 100%;
                }
            }
            
            .news-events .news-events-list .single-news-event:first-child figure {
                width: 100%;
            }
            
            @media (min-width: 768px) and (max-width: 991px) {
                .news-events .news-events-list .single-news-event:first-child figure {
                    width: 100%;
                }
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event:first-child figure img {
                    height: 240px;
                }
            }
            
            .news-events .news-events-list .single-news-event:first-child .content-block {
                width: 100%;
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event:first-child .content-block {
                    height: 416px;
                }
            }
            
            .news-events .news-events-list .single-news-event:first-child .content-block .member-info h3 {
                font-size: 20px;
            }
            
            .news-events .news-events-list .single-news-event:first-child .content-block .member-info p {
                font-size: 16px;
            }
            
            .news-events .news-events-list .single-news-event:first-child .content-block::before {
                border-bottom: 17px solid #f4f4f4;
                border-left: 17px solid transparent;
                border-right: 17px solid transparent;
                left: 50%;
                margin-left: -17px;
                top: -17px;
            }
            
            .news-events .news-events-list .single-news-event:nth-child(2) {
                right: 0;
                top: 0;
            }
            
            .news-events .news-events-list .single-news-event:nth-child(2) figure {
                float: right;
            }
            
            .news-events .news-events-list .single-news-event:nth-child(2) .content-block::before {
                border-bottom: 17px solid transparent;
                border-left: 17px solid #f4f4f4;
                border-top: 17px solid transparent;
                margin-top: -17px;
                right: -17px;
                top: 50%;
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event:nth-child(2) .content-block::before {
                    border-bottom: 17px solid #f4f4f4;
                    border-left: 17px solid transparent;
                    border-right: 17px solid transparent;
                    border-top: 0;
                    left: 50%;
                    margin-top: 0;
                    margin-left: -17px;
                    right: auto;
                    top: -17px;
                }
            }
            
            .news-events .news-events-list .single-news-event:nth-child(3) {
                bottom: 0;
                right: 0;
            }
            
            @media (min-width: 992px) and (max-width: 1199px) {
                .news-events .news-events-list .single-news-event:nth-child(3) {
                    bottom: 36px;
                }
            }
            
            .news-events .news-events-list .single-news-event:nth-child(3) .content-block::before {
                border-bottom: 17px solid transparent;
                border-right: 17px solid #f4f4f4;
                border-top: 17px solid transparent;
                left: -17px;
                margin-top: -17px;
                top: 50%;
            }
            
            @media (max-width: 767px) {
                .news-events .news-events-list .single-news-event:nth-child(3) .content-block::before {
                    border-bottom: 17px solid #f4f4f4;
                    border-left: 17px solid transparent;
                    border-right: 17px solid transparent;
                    border-top: 0;
                    left: 50%;
                    margin-top: 0;
                    margin-left: -17px;
                    top: -17px;
                }
            }
            /** RESET AND LAYOUT
===================================*/
            
            .bx-wrapper {
                position: relative;
                float: left;
                width: 100%;
                padding: 0;
                *zoom: 1;
            }
            
            .bx-wrapper img {
                max-width: 100%;
                display: block;
                width: 100%;
            }
            
            .kode-caption:hover {
            	background: #7ed321;
            }	
            /** THEME
===================================*/
            
            .bx-wrapper .bx-viewport {
                float: left;
                width: 100%;
                /*fix other elements on the page moving (on Chrome)*/
                -webkit-transform: translatez(0);
                -moz-transform: translatez(0);
                -ms-transform: translatez(0);
                -o-transform: translatez(0);
                transform: translatez(0);
            }
            
            .bx-wrapper .bx-pager,
            .bx-wrapper .bx-controls-auto {}
            /* LOADER */
            
            .bx-wrapper .bx-loading {
                min-height: 50px;
                background: url(images/bx_loader.gif) center center no-repeat #fff;
                height: 100%;
                width: 100%;
                position: absolute;
                top: 0;
                left: 0;
                z-index: 2000;
            }
            /* PAGER */
            
            .bx-wrapper .bx-pager {
                text-align: center;
                font-size: .85em;
                font-family: Arial;
                font-weight: bold;
                color: #666;
            }
            
            .bx-wrapper .bx-pager .bx-pager-item,
            .bx-wrapper .bx-controls-auto .bx-controls-auto-item {
                display: inline-block;
                *zoom: 1;
                *display: inline;
            }
            
            .bx-wrapper .bx-pager.bx-default-pager a {
                background: #b3b3b3;
                text-indent: -9999px;
                display: block;
                width: 16px;
                height: 16px;
                margin: 5px 5px;
                outline: 0;
                border-radius: 30px;
            }
            
            .bx-wrapper .bx-pager.bx-default-pager a:hover,
            .bx-wrapper .bx-pager.bx-default-pager a.active {}
            /* DIRECTION CONTROLS (NEXT / PREV) */
            
            .bx-wrapper .bx-prev {
                left: 10px;
            }
            
            .bx-wrapper .bx-next {
                right: 10px;
            }
            
            .bx-wrapper .bx-prev:hover {
                background-position: 0 0;
            }
            
            .bx-wrapper .bx-next:hover {
                background-position: -43px 0;
            }
            
            .bx-wrapper .bx-controls-direction a {
                position: absolute;
                top: 50%;
                margin-top: -16px;
                outline: 0;
                width: 32px;
                height: 32px;
                z-index: 9999;
            }
            
            .bx-wrapper .bx-controls-direction a.disabled {
                display: none;
            }
            /* AUTO CONTROLS (START / STOP) */
            
            .bx-wrapper .bx-controls-auto {
                text-align: center;
            }
            
            .bx-wrapper .bx-controls-auto .bx-start {
                display: block;
                text-indent: -9999px;
                width: 10px;
                height: 11px;
                outline: 0;
                background: url(../images/controls.png) -86px -11px no-repeat;
                margin: 0 3px;
            }
            
            .bx-wrapper .bx-controls-auto .bx-start:hover,
            .bx-wrapper .bx-controls-auto .bx-start.active {
                background-position: -86px 0;
            }
            
            .bx-wrapper .bx-controls-auto .bx-stop {
                display: block;
                text-indent: -9999px;
                width: 9px;
                height: 11px;
                outline: 0;
                background: url(../images/controls.png) -86px -44px no-repeat;
                margin: 0 3px;
            }
            
            .bx-wrapper .bx-controls-auto .bx-stop:hover,
            .bx-wrapper .bx-controls-auto .bx-stop.active {
                background-position: -86px -33px;
            }
            /* PAGER WITH AUTO-CONTROLS HYBRID LAYOUT */
            
            .bx-wrapper .bx-controls.bx-has-controls-auto.bx-has-pager .bx-pager {
                text-align: left;
                width: 80%;
            }
            
            .bx-wrapper .bx-controls.bx-has-controls-auto.bx-has-pager .bx-controls-auto {
                right: 0;
                width: 35px;
            }
            /* IMAGE CAPTIONS */
            
            .bx-wrapper .bx-caption {
                position: absolute;
                bottom: 0;
                left: 0;
                background: #666\9;
                background: rgba(80, 80, 80, 0.75);
                width: 100%;
            }
            
            .bx-wrapper .bx-caption span {
                color: #fff;
                font-family: Arial;
                display: block;
                font-size: .85em;
                padding: 10px;
            }
            
            ul.bxslider {
                margin: 0px;
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <div class="kode-banner">
            <div class="bx-wrapper" style="max-width: 100%;">
                <div class="bx-viewport" style="width: 100%; overflow: hidden; position: relative; height: 663px;">
                    <ul class="bxslider" style="width: 515%; position: relative; transition-duration: 0.5s; transform: translate3d(-3078px, 0px, 0px);">
                        <li style="float: left; list-style: none; position: relative; width: 1519px;" class="bx-clone">
                            <img src="/nensinensi/img/banner1.png" alt="">
                            <div class="kode-caption-2">
                                <h5>Are you searching a book...?</h5>
                                <h2>Biggest Library in Albania</h2>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium dolor emque laudantium, totam rem aperiam.ipsam voluptatem.</p>
                                <div class="caption-btns">
                                    <a href="#">See More</a>
                                    <a href="#">Buy Now</a>
                                </div>
                            </div>
                        </li>

                        <li style="float: left; list-style: none; position: relative; width: 1519px;">
                            <img src="/nensinensi/img/banner3.png" alt="">
                            <div class="kode-caption-2">
                                <h5>Are you searching a book...?</h5>
                                <h2>Biggest Library in Albania</h2>
                                <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium dolor emque laudantium, totam rem aperiam.ipsam voluptatem.</p>
                                <div class="caption-btns">
                                    <a href="#">See More</a>
                                    <a href="#">Buy Now</a>
                                </div>
                            </div>
                        </li>

                    </ul>
                </div>
                <div class="bx-controls bx-has-pager bx-has-controls-direction">
                    <div class="bx-pager bx-default-pager">
                        <div class="bx-pager-item"><a href="" data-slide-index="0" class="bx-pager-link">1</a></div>
                        <div class="bx-pager-item"><a href="" data-slide-index="1" class="bx-pager-link active">2</a></div>
                        <div class="bx-pager-item"><a href="" data-slide-index="2" class="bx-pager-link">3</a></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="kode-content">

            <!--BOOK GUIDE SECTION START-->
            <section>
                <div class="container">
                    <!--SECTION CONTENT START-->
                    <div class="section-heading-1">
                        <h2>Welcome to our library</h2>
                        <p>Welcome to the Most Popular Library Today</p>
                        <div class="kode-icon"><i class="fa fa-book"></i></div>
                    </div>
                    <!--SECTION CONTENT END-->
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="kode-service-3">
                                <i class="fa fa-gift"></i>
                                <h3><a href="#">Ebooks</a></h3>
                                <p>an electronic version of a printed book that can be read on a computer.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="kode-service-3">
                                <i class="fa fa-book"></i>
                                <h3><a href="#">audiobooks</a></h3>
                                <p>an audiocassette or CD recording of a reading of a book, typically a novel.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="kode-service-3">
                                <i class="fa fa-envelope"></i>
                                <h3><a href="#">Magazine</a></h3>
                                <p>a periodical publication containing articles and illustrations information.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="kode-service-3">
                                <i class="fa fa-calculator"></i>
                                <h3><a href="#">Teans &amp; Kids</a></h3>
                                <p>the years of a person's age from 13 to 19 and are the kids and teens.</p>
                                <a href="#" class="read-more">Read More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
       
<section class="lib-categories-section">
        	<div class="container">
            	<!--SECTION CONTENT START-->
            	<div class="section-heading-1 dark-sec">
            	<c:if  test="${!empty category }">
                    <h2 style="    text-transform: initial;">Books in : ${category} </h2>
             	 </c:if>
             	 
             	 <c:if  test="${empty category }">
                    <h2>Our Top Books</h2>
                    <p>Here are some of the Top Books of All the Books Available.</p>
             	 </c:if>
                	
                    <div class="kode-icon"><i class="fa fa-book"></i></div>
                </div>
                <!--SECTION CONTENT END-->
               
                           <div class="gallery_product col-lg-12 col-md-12 col-sm-4 col-xs-6 filter hdpe" style="  margin-left: -55px; width: 108%;">
    	<c:forEach var="rr" items="${data}">
        <div class="col-md-3 col-sm-6 best-seller-pro" style="width: 300px;
    		height: 320px;">
            <figure>
                <img src="<c:out value=" ${rr.image_path} "/>" style=" height: 250px;" alt="">
            </figure>

            <div class="kode-caption" style="margin-top: -115px;height: 320px;top:36%">
                <h3>${rr.titulli}</h3>

                <p>By : ${rr.author_name}</p>
                <p class="price">$ ${rr.price}</p>
                
                <p style="font-size:12px">${rr.pershkrimi}</p>
                
                   <c:if  test="${empty User}">
                   <a href="/nensinensi/account?action=login" class="add_to_cart1">Login to Buy Book! </a>
                  </c:if>
                <c:if  test="${!empty User}">
                
                <c:if test="${rr.quantity == 0}">
                           <p class="price" style="font-size:20px; color : red">Sorry, This Item is Sold! </p>
                        </c:if>
                
                 <c:if test="${rr.quantity != 0}">
                            <form target="paypal" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                                <p>
                                    <input type="hidden" name="cmd" value="_cart">
                                    <input type="hidden" name="add" value="1">
                                    <input type="hidden" name="business" value="nensiskenderi_est@gmail.com">
                                    <input type="hidden" name="currency_code" value="USD">
                                </p>

                                <input type="hidden" name="item_number" value="${rr.book_id}">
                                <input type="hidden" name="item_name" value="${rr.titulli}">
                                <input type="hidden" name="amount" value="${rr.price}">
                                <input type="hidden" name="quantity" value="1">
 	<button class="add-to-cart">Add To Cart</button>

                            </form>
                        </c:if>
                
                </c:if>
            </div>
        </div>
</c:forEach>
</div>

</div>
            
        </section>




      

        <section class="newsletter section-padding" style="margin-top: 5%;">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="center-content" style="    float: left;
    text-align: center;
    width: 100%;">
                            <h2 class="section-title" style="color: #282828;
    font-size: 35px;">Subscribe to our Newsletters</h2>
                            <span class="underline center" style="background-position: center top;"></span>
                            <p class="lead" style="color: #6b6b6b;
    font-size: 14px;
    font-style: italic;
    font-weight: 400;
    line-height: 1.42857143;
    margin-bottom: 50px;
">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.</p>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Enter your Email!" id="newsletter" name="newsletter" type="email">
                            <input class="form-control" value="Subscribe" type="submit">
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        
          <section class="news-events section-padding banner">
            <div class="container">
                <div class="center-content">
                    <h2 class="section-title c-light">News &amp; Events</h2>
                    <span class="underline center"></span>
                    <p class="lead c-light">The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.</p>
                </div>
                <div class="news-events-list">
                    <div class="single-news-event">
                        <figure>
                            <img src="http://libraria.demo.presstigers.com/images/news-event/news-event-01.jpg" alt="News &amp; Event">
                        </figure>
                        <div class="content-block">
                            <div class="member-info">
                                <div class="content_meta_category">
                                    <span class="arrow-right"></span>
                                    <a href="#." rel="category tag">EVENT</a>
                                </div>
                                <ul class="news-event-info">
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-calendar"></i> July 25, 2016
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-clock-o"></i> 10:15 AM - 10:15 PM
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-map-marker"></i> New York, USA
                                        </a>
                                    </li>
                                </ul>
                                <h3><a href=".#">It uses a dictionary of over 200 Latin word</a></h3>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model.</p>
                                <a class="btn btn-primary" href="#">Read More</a>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="single-news-event">
                        <figure>
                            <img src="http://libraria.demo.presstigers.com/images/news-event/news-event-02.jpg" alt="News &amp; Event">
                        </figure>
                        <div class="content-block">
                            <div class="member-info">
                                <div class="content_meta_category">
                                    <span class="arrow-right"></span>
                                    <a href="#." rel="category tag">EVENT</a>
                                </div>
                                <ul class="news-event-info">
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-calendar"></i> July 25, 2016
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-map-marker"></i> New York, USA
                                        </a>
                                    </li>
                                </ul>
                                <h3><a href=".#">It uses a dictionary of over 200 Latin word</a></h3>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', </p>
                                <a class="btn btn-primary" href="#">Read More</a>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="single-news-event">
                        <figure>
                            <img src="http://libraria.demo.presstigers.com/images/news-event/news-event-03.jpg" alt="News &amp; Event">
                        </figure>
                        <div class="content-block">
                            <div class="member-info">
                                <div class="content_meta_category">
                                    <span class="arrow-right"></span>
                                    <a href="#." rel="category tag">EVENT</a>
                                </div>
                                <ul class="news-event-info">
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-calendar"></i> July 25, 2016
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" target="_blank">
                                            <i class="fa fa-map-marker"></i> New York, USA
                                        </a>
                                    </li>
                                </ul>
                                <h3><a href=".#">It uses a dictionary of over 200 Latin word</a></h3>
                                <p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', </p>
                                <a class="btn btn-primary" href="#">Read More</a>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </section>
        
        
        <script src="/nensinensi/js/slider.js"></script>
        <script src="http://kodeforest.net/html/books/library/js/bootstrap-slider.js"></script>

        <script src="http://kodeforest.net/html/books/library/js/jquery.bxslider.min.js"></script>
        <script src="http://kodeforest.net/html/books/library/js/owl.carousel.js"></script>
        <script src="http://kodeforest.net/html/books/library/js/functions.js"></script>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>

    </html>