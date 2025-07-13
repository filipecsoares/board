<template>
  <div class="board-page">
    <h1>{{ board?.name || 'Board' }}</h1>
    <div class="columns">
      <div v-for="column in columns" :key="column.id" class="column">
        <h2>{{ column.name }}</h2>
        <div class="cards">
          <div v-for="card in column.cards" :key="card.id" class="card">
            <div class="card-title">{{ card.title }}</div>
            <div class="card-description">{{ card.description }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const boardId = route.params.id;
const board = ref<any>(null);
const columns = ref<any[]>([]);

onMounted(async () => {
  // Fetch board and columns/cards from API
  try {
    const boardRes = await axios.get(`/api/boards/${boardId}`);
    board.value = boardRes.data;
    const columnsRes = await axios.get(`/api/boards/${boardId}/columns`);
    columns.value = columnsRes.data;
    // Optionally, fetch cards for each column if not included
    // for (const column of columns.value) {
    //   const cardsRes = await axios.get(`/api/columns/${column.id}/cards`);
    //   column.cards = cardsRes.data;
    // }
  } catch (e) {
    // Handle error
    console.error(e);
  }
});
</script>

<style scoped>
.board-page {
  padding: 2rem;
}
.columns {
  display: flex;
  gap: 2rem;
}
.column {
  background: #f5f5f5;
  border-radius: 8px;
  padding: 1rem;
  min-width: 250px;
  flex: 1;
}
.cards {
  margin-top: 1rem;
}
.card {
  background: #fff;
  border-radius: 6px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.05);
  padding: 0.75rem;
  margin-bottom: 1rem;
}
.card-title {
  font-weight: bold;
}
.card-description {
  color: #666;
  font-size: 0.95em;
}
</style>
