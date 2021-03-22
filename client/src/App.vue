<template>
  <div id="app">
    <div id="nav">
      <el-row type="flex" class="row-bg" justify="space-between">
        <el-col :span="6">
          <div v-if="authorised" class="grid-content bg-purple">
            <router-link to="/accounts">Accounts</router-link> |
            <router-link to="/farms">Farms</router-link>
          </div>
          <div v-if="!authorised" class="grid-content bg-purple">
            <router-link to="/">Home</router-link> |
            <router-link to="/customers">Customers</router-link> |
            <router-link to="/users">Users</router-link>
          </div>
        </el-col>
        <el-col :span="6">
          <div class="grid-content bg-purple">
            <router-link v-if="authorised" @click.native="authUser = null" to="/">Logout</router-link>
          </div>
        </el-col>
      </el-row>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'Home',
  computed: {
    authUser: {
      get () {
        return this.$store.authUser;
      },
      set (value) {
        this.$store.commit('authenticate', value);
      }
    },
    authorised() {
      return this.$store.getters.isAuthenticated;
    }
  }
}
</script>


<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
