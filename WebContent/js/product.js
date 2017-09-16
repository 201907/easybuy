$(function(){
	$("#upCount").click(function(){
		var count = parseInt($("#n_ipt").val());
		$("#n_ipt").val(count+1);
	})
		$("#minusCount").click(function(){
		var count = parseInt($("#n_ipt").val());
		if(count>1){
			$("#n_ipt").val(count-1);
		}
	})
})