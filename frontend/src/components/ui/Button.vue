

<template>
  <button
    :type="type"
    class="w-full py-2 px-4 bg-indigo-600 text-white rounded-lg btn focus:outline-none hover:bg-indigo-800 focus:ring-4 focus:ring-indigo-300"
  >
    <slot />
  </button>
</template>

<script lang="ts">
import { defineComponent, PropType } from 'vue';

export default defineComponent({
  name: 'Button',
  props: {
    /**
     * The type of the button (e.g., submit, button, reset).
     * @default 'submit'
     */
    type: {
      type: String as PropType<'submit' | 'button' | 'reset'>,
      default: 'submit',
    },
  },
});
</script>
