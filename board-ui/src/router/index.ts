import type { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import BoardPage from '../views/BoardPage.vue';
import CardDetails from '../views/CardDetails.vue';
import { createRouter, createWebHashHistory } from 'vue-router';

const routes: RouteRecordRaw[] = [
  { path: '/', name: 'Home', component: HomePage },
  { path: '/boards/:id', name: 'Board', component: BoardPage },
  { path: '/cards/:id', name: 'CardDetails', component: CardDetails },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
