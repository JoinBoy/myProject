$("document").ready(function(){
	//获取浏览器视口高度
	getClientHeight();
	//监听窗口变化
	windowResize();
	creatCode([2,"中",7,4])
});

//获取浏览器视口高度
function getClientHeight(){
	var height = document.body.clientHeight;
	$(".main").css("height",height+"px");
}

//监听窗口变化
function windowResize(){
	$(window).resize(function(){
		getClientHeight();
	})
}

//生成验证码
function creatCode(four){
	var c = document.getElementById("canvas");
	var ctx = c.getContext("2d");
	var height = c.height;
	var width = c.width;
	ctx.fillStyle = randomRgb();
	ctx.fillRect(0,0,width,height);
	ctx.fillStyle = randomRgb();
	ctx.font = (randomX(5)+20)+"px 微软雅黑"
	ctx.fillText(four[0],randomX(5),30)
	ctx.fillStyle = randomRgb();
	ctx.font = (randomX(5)+20)+"px 微软雅黑"
	ctx.fillText(four[1],randomX(5)+25,30)
	ctx.fillStyle = randomRgb();
	ctx.font = (randomX(5)+20)+"px 微软雅黑"
	ctx.fillText(four[2],randomX(5)+50,30)
	ctx.fillStyle = randomRgb();
	ctx.font = (randomX(5)+20)+"px 微软雅黑"
	ctx.fillText(four[3],randomX(5)+75,30)
    for(var i=0; i<5; i++){
      ctx.strokeStyle =  randomRgb();
      ctx.beginPath();
      ctx.moveTo( randomX(100), randomX(40));
      ctx.lineTo( randomX(100), randomX(40));
      ctx.stroke();
    }
    
    for(var i=0; i<40; i++){
      ctx.fillStyle = randomRgb();
      ctx.beginPath();
      ctx.arc( randomX(100), randomX(40), 1, 0, 2*Math.PI);
      ctx.fill();
    }
}

//随机生成验证码颜色
function randomRgb(){
	r = parseInt(Math.random()*255);
	g = parseInt(Math.random()*255);
	b = parseInt(Math.random()*255);
	return "rgb("+r+","+g+","+b+")"
}

//生成随机整数
function randomX(x){
	x = parseInt(Math.random()*x);
	return x;
}
var app = new Vue({
	el:"#app",
	data:{
		login:true,
		register:false,
	},
	methods:{
		showLogin:function(){
			app.$data.login=true;
			app.$data.register=false;
			console.log("22")
		},
		showRegister:function(){
			app.$data.login=false;
			app.$data.register=true;
		}
	}
})