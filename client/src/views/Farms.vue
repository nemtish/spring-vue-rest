<template>
  <div class="customers">
    <h1>Farms</h1>
    <el-row :gutter="20" type="flex" class="row-bg" justify="center">
        <el-col :span="24">
            <div class="grid-content bg-purple">
                <div v-for="f in farms" :key="f.id">
                        <el-col :span="6">
                            <el-card class="box-card">
                                <p> ID: {{ f.id }} </p>
                                <p> Farm: {{ f.name }}</p>
                            </el-card>
                        </el-col>
                    </div>
            </div>
        </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from '../util/axios';

export default {
  name: 'Farms',
  data () {
      return {
          farms: null,
      }
  },
  created () {
    axios.get(`${process.env.VUE_APP_API_URL}/farm`)
    .then((resp) => {
        this.farms = resp.data;
    }).catch((err) => {
        if (err.response.data.status === 401) {
          this.$router.push('/');
        }
    })
  }
}
</script>

<style lang="scss" scope>
  .text {
    font-size: 14px;
  }

  .box-card {
    width: 100%;
  }
</style>
