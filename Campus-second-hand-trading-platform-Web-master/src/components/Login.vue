<template>
  <div>
    <el-container id="login-page">
      <el-header id="Loginheader">已登录用户:{{ loginUsername }}</el-header>
      <el-main id="login-content">
        <el-collapse-transition>
          <div v-show="unfold">
            <div id="DropDownPanel">
              <el-avatar icon="el-icon-user-solid" id="Avatar"></el-avatar>
              <div class="FirstInfoBox">
                <el-row>
                  <el-col :span="4"> uid: </el-col>
                  <el-col :span="20">
                    <el-input
                      class="Input"
                      v-model="uid"
                      placeholder="uid"
                    ></el-input>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="4"> 密码： </el-col>
                  <el-col :span="20">
                    <el-input
                      class="Input"
                      v-model="password"
                      placeholder="密码"
                      show-password
                    ></el-input>
                  </el-col>
                </el-row>
              </div>
              <el-button @click="Login">登录</el-button>
            </div>
          </div>
        </el-collapse-transition>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      unfold: false,
      uid: "",
      password: "",
    };
  },
  mounted() {
    this.unfold = true;
  },
  computed: {
    loginUsername() {
      let userUid = this.$cookie.get("Uid");
      if (userUid !== null) {
        return userUid;
      } else {
        return "无";
      }
    },
  },
  methods: {
    Login: function () {
      var that = this;

      let params = {
        uid: that.uid,
        password: that.password,
      };
      this.$axios
        .post(`api/user/login?uid=${that.uid}&password=${that.password}`)
        .then((res) => {
          console.log(res);

          // 登陆成功
          if (res.data.code == 1) {
            that.$cookie.set("Uid", res.data.data.uid);
            that.$cookie.set("Username", res.data.data.username);
            that.$message({
              message: "登录成功!",
              type: "success",
            });
            // 登陆失败
          } else if (res.data.code == 0) {
            that.$message.error(res.data.msg);
          }
        });
    },
  },
};
</script>

<style>
#login-page {
  height: 800px;
}
#Loginheader {
  line-height: 60px;
  text-align: center;
  border-radius: 30px;
  color: white;
  background-color: #277365;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
#login-content {
  height: 100%;
  line-height: 60px;
}
#DropDownPanel {
  text-align: center;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.3);
  background-color: #277365;
  border-radius: 20px;
  height: 300px;
}
#Avatar {
  height: 13%;
  margin-top: 2%;
}
.FirstInfoBox {
  color: white;
  height: 20px;
  text-align: left;
  margin-left: 40px;
  margin-right: 40px;
}
.Input {
}
</style>
