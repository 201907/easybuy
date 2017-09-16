$(function(){
	$("#changeCode").click(function(){
		$(this).prev("img").attr("src","createVerificatieCode?t="+new Date().getTime());
		return false;
	})
	$.validator.addMethod("checkMail",function(value,element,params){
        var checkName = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        return this.optional(element)||(checkName.test(value));
    },"邮箱格式错误！");
	$.validator.addMethod("checkPhone",function(value,element,params){
        var checkName = /^\d{11}$/;
        return this.optional(element)||(checkName.test(value));
    },"邮箱格式错误！");
	$("#myform").validate({
		rules:{
			username:{
				required:true,
				remote:{
					type:"post",
					url:"checkUserIfExists",
					data:{
						username:function(){
							return $("#username").val();
						}
					}
				}
			},
			pswd:{
				required:true
			},
			cpswd:{
				required:true,
				equalTo:"#pswd"
			},
			email:{
				required:true,
				checkMail:true
			},
			tel:{
				required:true,
				checkPhone:true
			},
			code:{
				required:true,
				remote:{
					type:"post",
					url:"checkVerificatieCode",
					data:{
						username:function(){
							return $("#code").val();
						}
					}
				}
			},
			choose:{
				required:true
			}
		},
		messages:{
			username:{
				required:"请输入用户名",
				remote:"用户名已注册"
			},
			pswd:{
				required:"请输入密码",
			},
			cpswd:{
				required:"请重新输入密码",
				equalTo:"密码输入不正确"
			},
			email:{
				required:"请输入邮箱地址",
				checkMail:"邮箱格式错误"
			},
			tel:{
				required:"请输入手机号",
				checkPhone:"手机格式错误"
			},
			code:{
				required:"请输入验证码",
				remote:"验证码输入错误"
			},
			choose:{
				required:"必须接受用户协议"
			}
		}
	})
})