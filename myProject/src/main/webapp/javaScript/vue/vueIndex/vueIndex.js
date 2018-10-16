/*创建vue对象*/
var app = new Vue({
	el:"#app",
	data:{
		list:{}, //初始化数据
		musicUrl:"",
		musicName:"",
		songerName:"",
	},
	methods:{
		getList:function(){
			this.$http.post("/myProject/getVueIndexList",{recommendSize:10,playSize:10},{emulateJSON:true}).then(
					(response)=>{
						if(response.body.code == 0){
							this.$data.list = response.body.list;
						}else{
							alert("请求失败");
						}
					},
					(response)=>{
						alert("请求失败");
					}
			
			)
		},
		play:function(e){
			this.$data.musicUrl = e.currentTarget.getAttribute("data-musicUrl");
			this.$data.musicName = e.currentTarget.getAttribute("data-musicName");
			this.$data.songerName = e.currentTarget.getAttribute("data-songerName");
		}
	},
	mounted:function(){
		this.getList();//初始化数据
	},
});