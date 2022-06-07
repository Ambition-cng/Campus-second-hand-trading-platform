<template>
    <el-card :body-style="{ padding: '0px' }" shadow="hover" id="commodity-card">
      <slot name="image"></slot>
      <div style="padding: 14px;">
        <span>商品：</span><slot name="header"></slot>
        <div class="bottom clearfix">
          <!-- <p class="sort_name">分类:<slot name="sort"></slot></p> -->
          <p class="price_name">价格为:<slot name="price"></slot></p>
          <p class="remark_name">备注:<slot name="remark"></slot></p>

        </div>
      </div>
    </el-card>
</template>


<style>
  .price_name{
    font-size: 10px;
  }
  .remark_name{
    font-size: 10px;
  }
  .sort_name{
    font-size: 12px;
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
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }

  .clearfix:after {
      clear: both
  }

  #commodity-card
  {
    margin-bottom: 20%;
  }
</style>


<script>
export default {
  name: 'CommodityBox',
  methods : {
    linkToCommodity(link){
      this.$router.push('/Commodity');
    }
  },
  data () {
    return {
      msg: '商品信息',
      src: 'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
      currentDate: new Date(),
      rouerLink: ''
    }
  }
}
</script>
