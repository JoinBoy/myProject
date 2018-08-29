$(document).ready(function(){
//	点击变换图片
	$(".list img").each(function(i){
		$(this).on("click",function(){
			$(".main-right img").hide("fast");
			var url = $(this).attr("src");
			setTimeout(function(){
				$(".main-right img").attr("src",url).show("fast")
			},200)
		})		
	})
})
