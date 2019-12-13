<template>
    <div>
        <router-view/>
    </div>
</template>

<script lang="ts">
import {Vue,Component} from "vue-property-decorator";

@Component({
    name:"my"
})
export default class My extends Vue{

}



</script>

<style lang="sass">

</style>