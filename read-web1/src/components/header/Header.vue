<template>
    <div class="headerbg">
        <div id="header">
            <img :src="imgUrl" alt="">
            <div class="registerImgBox" @click="register">
                <img class="registerImg" src="https://st.heiyanimg.com/_static/assets/avatar_300.png"></img>
            </div>
            <div class="inputSearch">
                <el-input placeholder="请输入内容" ref="input"  v-model="input3" @keyup.native.enter.exact="search">
                    <el-button slot="append" icon="el-icon-search" @click.native="search" ></el-button>
                </el-input>
            </div>
            
            <div class="header-right">
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" >
                    <el-menu-item index="333">国内文学</el-menu-item>
                    <el-menu-item index="2">英文文章</el-menu-item>
                </el-menu>
            </div>
        </div>
    </div>
    
</template>

<script lang="ts">
    import {Component,Vue} from "vue-property-decorator";
    import imgHeader  from '@/assets/headerLogo.png';
    @Component
    export default class Hearder extends Vue{
        private imgUrl:any = imgHeader;
        //导航栏默认选择
        private activeIndex:string =  '1';
        //输入框的值
        private input3:string = "";
        //导航栏选择触发方法
        // handleSelect(key, keyPath) {
        //     console.log(key, keyPath);
        // }
        //导航栏搜索
        search()  {
            
            console.log(this.input3)
        }
        /*
        *跳转注册登录界面
        */
        register():void{
            this.$router.push("/register")
        }
    }
</script>
<style lang="scss" scoped>
    .headerbg{
        border-bottom:1px solid #808080
    }
    #header{
        height:80px;
        width:1200px;
        margin:0 auto;
        img{
            height:80px;
            width:180px;
            float:left;
        }
        .registerImgBox{
            height:100%;
            width:80px;
            float:right;
            display:flex;
            align-items: center;
            cursor:pointer;
            justify-content: center;
            .registerImg{
                width: 40px;
                height:40px;
                float:right;
                border-radius: 100%;
            }
        }
        .inputSearch{
            width:300px;
            float:right;
            height:100%;
            display:flex;
            align-items: center;
        }
        .header-right{
            height:80px;
            width:400px;
            float:right;
        }
        .header-right .el-menu-demo{
            margin-top: 10px;
            border:0;
            .el-menu-item{
                font-size: 21px;
            }
        }
    }

</style>