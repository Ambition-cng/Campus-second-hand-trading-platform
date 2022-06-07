// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from "vue";
import App from "./App";
import VueCookies from "vue-cookies";
import ElementUI from "element-ui";
import "element-ui/lib/theme-chalk/index.css";
import router from "./router";
import commodityBox from "./components/CommodityBox/CommodityBox.vue";

import axios from "axios";
import VueAxios from "vue-axios";
Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(VueCookies);
Vue.prototype.$cookie = VueCookies;
Vue.component("commodity-box", commodityBox);

Vue.use(VueAxios, axios);

const service = axios.create({
  //baseURL:"/api",
  timeout: 30000,
  headers: {}

});

Vue.prototype.$axios = service;

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  components: { App },
  template: "<App/>"
});
