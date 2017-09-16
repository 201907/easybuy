<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>.error{color:red;}</style>
 	<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>  
	<script type="text/javascript" src="js/memberAddress.js"></script> 
        
    
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
            <div class="mem_tit">收货地址</div>
			<div class="address">
            	<div class="a_close"><a href="#"><img src="images/a_close.png" /></a></div>
           			  <table border="0" class="add_t" align="center" style="width:98%; margin:10px auto;" cellspacing="0" cellpadding="0">
		                  <tr>
		                    <td colspan="2" style="font-size:14px; color:#ff4e00;">杨杨公司</td>
		                  </tr>
		                  <tr>
		                    <td align="right" width="80">收货人姓名：</td>
		                    <td id="name"></td>
		                  </tr>
		                  <tr>
		                    <td align="right">配送区域：</td>
		                    <td id="area"></td>
		                  </tr>
		                  <tr>
		                    <td align="right">详细地址：</td>
		                    <td id="address"></td>
		                  </tr>
		                  <tr>
		                    <td align="right">手机：</td>
		                    <td id="mobile"></td>
		                  </tr>
		                  <tr>
		                    <td align="right">电话：</td>
		                    <td id="phone"></td>
		                  </tr>
		                  <tr>
		                    <td align="right">电子邮箱：</td>
		                    <td id="email"></td>
		                  </tr>
		                  <tr>
		                    <td align="right">标志建筑：</td>
		                    <td>世外桃源</td>
		                  </tr>
		                  <input type="hidden" id="addressId"/>
	                </table>
	                <p align="right">
	                	<a id="setDefaultAddress" href="javascript:;" style="color:#ff4e00;">设为默认</a>&nbsp; &nbsp; &nbsp; &nbsp; <a href="#" style="color:#ff4e00;">编辑</a>&nbsp; &nbsp; &nbsp; &nbsp; 
	                </p>


            </div>

            <div class="mem_tit">
            	<a href="#"><img src="images/add_ad.gif" /></a>
            </div>
            <form action="addAddressServlet" method="post" id="myform">
            <table border="0" class="add_tab" style="width:930px;"  cellspacing="0" cellpadding="0">
              <tr>
                <td width="135" align="right">配送地区</td>
                <td colspan="3" style="font-family:'宋体';">
                	<select class="jj" name="country" style="background-color:#f6f6f6;">
                      <option value="" selected="selected">请选择...</option>
                      <option value="中国">中国</option>
                    </select>
                	<select class="jj" name="province">
                      <option value="" selected="selected">请选择...</option>
                      <option value="四川">四川</option>
                      <option value="重庆">重庆</option>
                      <option value="北京">北京</option>
                      <option value="云南">云南</option>
                    </select>
                    <select class="jj" name="city">
                      <option value="" selected="selected">请选择...</option>
                      <option value="成都">成都</option>
                      <option value="宜宾">宜宾</option>
                      <option value="南充">南充</option>
                      <option value="绵阳">绵阳</option>
                    </select>
                    <select class="jj" name="area">
                      <option value="" selected="selected">请选择...</option>
                      <option value="武侯区">武侯区</option>
                      <option value="成华区">成华区</option>
                      <option value="锦江区">锦江区</option>
                      <option value="青羊区">青羊区</option>
                    </select>
                    （必填）
                </td>
              </tr>
              <tr>
                <td align="right">收货人姓名</td>
                <td style="font-family:'宋体';"><input type="text" value="姓名" class="add_ipt" name="name"/>（必填）</td>
                <td align="right">电子邮箱</td>
                <td style="font-family:'宋体';"><input type="text" value="12345678@qq.com" class="add_ipt" name="email"/>（必填）</td>
              </tr>
              <tr>
                <td align="right">详细地址</td>
                <td style="font-family:'宋体';"><input type="text" value="世外桃源" class="add_ipt" name="address"/>（必填）</td>
                <td align="right">邮政编码</td>
                <td style="font-family:'宋体';"><input type="text" value="610000" class="add_ipt" name="postcodes"/></td>
              </tr>
              <tr>
                <td align="right">手机</td>
                <td style="font-family:'宋体';"><input type="text" value="1361234587" class="add_ipt" name="mobile"/>（必填）</td>
                <td align="right">电话</td>
               </tr>
               </table>
               </form>