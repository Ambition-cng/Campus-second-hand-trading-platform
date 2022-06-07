<template>
  <div id="app">
    <el-container id="Site">
      <el-aside width="150px" height="100%" id="aside">
        <el-menu
          :default-active="$route.path"
          :router="true"
          class="el-menu-vertical-demo"
          background-color="#277365"
          text-color="#fff"
          active-text-color="#ffd04b"
        >
          <el-menu-item index="/">
            <i class="el-icon-s-home"></i>
            <span>首页</span>
          </el-menu-item>
          <el-menu-item index="/Login">
            <i class="el-icon-s-custom"></i>
            <span>登录</span>
          </el-menu-item>
          <el-menu-item index="/Register">
            <i class="el-icon-s-custom"></i>
            <span>注册</span>
          </el-menu-item>
          <el-menu-item index="/SelfSell">
            <i class="el-icon-s-custom"></i>
            <span>自己发布</span>
          </el-menu-item>
          <el-menu-item index="/SelfDemand">
            <i class="el-icon-s-custom"></i>
            <span>自己求购</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container id="Content">
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style>
#Site {
  display: row;
  background-color: #1d594e;
  height: 100%;
}
#Content {
  display: col;
  flex-wrap: wrap;
}

#aside {
  background-color: #1d594e;
  color: #e87343;
  text-align: center;
  line-height: 200px;
}
#app {
  height: 100%;
}
</style>
