var index = null; //定义全局图片index


$(document).ready(function(){
//	点击变换图片
	imgClick();	
//	初始化左侧图片
	initImg();
//  监听鼠标滚轮
	windowAddMouseWheel();
//点击首页右侧跳转子项目首页
	childProject();
})
//	点击变换图片
function imgClick(){
	$(".list img").each(function(i){
		$(this).on("click",function(){
			if(index == parseInt($(this).attr("id"))){
				return;
			}
			index = parseInt($(this).attr("id"));
			$(".list img").css("opacity",0.4);
			$(this).css("opacity",1)
			$(".main-right img").hide("fast");
			var url = $(this).attr("src");
			setTimeout(function(){
				$(".main-right img").attr("src",url).show("fast")
			},200)
		})		
	})
}

//初始化左侧图片
function initImg(){
	index = 0;
	$(".list img").css("opacity",0.4);
	$(".list img").eq(0).css("opacity",1)
	$(".list img").each(function(i){
		$(this).attr("id",i);
	})
}

//  监听鼠标滚轮
function windowAddMouseWheel() {
    var scrollFunc = function (e) {
        e = e || window.event;
        if (e.wheelDelta) {  //判断浏览器IE，谷歌滑轮事件
            if (e.wheelDelta > 0) { //当滑轮向上滚动时           	
                onMouseUp();
            }
            if (e.wheelDelta < 0) { //当滑轮向下滚动时
               onMouseDown();
            }
        } else if (e.detail) {  //Firefox滑轮事件
            if (e.detail> 0) { //当滑轮向上滚动时
                onMouseUp();
            }
            if (e.detail< 0) { //当滑轮向下滚动时
            	onMouseDown();
            }
        }
    };
    //给页面绑定滑轮滚动事件
    if (document.addEventListener) {
        document.addEventListener('DOMMouseScroll', scrollFunc, false);
    }
//滚动滑轮触发scrollFunc方法
	if(document.onmousewheel){
		document.onmousewheel = scrollFunc;
	}else{
		window.onmousewheel = scrollFunc;
	}
}
//鼠标滚轮上滚
function onMouseUp(){
	$("#"+index).css("opacity",0.4);
	index -= 1;
	if(index < 0) index = $(".list img").length -1
	$("#"+index).css("opacity",1);
	$(".main-right img").hide("fast");
	var url = $("#"+index).attr("src");
	setTimeout(function(){
		$(".main-right img").attr("src",url).show("fast")
	},200)
}

//鼠标滚轮下滚
function onMouseDown(){
	$("#"+index).css("opacity",0.4);
	index += 1;
	if(index == $(".list img").length) index = 0;
	$("#"+index).css("opacity",1);
	$(".main-right img").hide("fast");
	var url = $("#"+index).attr("src");
	setTimeout(function(){
		$(".main-right img").attr("src",url).show("fast")
	},200)
}

//点击首页右侧跳转子项目首页
function childProject(){
	$(".main-right").click(function(){
		console.log(1111)
		window.location.href="vueIndex";
	})
}
