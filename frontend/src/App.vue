

// src/App.vue
<template>
  <div id="app">
    <index />    
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import index from './layouts/index.vue';

export default defineComponent({
  name: 'App',
  components: {
    index,
  },
});
</script>

<style>
/* Gaya global bisa diletakkan di sini atau di file CSS terpisah */
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto,
    'Helvetica Neue', Arial, sans-serif;
}
</style>
