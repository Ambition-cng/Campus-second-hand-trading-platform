<template>
  <div id="info-pannel">
    <el-row id="img-slot">
        <el-card :body-style="{ padding: '0px' }" shadow="hover" id="info-card">
          <el-col :span="8" >
            <el-image id="commodity-img" :src="src" fit="fill"></el-image>
          </el-col>

          <el-col :span="12">
              <el-row>
                <div id="title">{{commodityName}}</div>
              </el-row>
              <el-row>
                <div id="sub-title">
                    {{sellerName}}
                </div>
              </el-row>
          </el-col>
        </el-card>
    </el-row>


    <el-row id="seller-info-table">
        <el-descriptions class="margin-top" title="发布者信息" :column="3" id="des-title">
            <el-descriptions-item label="用户名">kooriookami</el-descriptions-item>
            <el-descriptions-item label="手机号">18100000000</el-descriptions-item>
            <el-descriptions-item label="居住地">苏州市</el-descriptions-item>
            <el-descriptions-item label="备注">
            <el-tag size="small">学校</el-tag>
            </el-descriptions-item>
            <el-descriptions-item label="联系地址">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
        </el-descriptions>
    </el-row>

    <el-row>
      <h1 id="comment-title">评论</h1>
    </el-row>

    <el-row id="comment-box">
      <el-input
        type="textarea"
        :autosize="{ minRows: 2, maxRows: 4}"
        placeholder="请输入内容"
        v-model="comment">
      </el-input>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'CommodityBox',
  data () {
    return {
      commodityName: '七层皇堡',
      sellerName: 'xyf@XDU',
      comment: "",
      src: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png'
    }
  }
}

</script>

<style>
#info-pannel
{
    height: 800px;
}
#info-msg
{
    background-color: #f29f05;
    border-radius: 20px;
    margin-top: 2%;
    margin-left: 5%;
}
.el-image
{
    height: 100%;
    width: 100%;
    padding-bottom: 0%;
    display: block !important;
}
#title
{
    font-size: big;
    text-align: center;
    color: #277365;
    padding-top: 5%;
    padding-bottom: 5%;
}
#sub-title
{
    text-align: center;
    font-size: small;

    padding-top: 15%;
    padding-bottom: 15%;
}
#seller-info
{
    background-color: #f28705;
    padding-top: 5%;
    padding-bottom: 5%;
    border-bottom-left-radius: 20px;
    border-bottom-right-radius: 20px;
}
#seller-avatar
{
    padding-top: 3%;
    padding-bottom: 3%;
}
#seller-name
{
    padding-top: 10%;
    padding-bottom: 10%;
    color: white;
}
#seller-info-table
{
    margin-top: 4%;
}
#des-title
{
    color: aliceblue;
}
#comment-title
{
    color: aliceblue;
}
#comment-box
{
    margin-top: 0%;
}
</style>