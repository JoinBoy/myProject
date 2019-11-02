<template>
    <div class="banner">
        <el-carousel height="350px">
            <el-carousel-item v-for="(item,index) in imgUrls" :key="index">
                <img :src="item" :alt="index" class="bannerImg">
            </el-carousel-item>
        </el-carousel>
    </div>
</template>

<script lang="ts">
    import {Component,Vue} from "vue-property-decorator"
    @Component
    export default class IndexBanner extends Vue{

        private imgUrls:string[] = [
            "https://b.heiyanimg.com/img/1567133673969_163828188.png",
            "https://b.heiyanimg.com/img/1567133648313_1126296998.png",
            "https://b.heiyanimg.com/img/1566270372124_1721523900.jpg"
        ]


    }
</script>

<style lang="scss" scoped>
    .banner{
        height:350px;
        width:1200px;
        margin:10px auto;
        .bannerImg{
            height:350px;
            width:100%;
        }

    }
    

</style>