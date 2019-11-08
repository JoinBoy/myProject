import Vue from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store/store'

import VueResource from "vue-resource";
import ElementUI from 'element-ui'
import './styles.scss'
import axios from 'axios';

Vue.use(ElementUI)





Vue.config.productionTip = false;
Vue.use(VueResource);
(Vue as any).http.options.withCredentials  = true;
Vue.prototype.axios = axios;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
