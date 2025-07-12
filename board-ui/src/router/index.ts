import type { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import { createRouter, createWebHashHistory } from 'vue-router';

const routes: RouteRecordRaw[] = [
  { path: '/', name: 'Home', component: HomePage },
  // { path: '/boards', name: 'Boards', component: BoardPage },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
