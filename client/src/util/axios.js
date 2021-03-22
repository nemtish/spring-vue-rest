import axios from 'axios';
import store from '../store'

axios.defaults.baseURL = 'http://localhost:8080'
let currentUser = store.getters.currentUser;
if (currentUser && currentUser.token) {
    axios.defaults.headers.common = {'Authorization': `Bearer ${currentUser.token}`}
}

export default axios;