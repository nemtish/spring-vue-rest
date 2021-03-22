<template>
  <div class="section" style="bgColor" :style="background">
    <h2 v-on:click="fetchApi">{{ title }}</h2>

    <div v-if="fetchedData">
      <div v-for="data in fetchedData" :key="data.id">
        <p>{{ data }}</p>
      </div>
    </div>
  </div>
</template>

<script>

import axios from 'axios';

export default {
  name: 'HelloWorld',
  props: {
    title: String,
    bgColor: String,
    fetchUrl: String
  },
  computed: {
    background() {
      let bg = this.bgColor || '#fff';
      return `background: ${bg}`;

    }
  },
  data () {
    return {
      fetchedData: null,
    }
  },
  methods: {
    fetchApi() {
      axios.get(this.fetchUrl).then((response) => {
        this.fetchedData = response.data;
      });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.section {
  width: 50%;
  height: 50vh;
  background: #e4fb8f;
  position: relative;
}
h2 { 
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  // color: #42b983;
  color: #565656;
}
a {
  color: #42b983;
}
</style>
