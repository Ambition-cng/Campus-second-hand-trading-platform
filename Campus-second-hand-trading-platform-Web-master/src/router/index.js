import Vue from "vue";
import Router from "vue-router";
import Homepage from "@/components/Homepage";
import Login from "@/components/Login";
import CommodityInfo from "../components/CommodityBox/CommodityInfo.vue";

import Register from "@/Pages/Register";
import SelfSell from "@/Pages/SelfSell";
import SelfDemand from "@/Pages/selfDemand";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "Homepage",
      component: Homepage
    },
    {
      path: "/Login",
      name: "Login",
      component: Login
    },
    {
      path: "/Register",
      name: "Register",
      component: Register
    },
    {
      path: "/SelfSell",
      name: "SelfSell",
      component: SelfSell
    },
    {
      path: "/SelfDemand",
      name: "SelfDemand",
      component: SelfDemand
    },

    {
      path: "/Commodity",
      name: "CommodityInfo",
      component: CommodityInfo
    }
  ]
});
