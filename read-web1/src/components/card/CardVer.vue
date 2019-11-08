<template>
    <div class="cardBox_cardVer">
        <el-row :gutter="20" justify="center" type="flex" class="cardList"> 
            <el-col :span="4" v-for="(o, index) in 6" :key="o" >
                <el-card :body-style="{ padding: '0px',border:0 }" shadow="hover" class="shadowBox">
                    <div class="imageBox">
                        <img src="https://b.heiyanimg.com/book/44133.jpg@!bl?1" class="image">
                    </div>
                    <div style="" class="cardTitle">
                        <span>222222</span>
                        <div class="bottom clearfix">
                        <time class="time">11111111</time>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts">
    import {Component,Vue,Prop} from "vue-property-decorator"
    @Component
    export default class CardVer extends Vue{
       
        



    }

</script>

<style lang="scss" scoped>
        .cardBox_cardVer{
            width:1200px;
            margin:0 auto;
            cursor:pointer;
            .cardList{
                margin:20px 0;
                .shadowBox{
                    border:0;
                    overflow: visible;
                    .imageBox{
                        transition: All 0.2s ease-in-out;
                        -webkit-transition: All 0.2s ease-in-out;
                        -moz-transition: All 0.2s ease-in-out;
                        -o-transition: All 0.2s ease-in-out;
                        height:280px;
                        overflow:hidden;
                    }
                    .imageBox:hover{
                        height:280px;
                        overflow:hidden;
                        transform: translateY(-10px); 
                    }
                    .cardTitle{
                        padding: 14px; 
                        text-align: left;
                    }
                }
            }
        }       
    
    .time {
        font-size: 13px;
        color: #999;
      }
      
      .bottom {
        margin-top: 13px;
        line-height: 12px;
      }
    
      .image {
        width: 100%;
        display: block;
      }
    
      .clearfix:before,
      .clearfix:after {
          display: table;
          content: "";
      }
      
      .clearfix:after {
          clear: both
      }
    
    
    </style>