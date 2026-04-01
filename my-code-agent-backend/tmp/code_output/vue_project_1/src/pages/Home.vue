<template>
  <div class="home">
    <h1>任务记录管理系统</h1>
    <p class="subtitle">高效管理您的日常任务和工作计划</p>
    
    <div class="stats">
      <div class="stat-card">
        <h3>今日任务</h3>
        <p class="number">3</p>
        <p>待完成</p>
      </div>
      <div class="stat-card">
        <h3>本周完成</h3>
        <p class="number">12</p>
        <p>已处理</p>
      </div>
      <div class="stat-card">
        <h3>进行中</h3>
        <p class="number">5</p>
        <p>任务</p>
      </div>
    </div>

    <div class="quick-actions">
      <h2>快速操作</h2>
      <div class="actions">
        <router-link to="/tasks" class="action-btn">查看所有任务</router-link>
        <button class="action-btn" @click="addTask">添加新任务</button>
      </div>
    </div>

    <div class="recent-tasks">
      <h2>最近任务</h2>
      <div class="task-grid">
        <div v-for="task in recentTasks" :key="task.id" class="task-card">
          <h3>{{ task.title }}</h3>
          <p>{{ task.description }}</p>
          <div class="task-meta">
            <span :class="task.status">{{ task.status }}</span>
            <span>{{ task.date }}</span>
          </div>
          <router-link :to="`/tasks/${task.id}`" class="view-btn">查看详情</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
const recentTasks = [
  { id: 1, title: '项目需求分析', description: '完成新项目的需求文档编写', status: '进行中', date: '今天' },
  { id: 2, title: '团队会议', description: '每周团队进度同步会议', status: '已完成', date: '昨天' },
  { id: 3, title: '代码审查', description: '审查同事提交的代码变更', status: '待处理', date: '明天' }
]

const addTask = () => {
  alert('添加新任务功能')
}
</script>

<style scoped>
.home {
  padding: 2rem 0;
}

h1 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
}

.subtitle {
  color: #7f8c8d;
  margin-bottom: 2rem;
}

.stats {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1rem;
  margin: 2rem 0;
}

.stat-card {
  background: white;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
  text-align: center;
}

.stat-card h3 {
  color: #7f8c8d;
  margin-bottom: 0.5rem;
}

.number {
  font-size: 2rem;
  font-weight: bold;
  color: #2c3e50;
  margin: 0.5rem 0;
}

.quick-actions {
  background: white;
  padding: 1.5rem;
  border-radius: 8px;
  margin: 2rem 0;
}

.actions {
  display: flex;
  gap: 1rem;
  margin-top: 1rem;
}

.action-btn {
  padding: 0.75rem 1.5rem;
  background: #42b983;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-decoration: none;
  display: inline-block;
}

.action-btn:hover {
  background: #3aa876;
}

.recent-tasks {
  margin-top: 2rem;
}

.task-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 1rem;
  margin-top: 1rem;
}

.task-card {
  background: white;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.task-card h3 {
  color: #2c3e50;
  margin-bottom: 0.5rem;
}

.task-card p {
  color: #7f8c8d;
  margin-bottom: 1rem;
}

.task-meta {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
}

.task-meta span {
  padding: 0.25rem 0.5rem;
  border-radius: 4px;
  font-size: 0.875rem;
}

.进行中 { background: #fff3cd; color: #856404; }
.已完成 { background: #d4edda; color: #155724; }
.待处理 { background: #f8d7da; color: #721c24; }

.view-btn {
  display: inline-block;
  padding: 0.5rem 1rem;
  background: #3498db;
  color: white;
  text-decoration: none;
  border-radius: 4px;
  font-size: 0.875rem;
}

.view-btn:hover {
  background: #2980b9;
}

@media (max-width: 768px) {
  .stats {
    grid-template-columns: 1fr;
  }
  
  .actions {
    flex-direction: column;
  }
  
  .task-grid {
    grid-template-columns: 1fr;
  }
}
</style>