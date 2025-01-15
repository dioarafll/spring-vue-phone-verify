

<template>
  <input
    :type="type"
    :id="id"
    :name="name"
    :placeholder="placeholder"
    :maxlength="maxlength"
    :class="`mt-1 block ${w} px-4 py-2 border border-gray-300 rounded-lg focus:ring-indigo-500 focus:border-indigo-500`"
    required
  />
</template>

<script lang="ts">
import { defineComponent, PropType } from 'vue';

export default defineComponent({
  name: 'Input',
  props: {
    /**
     * The width class for the input.
     * @default 'w-full'
     */
    w: {
      type: String,
      default: 'w-full',
    },
    /**
     * The type of the input (e.g., text, email, password).
     * @default 'text'
     */
    type: {
      type: String as PropType<string>,
      default: 'text',
    },
    /**
     * The id of the input element.
     */
    id: {
      type: String,
      required: true,
    },
    /**
     * The name of the input element.
     */
    name: {
      type: String,
      required: true,
    },
    /**
     * The placeholder text for the input.
     */
    placeholder: {
      type: String,
      default: '',
    },
    /**
     * The maxlength PIN/OTP
     */
    maxlength: {
      type: Number as PropType<number>,
      default: null,
    },
  },
});
</script>
