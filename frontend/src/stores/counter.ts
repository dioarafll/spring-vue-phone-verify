

import { defineStore } from 'pinia';

// Mendefinisikan tipe state
interface CounterState {
  count: number;
}

export const useCounterStore = defineStore('counter', {
  state: (): CounterState => ({
    count: 0,
  }),
  actions: {
    increment(): void {
      this.count++;
    },
    decrement(): void {
      this.count--;
    },
    reset(): void {
      this.count = 0;
    },
  },
});
