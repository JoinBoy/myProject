import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import VueResource from "vue-resource";
import  'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.use(VueResource);
(Vue as any).http.options.withCredentials  = true;
Vue.prototype.axios = axios;


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
