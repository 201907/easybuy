<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link type="text/css" rel="stylesheet" href="css/style.css" />
    <!--[if IE 6]>
    <script src="js/iepng.js" type="text/javascript"></script>
        <script type="text/javascript">
           EvPNG.fix('div, ul, img, li, input, a'); 
        </script>
    <![endif]-->
        
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>    
        
	<script type="text/javascript" src="js/select.js"></script>
        
    
<title>尤洪</title>
</head>
<body>  
<!--Begin Header Begin-->
<jsp:include page="member_element/header.jsp"></jsp:include>
<!--End Header End--> 
<div class="i_bg bg_color">
    <!--Begin 用户中心 Begin -->
	<div class="m_content">
   		<jsp:include page="member_element/left.jsp"></jsp:include>
		<div class="m_right">
            <p></p>
            <div class="mem_tit">我的留言</div>
           	<form>
            <table border="0" style="width:880px; margin-top:20px;"  cellspacing="0" cellpadding="0">
              <tr height="45">
                <td width="80" align="right">留言类型 &nbsp; &nbsp;</td>
                <td>                            
                	<label class="r_rad"><input type="checkbox" name="type" checked="checked" /></label><label class="r_txt">留言</label>
                    <label class="r_rad"><input type="checkbox" name="type" /></label><label class="r_txt">投诉</label>
                    <label class="r_rad"><input type="checkbox" name="type" /></label><label class="r_txt">询问</label>
                    <label class="r_rad"><input type="checkbox" name="type" /></label><label class="r_txt">售后</label>
                    <label class="r_rad"><input type="checkbox" name="type" /></label><label class="r_txt">求购</label>
                </td>
              </tr>
              <tr height="45">
                <td align="right">主题 &nbsp; &nbsp;</td>
                <td><input type="text" value="" class="add_ipt" style="width:290px;" /></td>
              </tr>
              <tr valign="top" height="110">
                <td align="right">留言内容 &nbsp; &nbsp;</td>
                <td style="padding-top:5px;"><textarea class="add_txt"></textarea></td>
              </tr>
              <tr height="45">
                <td align="right">上传文件 &nbsp; &nbsp;</td>
                <td><input type="file" /></td>
              </tr>
              <tr height="50">
                <td>&nbsp;</td>
                <td style="line-height:20px;">
                	<font color="#ff4e00">小提示：</font><br />
                    您可以上传以下格式的文件：gif、jpg、png、word、excel、txt、zip、ppt、pdf
                </td>
              </tr>
              <tr height="50" valign="bottom">
                <td>&nbsp;</td>
                <td><input type="submit" value="提交" class="btn_tj" /></td>
              </tr>
            </table>
            </form>







            
        </div>
    </div>
	<!--End 用户中心 End--> 
    <!--Begin Footer Begin -->
    <div class="b_btm_bg b_btm_c">
        <div class="b_btm">
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b1.png" width="62" height="62" /></td>
                <td><h2>正品保障</h2>正品行货  放心购买</td>
              </tr>
            </table>
			<table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b2.png" width="62" height="62" /></td>
                <td><h2>满38包邮</h2>满38包邮 免运费</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b3.png" width="62" height="62" /></td>
                <td><h2>天天低价</h2>天天低价 畅选无忧</td>
              </tr>
            </table>
            <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
              <tr>
                <td width="72"><img src="images/b4.png" width="62" height="62" /></td>
                <td><h2>准时送达</h2>收货时间由你做主</td>
              </tr>
            </table>
        </div>
    </div>
    <div class="b_nav">
    	<dl>                                                                                            
        	<dt><a href="#">新手上路</a></dt>
            <dd><a href="#">售后流程</a></dd>
            <dd><a href="#">购物流程</a></dd>
            <dd><a href="#">订购方式</a></dd>
            <dd><a href="#">隐私声明</a></dd>
            <dd><a href="#">推荐分享说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">配送与支付</a></dt>
            <dd><a href="#">货到付款区域</a></dd>
            <dd><a href="#">配送支付查询</a></dd>
            <dd><a href="#">支付方式说明</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">会员中心</a></dt>
            <dd><a href="#">资金管理</a></dd>
            <dd><a href="#">我的收藏</a></dd>
            <dd><a href="#">我的订单</a></dd>
        </dl>
        <dl>
        	<dt><a href="#">服务保证</a></dt>
            <dd><a href="#">退换货原则</a></dd>
            <dd><a href="#">售后服务保