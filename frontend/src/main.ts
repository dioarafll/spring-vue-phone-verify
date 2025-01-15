


// main.ts
import { createApp } from 'vue';
import { createPinia } from 'pinia';
import piniaPersist from 'pinia-plugin-persistedstate';

import App from './App.vue';
import router from './routes';
import './style.css';

const pinia = createPinia();
const app = createApp(App);

pinia.use(piniaPersist);
app.use(router);
app.use(pinia);

app.mount('#app');
