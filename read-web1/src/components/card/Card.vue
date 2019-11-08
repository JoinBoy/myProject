<template>
    <div class="cardBox">
        <el-row :gutter="20" justify="center" type="flex" class="cardList"> 
            <el-col :span="4" v-for="(o, index) in 6" :key="o" >
                <el-card :body-style="{ padding: '0px',border:0 }" shadow="hover" class="shadowBox">
                    <div class="imageBox">
                        <img src="https://b.heiyanimg.com/book/44133.jpg@!bl?1" class="image">
                    </div>
                    <div style="" class="cardTitle">
                        <span>22222</span>
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
    import {Component,Vue} from "vue-property-decorator";
    @Component
    export default class Card extends Vue{
        
    }

</script>

<style lang="scss" scoped>

    @keyframes myScale{
        0%{
            transform:scale(1);
        }
        100%{
            transform:scale(1.2);
        }
    }
    @-webkit-keyframes myScale{
        0%{
            transform:scale(1);
        }
        100%{
            transform:scale(1.2);
        }
    }

    
    .cardBox{
        width:1200px;
        margin:0 auto;
        cursor:pointer;
        .cardList{
            margin:20px 0;
            .shadowBox{
                border:0;
                .imageBox{
                    height:280px;
                    overflow:hidden;
                    .image:hover{
                        animation:myScale 0.2s ;
                        animation-fill-mode:forwards;
                    }
                   
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