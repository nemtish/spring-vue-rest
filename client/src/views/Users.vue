<template>
  <div class="users">

    <h1>Users</h1>
    <el-row :gutter="20" type="flex" class="row-bg" justify="center">
        <el-col :span="24">
            <div class="grid-content bg-purple">
                    <div v-for="user in users" :key="user.id">
                        <el-col :span="6">
                            <el-card class="box-card">
                                <p> ID: {{ user.id }} </p>
                                <p> Email: {{ user.username }} </p>
                                <router-link :to="`/login?username=${user.username}&pass=secret`">
                                  <el-button type="text">Login</el-button>
                                </router-link>
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
  name: 'Users',
  data () {
      return {
          users: null,
      }
  },
  created () {
      axios.get(`${process.env.VUE_APP_API_URL}/user`)
      .then((resp) => {
          this.users = resp.data;
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
    text-align: left;
  }
</style>
