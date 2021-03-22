<template>
  <div class="accounts">
    <h2>{{ title }}</h2>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    title: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.accounts {
  width: 50%;
  height: 100vh;
  background: #e4fb8f;
  // background: #42b983;
  position: relative;
}
h2 { 
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: #42b983;
}
a {
  color: #42b983;
}
</style>
