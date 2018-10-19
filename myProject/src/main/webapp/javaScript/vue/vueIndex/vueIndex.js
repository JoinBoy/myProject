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
			this.$http.post("/myProject/getVueIndexList",{recommendSize:10,playSize:10},{emulateJSON:true}).then(
					function(response){
						if(response.body.code == 0){
							this.$data.list = response.body.list;
							this.$data.userName = response.body.list.userName;
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
				var childList = this.$data.list[type];
				var index = childList.findIndex((value,index,childList)=>{
					return value.songerId == songerId;
				})
				var list = this.$data.list
				if(list[type][index].love == 1){
					list[type][index].love = 0;
				}else{
					list[type][index].love = 1;
				}				
				this.$data.list = list;
/*				app.$set(this.$data,"list",list);*/
				/*强制刷新，vue中v-for渲染改变数据 v-if不重新渲染页面的情况*/
                this.$forceUpdate()
			}else{
				window.location.href="/myProject/register";
			}
		}
	},
	mounted:function(){
		this.getList();//初始化数据
	},
});