<template>
    <div class="navigation">
            <img src="data:image/gif;base64,R0lGODlhAwADAIABAL6+vv///yH5BAEAAAEALAAAAAADAAMAAAIDjA9WADs=" />
        <el-row :gutter="2" justify="center"  type="flex">
            <el-col :span="4">
                <a href="#guo">
                    <el-card shadow="hover" class="navItem">
                            国学经典
                    </el-card>
                </a>
            </el-col>
            <el-col :span="4">
                <a href="#wang">
                    <el-card shadow="hover" class="navItem">
                        网络小说
                    </el-card>
                </a>
                
            </el-col>
            <el-col :span="4">
                <el-card shadow="hover" class="navItem">
                    大神推荐
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card shadow="hover" class="navItem">
                    经典回顾
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card shadow="hover" class="navItem">
                    玄幻武侠
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts">
    import {Component,Vue} from "vue-property-decorator";
    export default class Navigation extends Vue{
        
    }
</script>

<style lang="scss" scoped>
    a{
        text-decoration:none;
    }
    .navigation{
        height:60px;
        margin:20px auto;
        width:1200px;
        .navItem{
            border:0;
            text-align:center;
            cursor:pointer;
        }
        .navItem:hover{
            border:0;
            text-align:center;
            color:#FF9137;
        }

    }
</style>