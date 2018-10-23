/*创建vue对象*/
var app = new Vue({
	el:"#app",
	data:{
		list:{}, //初始化数据
		musicUrl:"",
		musicName:"",
		songerName:"",
		userName:"",
	},
	methods:{
		getList:function(){
			this.$http.post("/myProject/vueMyMusic/getList",{page:1},{emulateJSON:true}).then(
					function(response){
						if(response.body.code == 0){
							if(response.body.list.userName){
								this.$data.list = response.body.list;
								this.$data.userName = response.body.list.userName;
							}else{
								window.location.href="/myProject/register";
							}
							
						}else{
							alert("请求失败");
						}
					},
					function(response){
						alert("请求失败");
					}
			
			)
		},
		play:function(e){
			this.$data.musicUrl = e.currentTarget.getAttribute("data-musicUrl");
			this.$data.musicName = e.currentTarget.getAttribute("data-musicName");
			this.$data.songerName = e.currentTarget.getAttribute("data-songerName");
		},
		//点击喜欢
		addLove:function(e){
			if(this.$data.userName){
				var songerId = $(e.currentTarget).data("songerid");
				var type = e.currentTarget.getAttribute("data-type");
				var flag = e.currentTarget.getAttribute("data-flag");
				var childList = this.$data.list[type];
				var index = childList.findIndex((value,index,childList)=>{
					return value.songerId == songerId;
				})
				var list = this.$data.list
				if(flag == 1){
					this.$http.post("/myProject/vueLove/addLove",
							{id:songerId},{emulateJSON:true}).then((response)=>{
						if(response.body.code ==0){							
							list[type][index].love = 1;			
							this.$data.list = list;
							/*app.$set(this.$data,"list",list);*/
							/*强制刷新，vue中v-for渲染改变数据 v-if不重新渲染页面的情况*/
			                this.$forceUpdate()
						}else{
							alert("失败重新点击");
						}
					},(response)=>{
						alert("失败重新点击");
					});	
				}else if(flag == 0){
					this.$http.post("/myProject/vueLove/removeLove",
							{id:songerId},{emulateJSON:true}).then((response)=>{
						if(response.body.code ==0){
							list[type][index].love = 0;
							this.$data.list = list;
							/*app.$set(this.$data,"list",list);*/
							/*强制刷新，vue中v-for渲染改变数据 v-if不重新渲染页面的情况*/
			                this.$forceUpdate()
						}else{
							alert("失败重新点击");
						}
					},(response)=>{
						alert("失败重新点击");
					});	
					
					
				}
				
				
			}else{
				window.location.href="/myProject/register";
			}
		},
		/*点击注销*/
		logout:function(){
			this.$http.post("/myProject/logout").then((response)=>{
				if(response.body.code == 0){
					window.location.reload();
				}else{
					alert("注销失败！");
				}
			},(response)=>{
				alert("注销失败！");
			})
		}
	},
	mounted:function(){
		this.getList();//初始化数据
	},
});