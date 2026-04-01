<template>
  <div class="task-detail">
    <router-link to="/tasks" class="back-btn">← 返回任务列表</router-link>
    
    <div class="task-header">
      <h1>{{ task.title }}</h1>
      <span :class="task.status" class="status">{{ task.status }}</span>
    </div>

    <div class="task-content">
      <div class="task-info">
        <div class="info-section">
          <h3>任务描述</h3>
          <p>{{ task.description }}</p>
        </div>

        <div class="info-section">
          <h3>详细信息</h3>
          <div class="details-grid">
            <div class="detail-item">
              <span class="label">优先级:</span>
              <span class="value">{{ task.priority }}</span>
            </div>
            <div class="detail-item">
              <span class="label">创建日期:</span>
              <span class="value">{{ task.createdDate }}</span>
            </div>
            <div class="detail-item">
              <span class="label">截止日期:</span>
              <span class="value">{{ task.dueDate }}</span>
            </div>
            <div class="detail-item">
              <span class="label">负责人:</span>
              <span class="value">{{ task.assignee }}</span>
            </div>
          </div>
        </div>

        <div class="info-section">
          <h3>任务进度</h3>
          <div class="progress-bar">
            <div class="progress" :style="{ width: task.progress + '%' }"></div>
          </div>
          <p class="progress-text">{{ task.progress }}% 已完成</p>
        </div>
      </div>

      <div class="task-actions-panel">
        <h3>操作</h3>
        <div class="action-buttons">
          <button @click="updateStatus('进行中')" class="action-btn primary">标记为进行中</button>
          <button @click="updateStatus('已完成')" class="action-btn success">标记为已完成</button>
          <button @click="deleteTask" class="action-btn danger">删除任务</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'

const route = useRoute()
const task = ref({
  id: 1,
  title: '项目需求分析',
  description: '完成新项目的需求文档编写，包括功能需求、非功能需求和用户故事。需要与产品经理和设计师进行多次沟通确认。',
  status: '进行中',
  priority: '高',
  createdDate: '2024-01-01',
  dueDate: '2024-01-15',
  assignee: '张三',
  progress: 60
})

onMounted(() => {
  const taskId = parseInt(route.params.id)
  // 这里可以根据任务ID从数据源获取任务详情
  console.log('加载任务ID:', taskId)
})

const updateStatus = (status) => {
  task.value.status = status
  alert(`任务状态已更新为: ${status}`)
}

const deleteTask = () => {
  if (confirm('确定要删除这个任务吗？')) {
    alert('任务已删除')
    // 这里可以添加删除逻辑
  }
}
</script>

<style scoped>
.task-detail {
  padding: 2rem 0;
}

.back-btn {
  display: inline-block;
  color: #3498db;
  text-decoration: none;
  margin-bottom: 1.5rem;
}

.back-btn:hover {
  text-decoration: underline;
}

.task-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}

.task-header h1 {
  color: #2c3e50;
  margin: 0;
}

.status {
  padding: 0.5rem 1rem;
  border-radius: 4px;
  font-weight: bold;
}

.进行中 { background: #fff3cd; color: #856404; }
.已完成 { background: #d4edda; color: #155724; }
.待处理 { background: #f8d7da; color: #721c24; }

.task-content {
  display: grid;
  grid-template-columns: 2fr 1fr;
  gap: 2rem;
}

.task-info {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.info-section {
  margin-bottom: 2rem;
}

.info-section:last-child {
  margin-bottom: 0;
}

.info-section h3 {
  color: #2c3e50;
  margin-bottom: 1rem;
}

.info-section p {
  color: #7f8c8d;
  line-height: 1.6;
}

.details-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1rem;
}

.detail-item {
  display: flex;
  flex-direction: column;
}

.label {
  color: #95a5a6;
  font-size: 0.875rem;
  margin-bottom: 0.25rem;
}

.value {
  color: #2c3e50;
  font-weight: 500;
}

.progress-bar {
  height: 8px;
  background: #ecf0f1;
  border-radius: 4px;
  overflow: hidden;
  margin: 1rem 0;
}

.progress {
  height: 100%;
  background: #42b983;
  transition: width 0.3s ease;
}

.progress-text {
  color: #2c3e50;
  font-weight: 500;
}

.task-actions-panel {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.task-actions-panel h3 {
  color: #2c3e50;
  margin-bottom: 1.5rem;
}

.action-buttons {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.action-btn {
  padding: 0.75rem 1.5rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-weight: 500;
  transition: background-color 0.3s ease;
}

.primary {
  background: #3498db;
  color: white;
}

.primary:hover {
  background: #2980b9;
}

.success {
  background: #42b983;
  color: white;
}

.success:hover {
  background: #3aa876;
}

.danger {
  background: #e74c3c;
  color: white;
}

.danger:hover {
  background: #c0392b;
}

@media (max-width: 768px) {
  .task-content {
    grid-template-columns: 1fr;
  }
  
  .task-header {
    flex-direction: column;
    align-items: flex-start;
    gap: 1rem;
  }
  
  .details-grid {
    grid-template-columns: 1fr;
  }
}
</style>