<template>
  <div id="app">
    <header class="header">
      <div class="container">
        <div class="logo">
          <img src="https://dashscope-result-wlcb-acdr-1.oss-cn-wulanchabu-acdr-1.aliyuncs.com/1d/11/20260331/bf68d313/058d1bdf-9e91-412f-9ccc-46a63b7541661628321029.png?Expires=1775047002&OSSAccessKeyId=LTAI5tKPD3TMqf2Lna1fASuh&Signature=Uz6whFbeJzsMK4TIhMdG6cxmWTk%3D" alt="EduTrack Logo" class="logo-img">
          <h1 class="logo-text">EduTrack</h1>
        </div>
        <nav class="nav">
          <router-link to="/" class="nav-link">首页</router-link>
          <router-link to="/courses" class="nav-link">课程中心</router-link>
          <router-link to="/progress" class="nav-link">学习进度</router-link>
          <router-link to="/dashboard" class="nav-link">学习面板</router-link>
          <div class="user-info">
            <span class="username">张明</span>
            <div class="avatar">
              <i class="fas fa-user"></i>
            </div>
          </div>
        </nav>
        <button class="mobile-menu-btn" @click="toggleMobileMenu">
          <i class="fas fa-bars"></i>
        </button>
      </div>
      <div class="mobile-nav" :class="{ 'active': mobileMenuOpen }">
        <router-link to="/" class="mobile-nav-link" @click="closeMobileMenu">首页</router-link>
        <router-link to="/courses" class="mobile-nav-link" @click="closeMobileMenu">课程中心</router-link>
        <router-link to="/progress" class="mobile-nav-link" @click="closeMobileMenu">学习进度</router-link>
        <router-link to="/dashboard" class="mobile-nav-link" @click="closeMobileMenu">学习面板</router-link>
      </div>
    </header>
    <main class="main-content">
      <router-view></router-view>
    </main>
    <footer class="footer">
      <div class="container">
        <div class="footer-content">
          <div class="footer-section">
            <h3>关于 EduTrack</h3>
            <p>领先的在线教育平台，专注于提供高质量的课程内容和学习进度跟踪服务。</p>
          </div>
          <div class="footer-section">
            <h3>联系我们</h3>
            <p>邮箱: contact@edutrack.com</p>
            <p>电话: 400-123-4567</p>
          </div>
          <div class="footer-section">
            <h3>关注我们</h3>
            <div class="social-links">
              <a href="#"><i class="fab fa-weixin"></i></a>
              <a href="#"><i class="fab fa-weibo"></i></a>
              <a href="#"><i class="fab fa-zhihu"></i></a>
            </div>
          </div>
        </div>
        <div class="copyright">
          <p>&copy; 2024 EduTrack 在线教育平台. 保留所有权利.</p>
        </div>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const mobileMenuOpen = ref(false)

const toggleMobileMenu = () => {
  mobileMenuOpen.value = !mobileMenuOpen.value
}

const closeMobileMenu = () => {
  mobileMenuOpen.value = false
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: 'Segoe UI', 'Microsoft YaHei', sans-serif;
  line-height: 1.6;
  color: #333;
  background-color: #f8f9fa;
}

#app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

.header {
  background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
  color: white;
  padding: 1rem 0;
  position: sticky;
  top: 0;
  z-index: 1000;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.header .container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  display: flex;
  align-items: center;
  gap: 10px;
}

.logo-img {
  height: 40px;
  width: auto;
}

.logo-text {
  font-size: 1.5rem;
  font-weight: 700;
  color: white;
}

.nav {
  display: flex;
  align-items: center;
  gap: 2rem;
}

.nav-link {
  color: rgba(255, 255, 255, 0.9);
  text-decoration: none;
  font-weight: 500;
  transition: color 0.3s;
  padding: 0.5rem 0;
  position: relative;
}

.nav-link:hover,
.nav-link.router-link-active {
  color: white;
}

.nav-link.router-link-active::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 2px;
  background-color: white;
}

.user-info {
  display: flex;
  align-items: center;
  gap: 0.75rem;
  margin-left: 1rem;
}

.username {
  font-size: 0.9rem;
}

.avatar {
  width: 36px;
  height: 36px;
  background-color: rgba(255, 255, 255, 0.2);
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

.mobile-menu-btn {
  display: none;
  background: none;
  border: none;
  color: white;
  font-size: 1.5rem;
  cursor: pointer;
  padding: 0.5rem;
}

.mobile-nav {
  display: none;
  flex-direction: column;
  background: #2a5298;
  padding: 1rem;
}

.mobile-nav.active {
  display: flex;
}

.mobile-nav-link {
  color: white;
  text-decoration: none;
  padding: 0.75rem 1rem;
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
}

.mobile-nav-link:hover {
  background-color: rgba(255, 255, 255, 0.1);
}

.main-content {
  flex: 1;
  padding: 2rem 0;
}

.footer {
  background: linear-gradient(135deg, #1a1a2e 0%, #16213e 100%);
  color: white;
  padding: 2rem 0;
  margin-top: auto;
}

.footer-content {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 2rem;
  margin-bottom: 2rem;
}

.footer-section h3 {
  margin-bottom: 1rem;
  color: #4dabf7;
}

.footer-section p {
  color: rgba(255, 255, 255, 0.8);
  line-height: 1.6;
}

.social-links {
  display: flex;
  gap: 1rem;
  font-size: 1.5rem;
}

.social-links a {
  color: rgba(255, 255, 255, 0.8);
  transition: color 0.3s;
}

.social-links a:hover {
  color: #4dabf7;
}

.copyright {
  text-align: center;
  padding-top: 1rem;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
  color: rgba(255, 255, 255, 0.6);
}

@media (max-width: 768px) {
  .nav {
    display: none;
  }
  
  .mobile-menu-btn {
    display: block;
  }
  
  .header .container {
    padding: 0 15px;
  }
  
  .footer-content {
    grid-template-columns: 1fr;
  }
  
  .main-content {
    padding: 1rem 0;
  }
}

@media (max-width: 480px) {
  .logo-text {
    font-size: 1.2rem;
  }
  
  .container {
    padding: 0 10px;
  }
}
</style>