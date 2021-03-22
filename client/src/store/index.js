import Vue from 'vue'
import Vuex from 'vuex'

import VuexPersist from 'vuex-persist'

const vuexPersist = new VuexPersist({
  key: 'farm',
  storage: localStorage,
})

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    authUser: null,
  },
  mutations: {
    authenticate (state, user) {
        state.authUser = user;
    },
    logout (state) {
        state.authUser = null;
    }
  },
  getters: {
      isAuthenticated: state => state.authUser !== null,
      currentUser: state => state.authUser
  },
  plugins: [vuexPersist.plugin]
})
