

// src/routes.ts
import { createRouter, createWebHistory } from 'vue-router';

// Import views
import Home from './views/Home.vue';
import VerifyPhone from './views/VerifyPhone.vue';
import EnterOTP from './views/EnterOTP.vue';


const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home,
  },
  {
    path: '/',
    name: 'VerifyPhone',
    component: VerifyPhone,
    //   meta: { hideNavbar: true, hideFooter: true },
  },
  {
    path: '/verify',
    name: 'EnterOTP',
    component: EnterOTP,
    //   meta: { hideNavbar: true, hideFooter: true },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
