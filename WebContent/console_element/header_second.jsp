<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<div class="menu_bg">
	<div class="menu">
    	<!--Begin 商品分类详情 Begin-->    
    	<div class="nav">
        	<div class="nav_t">全部商品分类</div>
            <div class="leftNav">
                <ul>
                	<c:choose>
	                	<c:when test="${empty epc_first }">
	                		<c:out value="一级标题无数据!" />
	                	</c:when>
	                	<c:otherwise>  
							<c:forEach var="first" items="${epc_first}">
								<li>	                    	
									<div class="fj">
									   	<span class="n_img"><span></span><img src="images/nav1.png" /></span>
									    <span class="fl">${first.name}</span>
									</div>
									<div class="zj" style="top:${(first.id - 1) * (-40)}px;">
									    <div class="zj_l">
									        <div class="zj_l_c">
									        	<c:choose>
								                	<c:when test="${empty epc_second }">
								                		<c:out value="二级标题无数据!" />
								                	</c:when>
								                	<c:otherwise>
												        <c:forEach var="second" items="${epc_second}">												      		
												     		<c:if test="${second.parentid eq first.id}">
													           	<h2>${second.name }</h2>
													           	<c:choose>
													           		<c:when test="${empty epc_third }">
													           			<c:out value="三级标题无数据!" />
													           		</c:when>
													           		<c:otherwise>
															           	<c:forEach var="third" items="${epc_third}">
															           		<c:if test="${third.parentid eq second.id}">
															            		<a href="#">${third.name }</a>|
															            	</c:if>
															            </c:forEach>
														            </c:otherwise>
													            </c:choose>
												           	</c:if>												           	
												    	</c:forEach>
											    	</c:otherwise>
									        	</c:choose>
									        </div>		                                
									    </div>
									    <div class="zj_r">
									        <a href="#"><img src="images/n_img1.jpg" width="236" height="200" /></a>
									        <a href="#"><img src="images/n_img2.jpg" width="236" height="200" /></a>
									    </div>
									</div>
								</li>	                        
							</c:forEach>
						</c:otherwise>
					</c:choose>                                        	
                </ul>            
            </div>
        </div>  
        <!--End 商品分类详情 End-->                                                     
    	<ul class="menu_r">                                                                                                                                               
        	<li><a href="toIndex">首页</a></li>
            <li><a href="Food.html">美食</a></li>
            <li><a href="Fresh.html">生鲜</a></li>
            <li><a href="HomeDecoration.html">家居</a></li>
            <li><a href="SuitDress.html">女装</a></li>
            <li><a href="MakeUp.html">美妆</a></li>
            <li><a href="Digital.html">数码</a></li>
            <li><a href="GroupBuying.html">团购</a></li>
        </ul>
        <div class="m_ad">中秋送好礼！</div>
    </div>
</div>
</html>