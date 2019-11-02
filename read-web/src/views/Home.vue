<template>
  <div class="home">
      
    <IndexBanner/>
    <Navigation></Navigation>
    <Card/>
    <div class="indexMidTitle" id="guo">国学经典</div>
    <CardVer/>
    <div class="indexMidTitle" id="wang">网络小说</div>
    <Card/>
    <Footer/>
  </div>
</template>

<script>
// @ is an alias to /src
import IndexBanner from '@/components/banner/IndexBanner.vue';
import Navigation from"@/components/navigation/Navigation.vue";
import Card from "@/components/card/Card.vue";
import CardVer from "@/components/card/CardVer.vue";
import Footer from "@/components/footer/Footer.vue";

export default {
  name: 'home',
  components: {
    IndexBanner,
    Navigation,
    Card,
    CardVer,
    Footer
  }
}
</script>

<style lang="scss">
  .indexMidTitle{
    height:80px;
    margin:20px auto;
    width:1200px;
    line-height:80px;
    text-align: center;
    font-size:32px;
    font-weight: bold;
    color:#E3734F;
  }

</style>
