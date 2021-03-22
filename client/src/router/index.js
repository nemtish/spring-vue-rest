
import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Users from '../views/Users.vue'
import Accounts from '../views/Accounts.vue'
import Farms from '../views/Farms.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/customers',
    name: 'Customers',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Customers.vue')
  },
  {
    path: '/users',
    name: 'Users',
    component: Users
  },
  {
    path: '/accounts',
    name: 'Accounts',
    component: Accounts
  },
  {
    path: '/farms',
    name: 'Farms',
    component: Farms
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
