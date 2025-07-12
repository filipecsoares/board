<template>
  <section class="home">
    <h2>Welcome to Card Board Manager</h2>
    <p>Organize your boards, columns, and cards with ease.</p>
    <div class="actions">
      <router-link to="/boards" class="btn">Go to Boards</router-link>
    </div>
  </section>
</template>

<script setup lang="ts">
// No logic needed for static home page
</script>

<style scoped>
.home {
  max-width: 600px;
  margin: 4rem auto;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(10,37,64,0.08);
  padding: 2.5rem 2rem;
  text-align: center;
}
.home h2 {
  color: #0a2540;
  margin-bottom: 1rem;
}
.home .btn {
  display: inline-block;
  background: #3b82f6;
  color: #fff;
  padding: 0.75rem 2rem;
  border-radius: 6px;
  text-decoration: none;
  font-weight: 600;
  margin-top: 2rem;
  transition: background 0.2s;
}
.home .btn:hover {
  background: #2563eb;
}
</style>
