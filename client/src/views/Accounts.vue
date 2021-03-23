<template>
  <div class="customers">
    <h1>Accounts</h1>
    <el-row :gutter="20" type="flex" class="row-bg" justify="center">
        <el-col :span="24">
            <div class="grid-content bg-purple">
                <div v-for="a in accounts" :key="a.id">
                        <el-col :span="6">
                            <el-card class="box-card">
                                <p> ID: {{ a.id }} </p>
                                <p>Account for: </p>
                                <p> Customer: {{ a.customer.firstName }} {{ a.customer.lastName }} </p>
                                <p> Farm: {{ a.farm.name }}</p>
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
  name: 'Accounts',
  data () {
      return {
          accounts: null,
      }
  },
  created () {
    axios.get(`${process.env.VUE_APP_API_URL}/account`)
    .then((resp) => {
        this.accounts = resp.data;
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
