<template>
    <div class="main" >
        <div class='registerTable' >
            <div class="title" >
                <div class="login" id="login" @click="showLogin">
                    <div class="login-text">登录</div>
                    <div class="line" id="loginLine" v-if="login"></div>
                </div>
                <div class="login" id='register' @click="showRegister">
                    <div class="login-text">注册</div>
                    <div class="line" id="registerLine" v-if="register"></div>
                </div>
            </div>
            <div class="loginContent"  v-if="login">
                <div class="formDiv">
                    <div class="warnning" v-cloak>
                        <span class="glyphicon glyphicon-warning-sign" v-if="loginMessage"></span>
                        <span>{{loginMessage}}</span>
                    </div>
                </div>
                <div class="formDiv">
                    <span>账号：</span>
                    <input type="text" name="name" id="name" v-model.trim='userName'  class="formDiv-input"/>
                </div>
                <div class="formDiv">
                    <span>密码：</span>
                    <input type="password" name="password" v-model.trim="userPassWord" id="password"  class="formDiv-input"/>
                </div>
                <div class="formDiv">
                    <canvas id="canvas" width="100px" height="40px" style="float:left; margin-top: 5px;margin-left: 46px;"></canvas>
                    <a class="giveNew" @click="getCode">换一张</a>
                </div>
                <div class="formDiv">
                    <span style="float:left;margin-left: -13px;">验证码：</span>
                    <input style="margin-left:3px" type="text" name="verification" id="verification" v-model.trim="verification"  class="formDiv-input"/>
                </div>
                <div class="formDiv">
                    <button class="btn btn-success myBotton" @click='onLogin' :disabled="userName.length==0||userPassWord.length==0||verification.length==0">登录</button>
                </div>
            </div>
            <div  class="loginContent" v-cloak v-if="register" style="margin-top: 0px;">
                <div class="formDiv">
                    <div class="warnning" v-if="messageRegister">
                        <span class="glyphicon glyphicon-warning-sign" ></span>
                        <span>{{messageRegister}}</span>
                    </div>
                </div>
                <div class="formDiv">
                    <span>账号：</span>
                    <input type="text" name="name" id="name" v-model="nameRegister" value="nameRegister?nameRegister:''"  class="formDiv-input" />
                </div>
                <div class="formDiv">
                    <span>密码：</span>
                    <input type="password" name="passwordRegister" id="passwordRegister" v-model="passWordRegister" value="passWordRegister"  class="formDiv-input" />
                </div>
                <div class="formDiv">
                    <span style="margin-left:-28px">确认密码：</span>
                    <input type="password" name="passwordRegisterAffirm" id="passwordRegisterAffirm" v-model="passWordRegisterAffirm" value="passWordRegisterAffirm"  class="formDiv-input" />
                </div>
                <div class="formDiv">
                    <span>邮箱：</span>
                    <input type="text" name="password" id="mailRegister" v-model="mailRegister" value="mailRegister"  class="formDiv-input" />						
                </div>
                <div class="formDiv">
                    <button class="btn btn-success myBotton" @click="submit" :disabled="messageRegister.length!=0||nameRegister.length==0||passWordRegister.length==0||passWordRegisterAffirm.length==0||mailRegister.length==0">注册</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script  lang="ts">
    import {Component,Vue} from "vue-property-decorator";
    import qs from "qs";
    import axios from "axios"
    @Component({
        name:"register"
    })

    export default class Register extends Vue{

        private login:boolean = true;
        private register:boolean = false;
        private userName:string = "";
        private userPassWord:string = "";
        private nameRegister:string = "";
        private passWordRegister:string = "";
        private passWordRegisterAffirm:string = "";
        private mailRegister:string = "";
        private messageRegister:string = "";
        private loginMessage:string = "";
        private verification:string = "";

        //生命周期
        created():void {
           
        }
        mounted():void {
            console.log(this.axios)
            console.log(11111,axios)
            this.getCode();
             //获取浏览器视口高度
             this.getClientHeight();
            //监听窗口变化
            this.windowResize();
        }

        /*
        *点击登录标签
        */
        private showLogin():void{
            this.login=true;				
            this.$nextTick(():void=>{
                this.getCode();
            })
            this.register=false;
        }
        /*
        *点击注册标签
        */
        private showRegister():void{
            this.login=false;
            this.register=true;
        }

        /*
        *点击注册按钮
        */
        private submit():void{
            this.$http.post("/myProject/registerList",
                    {userName:this.nameRegister,
                    userPassWord:this.passWordRegister,
                    userMail:this.mailRegister}).then((response:any)=>{
                if(response.body.code ==1){
                    this.messageRegister = response.body.message;
                }
            },(response:any)=>{
                console.log(response)
            })
        }
        /*
        *注册监测逻辑
        */
        private detection():number{
            //判断账号
            if(this.nameRegister){
                if(this.nameRegister.length>6) {
                    this.messageRegister = "账号长度不能大于6!";
                    return 0;
                }else{
                    this.messageRegister = "";
                }
            }
            //判断密码
            if(this.passWordRegister){
                if(this.passWordRegister.length<8 || this.passWordRegister.length>16){
                    this.messageRegister = "密码长度位8-16位!";
                    return 0;
                }else if(this.passWordRegisterAffirm.length>0){
                    if(this.passWordRegisterAffirm !== this.passWordRegister){
                        this.messageRegister = "两次密码不一样!";
                        return 0 ;
                    }
                }else {
                    this.messageRegister = "";
                }
            }			
            //判断再次输入密码
            if(this.passWordRegisterAffirm){
                if(this.passWordRegister){
                    if(this.passWordRegister !== this.passWordRegisterAffirm){
                        this.messageRegister = "两次密码不一样!";
                        return 0 ;
                    }else{
                        this.messageRegister = "";
                    }
                }else{
                    this.messageRegister = "请输入上边密码";
                    return 0 ;
                }
            }			
            //判断邮箱
            if(this.mailRegister){
                var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
                if(re.test(this.mailRegister)){
                    this.messageRegister = "";
                    
                }
                else{
                    this.messageRegister = "请输入正确的邮箱格式!";
                    return 0;
                }	
            }
            return 0;
        }

        /*
        *用户点击登录
        */
        private onLogin():void{
            // this.$http.post("http://192.168.1.119:8808/myProject/login",{userName:this.userName,
            // userPassWord:this.userPassWord,
            // verification:this.verification},{emulateJSON:true,withCredentials:true}).then((response:any)=>{
            //     if(response.body.code==0){
            //         this.loginMessage = '';
            //         if(response.body.message == '登陆成功！')
            //         console.log("缓存",document.cookie)
            //         console.log("登录成功")
            //         // this.$router.push('/')
            //     }else if(response.body.code==1){
            //         this.loginMessage = response.body.message;
            //     }
            // },(response:any)=>{
            //     this.loginMessage = "请求失败！";
            // })
            var data = {userName:this.userName,
                         userPassWord:this.userPassWord,
                            verification:this.verification}
            data = qs.stringify(data)
            axios({
                    url:"http://192.168.1.201:8808/myProject/login",
                    method:"post",
                    withCredentials:true,
                    crossDomain:true,
                    emulateJSON:true,
                    // headers: {
                    //     'Content-Type': 'application/x-www-form-urlencoded'
                    // },
                    data:data 
                }).then((response:any)=>{
                    console.log(response)
                // if(response.body.code==0){
                //     this.loginMessage = '';
                //     if(response.body.message == '登陆成功！')
                //     console.log("缓存",document.cookie)
                //     console.log("登录成功")
                //     // this.$router.push('/')
                // }else if(response.body.code==1){
                //     this.loginMessage = response.body.message;
                // }
            },(response:any)=>{
                this.loginMessage = "请求失败！";
            })
        }
        /*
        *获取验证码
        */
        getCode(){//获取验证码
            this.$http.get("http://192.168.1.201                            verification:"4578"}
            verification:"4578"}
:8808/myProject/verificationCode").then((response:any)=>{
                if(response.body.code==0){
                    this.creatCode(response.body.data);//调用生成验证码
                }else{
                    
                }
            },(response:any)=>{
                
            })
            console.log(1111111)
        }

        //         //生成验证码
        creatCode(four:number[]):void{
            var c:any  = document.getElementById("canvas");
            var ctx:any  = c.getContext("2d");
            var height:any = c.height;
            var width:any = c.width;
            ctx.fillStyle = this.randomRgb();
            ctx.fillRect(0,0,width,height);
            ctx.fillStyle = this.randomRgb();
            ctx.font = (this.randomX(5)+20)+"px 微软雅黑"
            ctx.fillText(four[0],this.randomX(5),30)
            ctx.fillStyle = this.randomRgb();
            ctx.font = (this.randomX(5)+20)+"px 微软雅黑"
            ctx.fillText(four[1],this.randomX(5)+25,30)
            ctx.fillStyle = this.randomRgb();
            ctx.font = (this.randomX(5)+20)+"px 微软雅黑"
            ctx.fillText(four[2],this.randomX(5)+50,30)
            ctx.fillStyle = this.randomRgb();
            ctx.font = (this.randomX(5)+20)+"px 微软雅黑"
            ctx.fillText(four[3],this.randomX(5)+75,30)
            for(var i=0; i<5; i++){
            ctx.strokeStyle =  this.randomRgb();
            ctx.beginPath();
            ctx.moveTo( this.randomX(100), this.randomX(40));
            ctx.lineTo( this.randomX(100), this.randomX(40));
            ctx.stroke();
            }
            
            for(var i=0; i<40; i++){
            ctx.fillStyle = this.randomRgb();
            ctx.beginPath();
            ctx.arc( this.randomX(100), this.randomX(40), 1, 0, 2*Math.PI);
            ctx.fill();
            }
        }

        //随机生成验证码颜色
        private randomRgb():string{
            let r:number = parseInt((Math.random()*255).toString());
            let g:number = parseInt((Math.random()*255).toString());
            let b:number = parseInt((Math.random()*255).toString());
            return "rgb("+r+","+g+","+b+")"
        }

        //生成随机整数
        private randomX(x:number):number{
            x = parseInt((Math.random()*x).toString());
            return x;
        }
        //获取浏览器视口高度
        private getClientHeight():void{
            var height:number = document.body.clientHeight;
            var mainDom:any = document.getElementsByClassName("main")[0];
            mainDom.height = height+'px';
            
            
        }
           //         //监听窗口变化
        private windowResize():void{
            document.onresize =():void =>{
                this.getClientHeight();
            }
        }
    }






    // export default {

    //     mounted () {

    //         this.getCode();//调用生成验证码
    //     },
    //     methods:{



 

    








    //     },
    //     watch:{
    //         nameRegister:function(){//账号判断
    //             this.nameRegister = this.nameRegister.trim();
    //             this.detection();
    //         },
    //         passWordRegister:function(){//密码判断
    //             this.passWordRegister = this.passWordRegister.trim();
    //             this.detection();
    //         },
    //         passWordRegisterAffirm:function(){//再次输入密码判断
    //             this.passWordRegisterAffirm = this.passWordRegisterAffirm.trim();
    //             this.detection();
    //         },
    //         mailRegister:function(){//邮箱判断
    //             this.mailRegister = this.mailRegister.trim();
    //             this.detection();
    //         }
    //     }
    // }
</script>


<style lang="scss" scoped>
.main{
	height:100vh;
	min-width:300px;
	margin:auto;
	position: relative;
	background-image: url(../../assets/images/register/login.jpg);
	background-repeat:no-repeat;
	background-size: 100%;
	min-height:400px;
	min-width:300px;
}
.registerTable{
	height:400px;
	width:300px;
	background-color:rgba(255,255,255,1);
	position: absolute;
	top: 0;
	left: 0;
	right:0;
	bottom:0;
	margin: auto;
}
.title{
	height:50px;
	width:100%;
	border-bottom: 2px solid #ECECEC;
}
.login{
	width:50%;
	float:left;
	height:50px;
	cursor: pointer;
}
.login-text{
	width:60px;
	height:50px;
	margin:0 auto;
	font-size: 22px;
	color:#333;
	line-height: 50px;
	text-align: center;
}
.formDiv{
	height:50px;
	width:80%;
	margin:0 auto;
	line-height: 50px;	
}
.formDiv-input{
	height:40px;
	/* width: 80%; */
	margin-top:5px;
	border:1px solid #ECECEC;
}
.myBotton{
	font-size: 17px;
	width:120px;
	margin-left: 60px;
}
.warnning{
	color:#fa2150;
	padding:0 10px;
}
.line{
	height:2px;
	width:60px;
	margin:-2px auto;
	background-color: #479E47;
}
.giveNew{
	margin-left:20px;
	cursor: pointer;
}


</style>