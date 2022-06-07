<template>
  <div>
    <el-container id="background">
      <el-header id="header">
         <el-row :gutter="20">
          <el-col :span="9">
              <el-input
                placeholder="请输入商品名"
                prefix-icon="el-icon-search"
                id="searchBox"
                v-model="itemName"
              >
              </el-input>
          </el-col>
           <el-col :span="3">
             <el-button icon="el-icon-search" circle @click="search"></el-button>
           </el-col>
           <!-- <el-col :span="9">
             <el-input
               placeholder="请输入类型"
               prefix-icon="el-icon-search"
               id="sortBox"
               v-model="itemSort"
             >
             </el-input>
           </el-col>

          <el-col :span="1">
            <el-button icon="el-icon-search" circle @click="sort"></el-button>
          </el-col> -->
        </el-row>
      </el-header>


      <el-main id="content">
          <el-row :gutter='20'>
            <el-col :span="6" v-for="(item,i) in list" :key="i">
              <commodity-box>
                <img  class="commodity_image" slot='image' :src="list[i].image">
                <span slot="header">{{ item.itemname }}</span>
                <span class="commodity_price" slot="price">{{item.price}}</span>
                <span slot="remark">{{item.remark}}</span>
                <!-- <span slot="sort">{{item.sort}}</span> -->
              </commodity-box>
            </el-col>

          </el-row>




      </el-main>

    </el-container>
  </div>
</template>

<script>


export default {
  name: 'Homepage',
  data () {
    return {
      msg: 'XDU二手交易平台',
      itemName:'',
      itemSort:'',
      list:''
    }
  },
  methods: {
    search() {
      var that = this;
      this.list = '';
      this.$axios
        .get(`api/item/getItemByName?itemName=${that.itemName}`
        ).then((res) => {
        // 搜索成功
        if (res.data.code == 1) {

          that.list = res.data.data
          console.log(that.list);
        }
        // 搜索失败
        else if (res.data.code == 0) {
          that.$message.error(res.data.msg);
        }
      });
    },
    sort() {
      var that = this;
      this.list = '';
      this.$axios
        .get(`api/item/getItemByCategory?category=${that.itemSort}`
        ).then((res) => {
        // 搜索成功
        if (res.data.code == 1) {

          that.list = res.data.data
          console.log(that.list);
        }
        // 搜索失败
        else if (res.data.code == 0) {
          that.$message.error(res.data.msg);
        }
      });
    }
  },
  created(){
    var that = this
    this.$axios.get('api/item/getAllItem').then(res =>{
      if(res.data.code ==1 ){
        that.list = res.data.data
        console.log(this.list)
      }
      else if(res.data.code == 0){
        console.log('error')
      }
    })
  }
}
</script>

<style>
#header
{
  text-align: center;
  background-color: #277365;
  color: rgb(255, 255, 255);
  font-size: large;
  border-radius: 30px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  line-height: 60px;
  margin-top: 2%;
  margin-left: 2%;
  margin-right: 2%;
}
#background
{
  text-align: center;
  background-color: #1d594e;
  min-height: 700px;
}
#searchBox
{
  border-radius: 30px;
}
#content
{
  text-align: center;
  margin-top: 2%;
  margin-left: 2%;
  margin-right: 2%;
  margin-bottom: 2%;
  border-radius: 20px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  height: 100%;
  background-color: #277365;
}
.commodity_price{
  font-size: 16px;
}
.commodity_image{
  height: 200px;
  width: 100%;
  display: block;
}
</style>
