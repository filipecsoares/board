<script setup lang="ts">
import { ref } from 'vue'

interface Board {
  id: number
  name: string
}

const boards = ref<Board[]>([])
const newBoardName = ref('')
const selectedBoardId = ref<number | null>(null)
let nextId = 1

function addBoard() {
  const name = newBoardName.value.trim()
  if (!name) return
  boards.value.push({ id: nextId++, name })
  newBoardName.value = ''
}

function selectBoard(id: number) {
  selectedBoardId.value = id
}

function deleteBoard(id: number) {
  boards.value = boards.value.filter(b => b.id !== id)
  if (selectedBoardId.value === id) selectedBoardId.value = null
}
</script>

<template>
  <div class="board-list">
    <h2>Boards</h2>
    <form @submit.prevent="addBoard" class="board-form">
      <input v-model="newBoardName" placeholder="New board name" />
      <button type="submit">+</button>
    </form>
    <ul>
      <li v-for="board in boards" :key="board.id" :class="{ selected: board.id === selectedBoardId }">
        <span @click="selectBoard(board.id)">{{ board.name || 'Untitled' }}</span>
        <button class="delete" @click="deleteBoard(board.id)">×</button>
      </li>
    </ul>
    <div v-if="selectedBoardId" class="selected-board">
      <p>Selected: <strong>{{ boards.find(b => b.id === selectedBoardId)?.name }}</strong></p>
    </div>
  </div>
</template>

<style scoped>
.board-list {
  max-width: 340px;
  margin: 3rem auto;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 16px 0 rgba(0,0,0,0.04);
  padding: 2rem 1.5rem 1.5rem 1.5rem;
}
h2 {
  font-size: 1.3rem;
  font-weight: 600;
  margin-bottom: 1.2rem;
  letter-spacing: 0.01em;
}
.board-form {
  display: flex;
  gap: 0.5rem;
  margin-bottom: 1.2rem;
}
.board-form input {
  flex: 1;
  border: none;
  border-bottom: 1.5px solid #ddd;
  font-size: 1rem;
  padding: 0.4rem 0.2rem;
  outline: none;
  background: transparent;
  transition: border 0.2s;
}
.board-form input:focus {
  border-bottom: 1.5px solid #888;
}
.board-form button {
  background: #222;
  color: #fff;
  border: none;
  border-radius: 50%;
  width: 2rem;
  height: 2rem;
  font-size: 1.2rem;
  cursor: pointer;
  transition: background 0.2s;
}
.board-form button:hover {
  background: #444;
}
ul {
  list-style: none;
  padding: 0;
  margin: 0;
}
li {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0.5rem 0.2rem;
  border-radius: 6px;
  transition: background 0.15s;
  cursor: pointer;
}
li.selected {
  background: #f0f4fa;
}
li span {
  flex: 1;
  font-size: 1rem;
  padding-left: 0.2rem;
}
button.delete {
  background: none;
  border: none;
  color: #bbb;
  font-size: 1.1rem;
  margin-left: 0.5rem;
  cursor: pointer;
  border-radius: 50%;
  transition: color 0.2s, background 0.2s;
}
button.delete:hover {
  color: #e74c3c;
  background: #fbeaea;
}
.selected-board {
  margin-top: 1.5rem;
  text-align: center;
  color: #444;
  font-size: 1.05rem;
}
</style>
