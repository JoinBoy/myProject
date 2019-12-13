<template>
    <div class="box">  
        <el-row>
            <!-- 左边盒子 -->
            <el-col :span="18">
                <el-card shadow="always" class="box-card">
                    <!-- 我的收藏 -->
                    <el-row class="rowTitle" type="flex" align="middle">
                        <span class="el-icon-s-management iconSize"></span>
                        <div class="title">添加作品</div>
                    </el-row>
                    <el-row class="rowContent" >
                        <!-- 书籍封面 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' justify="start">
                            <el-col :span="4" class="bookFaceBoxTitle">封面:</el-col>
                            <el-col :span="20">
                                <img :src="img" alt=""/>
                                <div class="imgExplain">
                                    <div class="explainTitle">上传作品封面</div>
                                    <div class="explainContext">400*560像素</div>
                                    <div class="explainContext">小于1M</div>
                                    <div class="explainContext">格式为jpg,png,gif</div>
                                    <el-button type="info" round class="imgBtn" size="mini" @click="checkImg">上传图片</el-button>
                                    <input type="file" style="display:none" ref="imgInput" @change="inputChange($event)"/>
                                </div>
                            </el-col>
                        </el-row>
                        <!-- 书籍标题 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="middle">
                            <el-col :span="4" class="bookFaceBoxTitle">名称:</el-col>
                            <el-col :span="20">
                                <el-input type="text" clearable  v-model="bookTitle" name="bookTitle" placeholder="请填写书籍标题"></el-input>
                            </el-col>
                        </el-row>
                        <!-- 书籍分类 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="middle">
                            <el-col :span="4" class="bookFaceBoxTitle">分类:</el-col>
                            <el-col :span="6">
                                <el-select v-model="value" placeholder="请选择">
                                    <el-option
                                        v-for="item in options"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="6">
                                <el-select v-model="value" placeholder="请选择">
                                    <el-option
                                        v-for="item in options"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-col>
                            <el-col :span="6">
                                <el-select v-model="value" placeholder="请选择">
                                    <el-option
                                        v-for="item in options"
                                        :key="item.value"
                                        :label="item.label"
                                        :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-col>
                        </el-row>
                        <!-- 内容简介 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="top">
                            <el-col :span="4" class="bookFaceBoxTitle">内容简介:</el-col>
                            <el-col :span="20">
                                <el-input type="textarea" :rows="3" resize="none" clearable  v-model="bookTitle" name="bookTitle" placeholder="请填写内容简介"></el-input>
                            </el-col>
                        </el-row>
                        <!-- 互动信息 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="top">
                            <el-col :span="4" class="bookFaceBoxTitle">互动信息:</el-col>
                            <el-col :span="20">
                                <el-input type="textarea" :rows="3" resize="none" clearable  v-model="bookTitle" name="bookTitle" placeholder="请填写互动信息"></el-input>
                            </el-col>
                        </el-row>
                        <!-- 标签 -->
                        <el-row class='bookFaceBox' :gutter="20" type='flex' align="middle">
                            <el-col :span="4" class="bookFaceBoxTitle">标签:</el-col>
                            <el-col :span="8">
                                <el-select
                                v-model="value"
                                multiple
                                filterable
                                allow-create
                                default-first-option
                                placeholder="请选择文章标签">
                                    <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                                    </el-option>
                                </el-select>
                            </el-col>
                        </el-row>
                    </el-row>
                    <el-button type="success" round class="saveBtn">保存</el-button>
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
import img from "@/assets/images/my/addBook/readweb.png"

@Component({
    name:"addBook"
})
export default class AddBook extends Vue{
    private img:string = img; //默认图片
    private bookTitle:string = ''; //书籍标题
    private options = [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }];
    private value:string = '';

    /*
    *点击选择图片
    */
    checkImg():void{
        this.$refs.imgInput.click();
    }
    /*
    *input选择图片之后反显
    */
    inputChange(e):void{
        this.img = URL.createObjectURL(e.currentTarget.files[0]);
        var fromData = new FormData();
        fromData.append('file',e.currentTarget.files[0]);
        this.$http.post('http://192.168.1.168:8808/myProject/myCenter/addBook',fromData,{ headers: {
       'Content-Type': 'multipart/form-data'
   }}).then((res)=>{
            console.log(res)
        })
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
                img{
                    height:282px;
                    width:202px;
                    float:left;
                    margin-right:20px;

                }
                .imgExplain{
                    width:100px;
                    height:120px;
                    float:left;
                    margin-top:160px;
                    text-align:left;
                    .explainTitle{
                        height:19px;
                        font-size:14px;
                        color:#666;
                        font-weight:bold;
                        line-height:19px;
                    }
                    .explainContext{
                        height:19px;
                        font-size:12px;
                        color:#999;
                        font-weight:bold;
                        line-height:19px;
                    }
                    .imgBtn{
                        margin-top: 10px;
                    }
                }
            }
        }
        .saveBtn{
            margin-top:20px;
            width:200px;
        }
    }
}

</style>