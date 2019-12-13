<template>
    <div class="box">  
        <el-row>
            <!-- 左边盒子 -->
            <el-col :span="18">
                <el-card shadow="always" class="box-card">
                    <!-- 我的收藏 -->
                    <el-row class="rowTitle" type="flex" align="middle">
                        <span class="el-icon-s-management iconSize"></span>
                        <div class="title">作品管理</div>
                    </el-row>
                    <el-row class="rowContent" >
                        <div class="content">
                            <img :src="img" alt=""/>
                        </div>
                        <div class="title">青华</div>
                        <div class="titleContent">青华</div>
                        <div class='faceEdit'>修改作品信息</div>
                    </el-row>
                    <div>
                        <el-row class="chapterManager" type="flex" align="middle">
                            <div class="title">章节管理</div>
                            <div class="BtnTitle">移动章节</div>
                            <el-switch
                                v-model="value"
                                active-color="#13ce66"
                                inactive-color="#ff4949"
                                active-value="100"
                                inactive-value="0"
                                @change="switchChange">
                            </el-switch>
                        </el-row>
                        <el-row class="reelTitle" type="flex" align='middle'>
                            <el-col :span='6' class="reelTitleLeft">
                                <div class="titleLeft">卷</div>
                                <el-button type="info" class="leftBtn" size="mini">添加卷</el-button>
                            </el-col>
                            <el-col :span='18'>
                                <el-button type="warning" size="mini" class="rightBtn">新建章节</el-button>
                            </el-col>
                        </el-row>
                        <el-row class="reelTitleItem" type="flex" align='middle'>
                            <el-col :span='6' class="reelTitleLeftItem">
                                
                            </el-col>
                            <el-col :span='18'>
                               
                            </el-col>
                        </el-row>
                    </div>
                    
                </el-card>
            </el-col>
            <!-- 右边盒子 -->
            <el-col :span="6">

            </el-col>
        </el-row>
        
    </div>
</template>

<script lang="ts">
import {Component,Vue} from 'vue-property-decorator';
import img from '@/assets/images/my/addBook/readweb.png'
@Component({
    name:'bookManage'
})
export default class BookManage extends Vue{
    private value:boolean = false;
    private img:string = img;

    switchChange():void{
        console.log(this.value)
    }
}
</script>

<style lang='scss'>
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
        }
        .rowContent{
            min-height:60px;
            border-bottom:1px solid #ccc;
            padding:20px 0;
            .content{
                height:243px;
                width:154px;
                background-color:green;
                font-size: 18px;
                color:#666;
                padding-right:30px;
                float:left;
                img{
                    height:176px;
                    width:124px;
                }
            }
            .title{
                height: 31px;
                width:550px;
                float:right;
                color: #333;
                font-size: 16px;
                font-weight: 700;
                text-align: left;
                line-height: 31px;
            }
            .titleContent{
                height:63px;
                width:550px;
                margin: 10px 0 20px 0;
                line-height: 1.8em;
                color: #999;
                word-wrap: break-word;
                word-break: break-all;
                font-size: 12px;
                float:right;
                text-align: left;
            }
            .faceEdit{
                height:19px;
                width:84px;
                color: #0a8abf;
                font-size: 14px;
                float:right;
                cursor:pointer;
            }
        }
        .chapterManager{
            height:49px;
            background-color:#666;
            .title{
                padding-left: 15px;
                font-size: 20px;
                height:26px;
                line-height:26px;
                width:95px;
                color:#fff;
            }
            .BtnTitle{
                font-size:12px;
                color:#fff;
                margin-left:480px;
                margin-right:20px;
            }
        }
        .reelTitle{
            height:30px;
            background-color:#BFBFBF;
            .reelTitleLeft{
                border-right:1px solid #f5f5f5;
                .titleLeft{
                    width:20px;
                    height:28px;
                    vertical-align:middle;
                    text-align:left;
                    float:left;
                    line-height:28px;
                    margin-left:15px;
                }
                .leftBtn{
                    margin-left:70px;
                }
            }
            .rightBtn{
                margin-left:400px;
            }
        }
        .reelTitleItem{
            height:400px;
            background-color:#f8f8f8;
            .reelTitleLeftItem{
                height:400px;
                border-right:1px solid #dadada;
            }
        }
    }
}

</style>