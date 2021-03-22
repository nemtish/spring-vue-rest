<template>
  <div class="customers">
    <h1>Customers</h1>
    <el-row :gutter="20" type="flex" class="row-bg" justify="center">
        <el-col :span="24">
            <div class="grid-content bg-purple">
                <div v-for="c in customers" :key="c.id">
                        <el-col :span="6">
                            <el-card class="box-card">
                                <p> ID: {{ c.id }} </p>
                                <p> Name: {{ c.firstName }} {{ c.lastName }} </p>
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
  name: 'Customers',
  data () {
      return {
          customers: null,
      }
  },
  created () {
    axios.get('http://localhost:8080/api/v1/customer')
    .then((resp) => {
        this.customers = resp.data;
    });
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
