<template>
    <div class="headerbg">
        <div id="header">
            <img :src="imgUrl" alt="">
            <div class="inputSearch">
                <el-input placeholder="请输入内容" ref="input"  v-model="input3" @keyup.native.enter.exact="search">
                    <el-button slot="append" icon="el-icon-search" @click.native="search" ></el-button>
                </el-input>
            </div>
            
            <div class="header-right">
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                    <el-menu-item index="1">国内文学</el-menu-item>
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