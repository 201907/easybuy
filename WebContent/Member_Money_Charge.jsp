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
            <div class="mem_tit">
            	<span class="fr" style="font-size:12px; color:#55555; font-family:'宋体'; margin-top:5px;">共发现0件</span>会员余额
            </div>
			<table border="0" class="ma_tab" style="width:930px; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>
              	<td class="ma_a" colspan="3" align="right"><a href="Member_Money_Charge.html">充值</a>|<a href="#">提现</a>|<a href="#">查看账户明细</a>|<a href="#">查看申请记录</a></td>
              </tr>
              <tr>
                <td>充值金额</td>
                <td colspan="2"><input type="text" value="" class="add_ipt" style="width:190px;" /></td>
              </tr>
              <tr valign="top" height="180">
                <td>会员备注</td>
                <td colspan="2" style="padding-top:10px;"><textarea class="add_txt" style="width:540px; height:130px;"></textarea></td>
              </tr>
              <tr>
                <td colspan="3">支付方式</td>
              </tr>
              <tr>                                                                                                                                                    
                <td width="200" align="center">名称</td>                                                            
                <td width="500" align="center">描述</td>
                <td width="230" align="center">手续费</td>                   
              </tr>
              <tr>
                <td><label class="r_rad"><input type="checkbox" name="pay" checked="checked" /></label><label class="r_txt">银行汇款 / 转账</label></td>
                <td>
                	银行名称 收款人信息：全称 ××× ；帐号或地址 ××× ；开户行 ×××。 <br />
                    注意事项：办理电汇时，请在电汇单“汇款用途”一栏处注明您的订单号。
                </td>
                <td align="center">0</td>
              </tr>
              <tr>
                <td><label class="r_rad"><input type="checkbox" name="pay" /></label><label class="r_txt">支付宝</label></td>
                <td>
                	支付宝网站(www.alipay.com) 是国内先进的网上支付平台。<br />
                    支付宝收款接口：在线即可开通，<font color="#ff4e00">零预付，免年费，</font>单笔阶梯费率，无流量限制。<br />
                    <a href="#" style="color:#ff4e00;">立即在线申请</a>
                </td>
                <td align="center">0</td>
              </tr>
              <tr>
                <td colspan="7" align="right">您当前的可用资金为：￥0.00</td>
              </tr>
			</table>
            
            <p align="center">
            	<input type="submit" value="提交申请" class="btn_tj" />&nbsp; &nbsp; <input type="reset" value="重置表单" class="btn_tj" />
            </p>
			


            
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
            <dd><a href="#">购物