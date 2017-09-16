// JavaScript Document

function ShowDiv(show_div,bg_div){
	document.getElementById(show_div).style.display='block';
	document.getElementById(bg_div).style.display='block' ;
	var bgdiv = document.getElementById(bg_div);
	bgdiv.style.width = document.body.scrollWidth;
	// bgdiv.style.height = $(document).height();
	$("#"+bg_div).height($(document).height());
};

function CloseDiv(show_div,bg_div)
{
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};



function ShowDiv_1(show_div,bg_div){
	
	$.ajax({
		url:"addBuyCarServlet",
		type:"post",
		dataType:"json",
		data:{
			count:$("#n_ipt").val(),
			id:$("#productId").val()
		},
		success:function(data){
			console.log(data);
			if(data.isSuccess==true){
				document.getElementById(show_div).style.display='block';
				document.getElementById(bg_div).style.display='block' ;
				var bgdiv = document.getElementById(bg_div);
				bgdiv.style.width = document.body.scrollWidth;
				$("#"+bg_div).height($(document).height());
				$("#total").text(data.total);
				$("#productCount").text(data.productCount);
			}else{
				alert("添加购物车失败");
			}
		},error:function(XMLResponse){
			alert(XMLResponse.responseText)
		}
	})

};
//�رյ�����
function CloseDiv_1(show_div,bg_div)
{
	document.getElementById(show_div).style.display='none';
	document.getElementById(bg_div).style.display='none';
};