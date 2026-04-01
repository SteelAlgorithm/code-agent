import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import Courses from '../pages/Courses.vue'
import Progress from '../pages/Progress.vue'
import Dashboard from '../pages/Dashboard.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/courses',
    name: 'Courses',
    component: Courses
  },
  {
    path: '/progress',
    name: 'Progress',
    component: Progress
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router