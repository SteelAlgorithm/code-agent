<template>
  <div id="app">
    <nav>
      <router-link to="/">首页</router-link>
      <router-link to="/tasks">任务列表</router-link>
    </nav>
    <main>
      <router-view />
    </main>
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#app {
  min-height: 100vh;
  background: #f5f5f5;
}

nav {
  background: #2c3e50;
  padding: 1rem;
  display: flex;
  gap: 2rem;
}

nav a {
  color: white;
  text-decoration: none;
  font-weight: bold;
}

nav a:hover {
  color: #42b983;
}

main {
  padding: 2rem;
  max-width: 1200px;
  margin: 0 auto;
}

@media (max-width: 768px) {
  main {
    padding: 1rem;
  }
  
  nav {
    flex-direction: column;
    gap: 1rem;
  }
}
</style>