<template>
  <div>
    <el-form label-width="80px">
      <el-form-item label="物品名">
        <el-input v-model="itemname"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="remark"></el-input>
      </el-form-item>
      <el-form-item label="价格">
        <el-input v-model="price"></el-input>
      </el-form-item>
      <el-form-item label="电话号码">
        <el-input v-model="sort"></el-input>
      </el-form-item>
      <el-form-item label="数量">
        <el-input v-model="count"></el-input>
      </el-form-item>
      <el-form-item label="图片url">
        <el-input v-model="image"></el-input>
      </el-form-item>
      <el-button @click="Publish">发布</el-button>
    </el-form>

    <item-info-card
      v-for="(item, index) in itemList"
      :key="index"
      :itemInfo="item"
    ></item-info-card>
  </div>
</template>

<script>
import ItemInfoCard from "../components/ItemInfoCard.vue";

export default {
  components: { ItemInfoCard },
  data() {
    return {
      itemname: "",
      remark: "",
      price: "",
      sort: "",
      count: "",
      image: "",
      itemList: [],
    };
  },
  mounted() {
    this.GetAllPublishes();
  },
  methods: {
    Publish() {
      var that = this;
      let params = {
        uid: that.$cookie.get("Uid"),
        username: that.$cookie.get("Username"),
        itemname: that.itemname,
        remark: that.remark,
        price: that.price,
        sort: that.price,
        count: that.count,
        image: that.image,
      };

      // 用户未登录
      if (params.uid == null || params.username == null) {
        that.$message.error("用户未登录");
      }

      this.$axios.post("api/item/publish", params).then(function (res) {
        console.log(res);
        // 注册成功
        if (res.data.code == 1) {
          that.GetAllPublishes();
          that.$message({
            message: "恭喜你，商品发布成功!",
            type: "success",
          });
        } else {
          that.$message.error(res.data.msg);
        }
      });
    },
    GetAllPublishes() {
      var that = this;
      let uid = that.$cookie.get("Uid");
      this.$axios.get(`api/item/getItemList?uid=${uid}`).then((res) => {
        console.log(res);

        // 获取成功
        if (res.data.code == 1) {
          that.itemList = res.data.data;
          that.$message({
            message: "已发布商品刷新成功!",
            type: "success",
          });
          // 获取失败
        } else if (res.data.code == 0) {
          that.$message.error(res.data.msg);
        }
      });
    },
  },
};
</script>

<style>
</style>