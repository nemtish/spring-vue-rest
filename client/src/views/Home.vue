<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <div v-if="isAuthenticated">
      <h2>Hello {{ currentUser.username }}</h2>
    </div>
    <div v-else>

      <h1>Farm App</h1>
      <h2>You can login as any user from <router-link to="/users">users</router-link> page</h2>

    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Home',
  computed: {
    ...mapGetters(['isAuthenticated', 'currentUser'])
  }
}
</script>
