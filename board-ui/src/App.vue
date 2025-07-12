<script setup lang="ts">
</script>

<template>
  <div id="app">
    <header class="main-header">
      <h1>Card Board Manager</h1>
      <nav>
        <a href="#/">Home</a>
        <a href="#/boards">Boards</a>
      </nav>
    </header>
    <main>
      <router-view />
    </main>
  </div>
</template>

<style scoped>
#app {
  font-family: 'Segoe UI', Arial, sans-serif;
  background: #f8fafc;
  min-height: 100vh;
  color: #222;
}
.main-header {
  background: #0a2540;
  color: #fff;
  padding: 1.5rem 2rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.main-header h1 {
  margin: 0;
  font-size: 2rem;
  letter-spacing: 1px;
}
.main-header nav a {
  color: #fff;
  margin-left: 2rem;
  text-decoration: none;
  font-weight: 500;
  transition: color 0.2s;
}
.main-header nav a:hover {
  color: #3b82f6;
}
main {
  padding: 2rem;
}
</style>
