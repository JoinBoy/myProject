<template>
    <div class="box">  
        <el-row>
            <!-- 左边盒子 -->
            <el-col :span="18">
                <el-card shadow="always" class="box-card">
                    <!-- 我的收藏 -->
                    <el-row class="rowTitle" type="flex" align="middle">
                        <span class="el-icon-star-on iconSize"></span>
                        <div class="title">我的收藏</div>
                    </el-row>
                    <el-row class="rowContent" type="flex" align="middle">
                        <div class="content">你还没有追过一本书</div>
                    </el-row>
                    <!-- 我写的书 -->
                    <el-row class="rowTitle" type="flex" align="middle">
                        <span class="el-icon-s-management iconSize"></span>
                        <div class="title">我写的书</div>
                        <el-button type="warning" class="btn" @click="goAddBook">写一本</el-button>
                    </el-row>
                    <el-row class="rowContent" type="flex" align="middle">
                        <div class="content">你还没有写过一本书</div>
                    </el-row>
                    <el-row class="rowContent" >
                        <div class="myBookBox">
                            <img src="https://b.heiyanimg.com/book/130173i.jpg@!bl?1" alt=""/>
                            <div class="bookTitle">青华</div>
                            <div class="bookSection"> 已更0章节 -1字 </div>
                            <div class="bookBtn">
                                <div class="bookBtnLeft" @click="goBookManage">作品管理</div>
                                <div class="bookBtnMiddle"></div>
                                <div class="bookBtnRight" @click="goAddChapter">新建章节</div>
                            </div>
                        </div>
                    </el-row>
                    <!-- 我的评论 -->
                    <el-row class="rowTitle" type="flex" align="middle">
                        <span class="el-icon-chat-line-round iconSize"></span>
                        <div class="title">我的评论</div>
                    </el-row>
                </el-card>
            </el-col>
            <!-- 右边盒子 -->
            <el-col :span="6">

            </el-col>
        </el-row>
        
    </div>
</template>

<script lang="ts">
import {Vue,Component} from "vue-property-decorator";

@Component({
    name:"myCenter"
})
export default class MyCenter extends Vue{


    goAddBook():void{
        this.$router.push('/addBook')
    }

    /*
    *  跳转新建章节
    */
    goAddChapter():void{
        this.$router.push('/addChapter')
    }

    /*
    *   跳转作品管理
    */
    goBookManage():void{
        this.$router.push('/bookManage')
    }
}



</script>

<style lang="scss" scoped>
.box{
    width:1000px;
    margin:auto;
    .box-card{
        .rowTitle{
            height:60px;
            border-bottom:1px solid #ccc;
            .iconSize{
                font-size:50px;
            }
            .title{
                font-size: 32px;
                font-weight: bold;
                margin-left:10px;
            }
            .btn{
                margin-left:10px;
            }
        }
        .rowContent{
            min-height:60px;
            border-bottom:1px solid #ccc;
            display: flex;
            flex-wrap: wrap;
            .content{
                font-size: 18px;
                color:#666;
            }
           
            .myBookBox{
                height:340px;
                width:160px;
                margin-top:20px;
                margin-right:17px;
                img{
                    height:222px;
                    width:160px;
                    margin-bottom:10px;
                }
                .bookTitle{
                    height:30px;
                    width:160px;
                    font-size: 14px;
                    font-weight: bold;
                    text-align: center;
                    line-height: 20px;
                    white-space: nowrap;
                    text-overflow: ellipsis;
                    overflow: hidden;
                    padding-bottom:10px;
                    color:#666;
                }
                .bookSection{
                    height:26px;
                    width:160px;
                    font-size: 12px;
                    font-weight: bold;
                    text-align: center;
                    line-height: 16px;
                    white-space: nowrap;
                    text-overflow: ellipsis;
                    overflow: hidden;
                    padding-bottom:10px;
                    color:#999;
                }
                .bookBtn{
                    height:20px;
                    width:160px;
                    display: flex;
                    font-size: 12px;
                    .bookBtnLeft{
                        width:70px;
                        height:20px;
                        text-align:right;
                        cursor:pointer;
                        line-height:20px;
                    }
                    .bookBtnMiddle{
                        border-right:1px solid #666;
                        height:20px;
                        margin-left:9px;
                        margin-right: 10px;
                    }
                    .bookBtnRight{
                        width:70px;
                        height:20px;
                        text-align:left;
                        cursor:pointer;
                        line-height:20px;
                    }
                }
            }
        }
    }
}

</style>