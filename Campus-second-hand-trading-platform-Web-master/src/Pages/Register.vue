<template>
  <div>
    <el-form label-width="80px">
      <el-form-item label="uid">
        <el-input v-model="uid"></el-input>
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="username"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="password"></el-input>
      </el-form-item>
      <el-form-item label="电话号码">
        <el-input v-model="phone"></el-input>
      </el-form-item>
      <el-form-item label="学生序号">
        <el-input v-model="stuno"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="gender" placeholder="请选择你的性别">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>

      <el-button @click="Register">注册</el-button>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      uid: "",
      username: "",
      password: "",
      phone: "",
      stuno: "",
      gender: "",
    };
  },
  methods: {
    Register() {
      var that = this;
      let params = {
        uid: that.uid,
        username: that.username,
        password: that.password,
        phone: that.phone,
        stuno: that.stuno,
        gender: that.gender,
      };
      this.$axios.post("api/user/register", params).then(function (res) {
        // 注册成功
        if (res.data.code == 1) {
          that.$message({
            message: "恭喜你，账号注册成功!",
            type: "success",
          });
        }
        // 注册失败
        else if (res.data.code == 0) {
          that.$message.error(res.data.msg);
        }
      });
    },
  },
};
</script>

<style>
.label
{
  color: aliceblue;
}
</style>
