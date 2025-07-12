<template>
  <section class="home">
    <h2>Boards</h2>
    <form @submit.prevent="createBoard">
      <input v-model="newBoardName" type="text" placeholder="Board name" required />
      <button type="submit">Create Board</button>
    </form>
    <ul class="board-list">
      <li v-if="boards.length === 0" class="empty">Empty</li>
      <li v-for="board in boards" :key="board.id">
        <span>{{ board.name }}</span>
        <button @click="deleteBoard(board.id)">Delete</button>
      </li>
    </ul>
  </section>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import axios from 'axios';

interface Board {
  id: number;
  name: string;
}

const boards = ref<Board[]>([]);
const newBoardName = ref('');

const fetchBoards = async () => {
  try {
    const res = await axios.get<Board[]>('/api/boards');
    console.log('Fetched boards:', res.data);
    boards.value = res.data;
  } catch (error) {
    console.error('Failed to fetch boards:', error);
  }
};

const createBoard = async () => {
  if (!newBoardName.value.trim()) return;
  const res = await axios.post<Board>('/api/boards', { name: newBoardName.value });
  boards.value.push(res.data);
  newBoardName.value = '';
};

const deleteBoard = async (id: number) => {
  await axios.delete(`/api/boards/${id}`);
  boards.value = boards.value.filter(b => b.id !== id);
};

onMounted(fetchBoards);
</script>

<style scoped>
.home {
  max-width: 600px;
  margin: 4rem auto;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(10,37,64,0.08);
  padding: 2.5rem 2rem;
}
form {
  display: flex;
  gap: 1rem;
  margin-bottom: 2rem;
}
input[type="text"] {
  flex: 1;
  padding: 0.5rem;
  border: 1px solid #cbd5e1;
  border-radius: 4px;
}
button {
  background: #3b82f6;
  color: #fff;
  border: none;
  padding: 0.5rem 1.5rem;
  border-radius: 4px;
  cursor: pointer;
  font-weight: 600;
  transition: background 0.2s;
}
button:hover {
  background: #2563eb;
}
.board-list {
  list-style: none;
  padding: 0;
}
.board-list li {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0.75rem 0;
  border-bottom: 1px solid #e5e7eb;
}
.empty {
  color: #888;
  text-align: center;
  padding: 2rem 0;
}
</style>
