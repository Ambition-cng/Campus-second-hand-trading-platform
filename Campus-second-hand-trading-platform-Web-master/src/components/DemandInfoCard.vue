<template>
  <el-card :body-style="{ padding: '10px' }" style="margin: 20px">
    <img :src="itemInfo.image" alt="无图片" class="itemInfo.image" />
    <div style="padding: 14px">
      <div>
        物品名:{{ itemInfo.itemname }} 物品id:{{ itemInfo.itemid }} 物品类别:{{
          itemInfo.sort
        }}
      </div>
      <div>物品备注:{{ itemInfo.remark }}</div>
      <div>物品价格:{{ itemInfo.price }} 物品数:{{ itemInfo.count }}</div>

      <div class="bottom clearfix">
        <el-button type="text" class="button" @click="DeleteDemand"
          >删除求购商品</el-button
        >
                <el-input v-model="comment"></el-input>
        <el-button type="text" class="button" @click="AddComment"
          >评论商品</el-button
        >

        <div v-for="(comment,index) in commentList"
        :key="index">
          <el-divider>评论<i class="el-icon-s-comment"></i></el-divider>
        <el-badge :value="comment.content" class="item"  type="warning">
          <el-button size="small"><i class="el-icon-user-solid"></i>网友{{comment.commentid}}</el-button>
        </el-badge>
         <el-button type="danger" icon="el-icon-delete" class="deleteBtn" @click="DeleteComment(comment.commentid)" circle></el-button>
        </div>

      </div>
    </div>
  </el-card>
</template>

<script>
export default {
    data() {
    return {
      comment: "",
      commentList:[]
    };
  },
  mounted(){
    this.GetAllComments();
  },
  props: {
    itemInfo: {
      type: Object,
      default() {
        return {
          description: "no description",
        };
      },
    },
  },
  methods: {
    DeleteDemand: function () {
      var that = this;

      this.$axios
        .delete(`api/item/deleteReItem?itemId=${that.itemInfo.itemid}`)
        .then((res) => {
          console.log(res);

          // 删除成功
          if (res.data.code == 1) {
            that.$message({
              message: "恭喜你!删除求购成功！",
              type: "success",
            });
            // 删除失败
          } else if (res.data.code == 0) {
            that.$message.error(res.data.msg);
          }
        });
    },
    
    AddComment: function () {
      var that = this;

      let params = {
        itemid: that.itemInfo.itemid,
        content:that.comment
      };

      this.$axios.post("api/comment/wantItem", params).then(function (res) {
        // 注册成功
        if (res.data.code == 1) {
          that.$message({
            message: "恭喜你，评论发布成功!",
            type: "success",
          });
          console.log(res.data);
           that.comment = "";
          that.GetAllComments();
        }
        // 注册失败
        else if (res.data.code == 0) {
          that.$message.error(res.data.msg);
        }
      });
    },

      DeleteComment: function (commentid) {
      var that = this;

      this.$axios.delete(`api/comment/deleteWantItemComment?commentId=${commentid}`).then((res) => {
        // 获取成功
        if (res.data.code == 1) {
            that.$message({
              message: "恭喜你!控评成功！",
              type: "success",
            });
          this.GetAllComments();
        } else if (res.data.code == 0) {
          that.$message.error(res.data.msg);
        }
      });


    },

    GetAllComments: function () {
      var that = this;

      let params = {
        itemId: that.itemInfo.itemid,
      };

      this.$axios.get(`api/comment/getWantItemCommentById?itemId=${that.itemInfo.itemid}`).then((res) => {
        // 获取成功
        if (res.data.code == 1) {
          console.log(res);
          that.commentList = res.data.data;
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
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 20%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}
.deleteBtn {
  position:absolute;
  right:80px;
}
</style>