<template>
  <div class="login">
    <h1>Login</h1>
    <el-row type="flex" class="row-bg" justify="center">
        <el-col :span="12">
            <div class="grid-content bg-purple">
                <el-card class="box-card">
                    <el-form :model="loginForm" ref="loginForm" label-width="80px" class="demo-dynamic">
                        <el-form-item
                            prop="email"
                            label="Email"
                            :rules="[
                            { required: true, message: 'please input email address', trigger: 'blur' },
                            { type: 'email', message: 'please input correct email address', trigger: ['blur', 'change'] }
                            ]"
                        >
                            <el-input v-model="loginForm.email"></el-input>
                        </el-form-item>
                        <el-form-item
                            prop="password"
                            label="Password"
                            :rules="[
                            { required: true, message: 'please input your password', trigger: 'blur' },
                            ]"
                        >
                            <el-input type="password" v-model="loginForm.password" autocomplete="off"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="submitForm('loginForm')">Submit</el-button>
                            <el-button @click="resetForm('loginForm')">Reset</el-button>
                        </el-form-item>
                        </el-form>

                </el-card>
            </div>
        </el-col>
    </el-row>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Login',
    data() {
        return {
            loginForm: {
                email: '',
                password: ''
            }
        };
    },
    created () {
        let routeParams = this.$route.query || {};
        if (routeParams.username && routeParams.pass) {
            this.loginForm.email = routeParams.username;
            this.loginForm.password = routeParams.pass;
        }
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {

                    axios.post(`${process.env.VUE_APP_API_URL}/auth/login`, { username: this.loginForm.email, password: this.loginForm.password })
                    .then((resp) => {
                        let token = resp.data.token;
                        axios.defaults.headers.common = {'Authorization': `Bearer ${token}`}
                        this.$store.commit('authenticate', resp.data);
                        this.$router.push('/');
                    });
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}
</script>

<style lang="scss" scope>
  .text {
    font-size: 14px;
  }

  .item {
    padding: 18px 0;
  }

  .box-card {
    width: 100%;
  }
</style>
