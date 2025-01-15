

<template>
  <section class="bg-blue-600 text-white text-center py-24 px-6">
    <h1 class="text-4xl font-bold mb-4">Welcome to My Blog</h1>
    <p class="text-lg mb-6">Your source for the latest posts and updates</p>

    <!-- Menampilkan counter -->
    <div class="mb-6">
      <h2 class="text-3xl">Counter: {{ counter.count }}</h2>
    </div>

    <!-- Tombol untuk increment, decrement dan reset -->
    <div class="space-x-4">
      <button
        class="bg-white text-blue-600 font-semibold py-2 px-6 rounded-lg hover:bg-blue-700 hover:text-white transition duration-300 flex items-center space-x-2"
        @click="counter.increment"
      >
        <span>Increment</span>
      </button>

      <button
        class="bg-white text-blue-600 font-semibold py-2 px-6 rounded-lg hover:bg-blue-700 hover:text-white transition duration-300 flex items-center space-x-2"
        @click="counter.decrement"
      >
        <span>Decrement</span>
      </button>

      <button
        class="bg-white text-blue-600 font-semibold py-2 px-6 rounded-lg hover:bg-blue-700 hover:text-white transition duration-300 flex items-center space-x-2"
        @click="counter.reset"
      >
        <span>Reset</span>
      </button>
    </div>
  </section>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { useCounterStore } from '../stores/counter';

export default defineComponent({
  name: 'Home',
  setup() {
    const counter = useCounterStore(); // Mengakses store counter
    return { counter };
  },
});
</script>

<style scoped>
/* Optional custom styles */
</style>
