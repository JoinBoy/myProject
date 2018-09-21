$("document").ready(function(){
	//获取浏览器视口高度
	getClientHeight();
	//监听窗口变化
	windowResize();
	//生成验证码
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

var app= new Vue({
	el:"#app",
	data:{
		login:true,
		register:false,
		nameRegister:"",
		passWordRegister:"",
		passWordRegisterAffirm:"",
		mailRegister:"",
		messageRegister:"",
	},
	methods:{
		showLogin:function(){//点击登录标签
			app.$data.login=true;				
			this.$nextTick(function(){
				creatCode([2,"中",7,4]);
			})
			app.$data.register=false;
		},
		showRegister:function(){//点击注册标签
			app.$data.login=false;
			app.$data.register=true;
		},
		submit:function(){
			
		},
		detection:function(){//注册监测逻辑
			//判断账号
			if(app.$data.nameRegister){
				if(app.$data.nameRegister.length>6) {
					app.$data.messageRegister = "账号长度不能大于6!";
					return 0;
				}else{
					app.$data.messageRegister = "";
				}
			}
			//判断密码
			if(app.$data.passWordRegister){
				if(app.$data.passWordRegister.length<8 || app.$data.passWordRegister.length>16){
					app.$data.messageRegister = "密码长度位8-16位!";
					return 0;
				}else if(app.$data.passWordRegisterAffirm.length>0){
					if(app.$data.passWordRegisterAffirm !== app.$data.passWordRegister){
						app.$data.messageRegister = "两次密码不一样!";
						return 0 ;
					}
				}else {
					app.$data.messageRegister = "";
				}
			}			
			//判断再次输入密码
			if(app.$data.passWordRegisterAffirm){
				if(app.$data.passWordRegister){
					if(app.$data.passWordRegister !== app.$data.passWordRegisterAffirm){
						app.$data.messageRegister = "两次密码不一样!";
						return 0 ;
					}else{
						app.$data.messageRegister = "";
					}
				}else{
					app.$data.messageRegister = "请输入上边密码";
					return 0 ;
				}
			}			
			//判断邮箱
			if(app.$data.mailRegister){
				var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
				if(re.test(app.$data.mailRegister)){
					app.$data.messageRegister = "";
				}
				else{
					app.$data.messageRegister = "请输入正确的邮箱格式!";
					return 0;
				}	
			}
		}
	},
	watch:{
		nameRegister:function(){//账号判断
			app.$data.nameRegister = $.trim(app.$data.nameRegister);
			this.detection();
		},
		passWordRegister:function(){//密码判断
			app.$data.passWordRegister = $.trim(app.$data.passWordRegister);
			this.detection();
		},
		passWordRegisterAffirm:function(){//再次输入密码判断
			app.$data.passWordRegisterAffirm = $.trim(app.$data.passWordRegisterAffirm);
			this.detection();
		},
		mailRegister:function(){//邮箱判断
			app.$data.mailRegister = $.trim(app.$data.mailRegister);
			this.detection();
		}
	}

})
