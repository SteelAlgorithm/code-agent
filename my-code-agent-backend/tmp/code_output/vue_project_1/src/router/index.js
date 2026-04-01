import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../pages/Home.vue'
import TaskList from '../pages/TaskList.vue'
import TaskDetail from '../pages/TaskDetail.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/tasks', component: TaskList },
  { path: '/tasks/:id', component: TaskDetail }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router