<template>
  <div class="task-list">
    <h1>任务列表</h1>
    
    <div class="filters">
      <button 
        v-for="filter in filters" 
        :key="filter"
        :class="{ active: activeFilter === filter }"
        @click="activeFilter = filter"
      >
        {{ filter }}
      </button>
    </div>

    <div class="tasks">
      <div v-for="task in filteredTasks" :key="task.id" class="task-item">
        <div class="task-info">
          <h3>{{ task.title }}</h3>
          <p>{{ task.description }}</p>
          <div class="task-details">
            <span>优先级: {{ task.priority }}</span>
            <span>截止日期: {{ task.dueDate }}</span>
          </div>
        </div>
        <div class="task-actions">
          <span :class="task.status" class="status">{{ task.status }}</span>
          <router-link :to="`/tasks/${task.id}`" class="detail-btn">详情</router-link>
        </div>
      </div>
    </div>

    <div class="empty-state" v-if="filteredTasks.length === 0">
      <p>暂无{{ activeFilter === '全部' ? '' : activeFilter }}任务</p>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'

const filters = ['全部', '进行中', '待处理', '已完成']
const activeFilter = ref('全部')

const tasks = [
  { id: 1, title: '项目需求分析', description: '完成新项目的需求文档编写', status: '进行中', priority: '高', dueDate: '2024-01-15' },
  { id: 2, title: '团队会议', description: '每周团队进度同步会议', status: '已完成', priority: '中', dueDate: '2024-01-10' },
  { id: 3, title: '代码审查', description: '审查同事提交的代码变更', status: '待处理', priority: '高', dueDate: '2024-01-12' },
  { id: 4, title: '用户界面设计', description: '设计新的用户界面原型', status: '进行中', priority: '中', dueDate: '2024-01-18' },
  { id: 5, title: '性能优化', description: '优化网站加载速度', status: '待处理', priority: '低', dueDate: '2024-01-20' },
  { id: 6, title: '文档编写', description: '编写项目技术文档', status: '已完成', priority: '中', dueDate: '2024-01-08' }
]

const filteredTasks = computed(() => {
  if (activeFilter.value === '全部') {
    return tasks
  }
  return tasks.filter(task => task.status === activeFilter.value)
})
</script>

<style scoped>
.task-list {
  padding: 2rem 0;
}

h1 {
  color: #2c3e50;
  margin-bottom: 1.5rem;
}

.filters {
  display: flex;
  gap: 0.5rem;
  margin-bottom: 2rem;
  flex-wrap: wrap;
}

.filters button {
  padding: 0.5rem 1rem;
  border: 1px solid #ddd;
  background: white;
  border-radius: 4px;
  cursor: pointer;
}

.filters button.active {
  background: #42b983;
  color: white;
  border-color: #42b983;
}

.tasks {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.task-item {
  background: white;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.task-info h3 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
}

.task-info p {
  color: #7f8c8d;
  margin-bottom: 0.5rem;
}

.task-details {
  display: flex;
  gap: 1rem;
  font-size: 0.875rem;
  color: #95a5a6;
}

.task-actions {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 0.5rem;
}

.status {
  padding: 0.25rem 0.75rem;
  border-radius: 4px;
  font-size: 0.875rem;
}

.进行中 { background: #fff3cd; color: #856404; }
.已完成 { background: #d4edda; color: #155724; }
.待处理 { background: #f8d7da; color: #721c24; }

.detail-btn {
  padding: 0.5rem 1rem;
  background: #3498db;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  font-size: 0.875rem;
}

.detail-btn:hover {
  background: #2980b9;
}

.empty-state {
  text-align: center;
  padding: 3rem;
  color: #95a5a6;
}

@media (max-width: 768px) {
  .task-item {
    flex-direction: column;
    align-items: flex-start;
    gap: 1rem;
  }
  
  .task-actions {
    flex-direction: row;
    align-items: center;
    width: 100%;
    justify-content: space-between;
  }
}
</style>