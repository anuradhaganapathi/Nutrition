import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/symptomlist',
    name: 'SymptomList',
    component: () => import(/* webpackChunkName: "about" */ '../components/NutritionDeficiency.vue')
  },
  { name: 'nutrients', path: '/symptomlist/:symptom', component:  () => import("../components/Nutrients.vue")},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
