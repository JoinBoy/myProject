<template>
    <div class="box">  
        <el-row>
            <!-- 左边盒子 -->
            <el-col :span="18">
                <el-card shadow="always" class="box-card">
                    <!-- 添加章节 -->
                    <el-row class="rowTitle" type="flex" align="middle">
                        <span class="el-icon-s-management iconSize"></span>
                        <div class="title">添加章节</div>
                    </el-row>
                    <el-row class="rowContent" >
                        <!-- 章节标题 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="top">
                            <el-col :span="4" class="bookFaceBoxTitle">章节标题:</el-col>
                            <el-col :span="20">
                                <el-input type="text" resize="none" clearable  v-model="chapterTitle" name="bookTitle" placeholder="建议您章节标题控制在15字之内"></el-input>
                                <div class="chapterTitleExplain">1、章节标题格式：第***章 章节名称(例：第1章 章节名称 或 第一章 章节名称)</br>
                                    2、章节名含有为谁加更的信息或与前一章章节序号不连续，都有可能会审核不通过
                                </div>
                            </el-col>
                        </el-row>
                        <!-- 标题附加词 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="middle">
                            <el-col :span="4" class="bookFaceBoxTitle">标题附加词:</el-col>
                            <el-col :span="20">
                                <el-input type="text" resize="none" clearable  v-model="chapterTitle" name="bookTitle" placeholder="如为某人加更(可不填)"></el-input>
                            </el-col>
                        </el-row>
                        <!-- 章节内容 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="top">
                            <el-col :span="4" class="bookFaceBoxTitle">内容:</el-col>
                            <el-col :span="20">
                                <el-input type="textarea" resize="none" rows="25" clearable  v-model="chapterTitle" name="bookTitle" placeholder="请填写章节内容"></el-input>
                            </el-col>
                        </el-row>
                        <!-- 推送简介 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="top">
                            <el-col :span="4" class="bookFaceBoxTitle">推送简介:</el-col>
                            <el-col :span="20">
                                <el-input type="textarea" resize="none" rows="3" maxlength="150" clearable  v-model="chapterTitle" name="bookTitle" placeholder="必填，审核通过后，该内容将会推送到已加入书架的用户的手机通知栏，写上用户感兴趣的内容能增加本章节的阅读量哦！不宜超过100字"></el-input>
                            </el-col>
                        </el-row>
                        <!-- 附加语 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="top">
                            <el-col :span="4" class="bookFaceBoxTitle">附加语:</el-col>
                            <el-col :span="20">
                                <el-input type="textarea" resize="none" rows="3" maxlength="300" clearable  v-model="chapterTitle" name="bookTitle" placeholder="请填写附加语，建议不超过200字"></el-input>
                            </el-col>
                        </el-row>
                    </el-row>
                    <el-button type="success" class="chapterBtn" round>发布</el-button>
                </el-card>
            </el-col>
            <!-- 右边盒子 -->
            <el-col :span="6">
                
            </el-col>
        </el-row>
        
    </div>
</template>

<script lang='ts'>
import {Component,Vue} from "vue-property-decorator";

@Component({
    name:'addChapter'
})
export default class AddChapter extends Vue{

    private chapterTitle:string = ''; //章节标题
}

</script>

<style lang="scss">
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
            padding-bottom:20px;
            .bookFaceBox{
                min-height:80px;
                width:100%;
                padding-top:20px;
                /* padding-bottom:20px; */
                .bookFaceBoxTitle{
                    text-align: right;
                    color: #666;
                    font-size: 14px;
                    font-weight:bold;
                }
                .chapterTitleExplain{
                    height:50px;
                    width:100%;
                    line-height: 25px;
                    color: #f60;
                    font-size: 12px;
                    text-align: left;
                }
            }
        }
        .chapterBtn{
            width: 100px;
            margin-top: 20px;
        }
    }
}

</style>