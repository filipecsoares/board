<template>
  <div class="card-details" v-if="card">
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
    <div class="status">
      <span>Status: <strong>{{ card.blocked ? 'Blocked' : 'Active' }}</strong></span>
      <span v-if="card.blocked">Reason: {{ card.blockReason }}</span>
    </div>
    <div class="actions">
      <button v-if="!card.blocked" @click="blockCard">Block</button>
      <button v-if="card.blocked" @click="unblockCard">Unblock</button>
      <button @click="cancelCard">Cancel</button>
      <button @click="showReport = true">Report</button>
    </div>
    <div v-if="showBlockDialog" class="dialog">
      <h3>Block Card</h3>
      <input v-model="blockReason" placeholder="Reason for blocking" />
      <button @click="confirmBlock">Confirm</button>
      <button @click="showBlockDialog = false">Cancel</button>
    </div>
    <div v-if="showReport" class="dialog">
      <h3>Card Report</h3>
      <pre>{{ JSON.stringify(card, null, 2) }}</pre>
      <button @click="showReport = false">Close</button>
    </div>
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const route = useRoute();
const router = useRouter();
const cardId = route.params.id;
const card = ref<any>(null);
const showBlockDialog = ref(false);
const blockReason = ref('');
const showReport = ref(false);

onMounted(async () => {
  await fetchCard();
});

async function fetchCard() {
  try {
    const res = await axios.get(`/api/cards/${cardId}`);
    card.value = res.data;
  } catch (e) {
    console.error(e);
  }
}

async function blockCard() {
  showBlockDialog.value = true;
}

async function confirmBlock() {
  try {
    await axios.post(`/api/cards/${cardId}/block`, { reason: blockReason.value });
    showBlockDialog.value = false;
    blockReason.value = '';
    await fetchCard();
  } catch (e) {
    console.error(e);
  }
}

async function unblockCard() {
  try {
    await axios.post(`/api/cards/${cardId}/unblock`);
    await fetchCard();
  } catch (e) {
    console.error(e);
  }
}

async function cancelCard() {
  try {
    await axios.post(`/api/cards/${cardId}/cancel`);
    router.back();
  } catch (e) {
    console.error(e);
  }
}
</script>

<style scoped>
.card-details {
  padding: 2rem;
  max-width: 500px;
  margin: 0 auto;
  background: #f9f9f9;
  border-radius: 8px;
}
.status {
  margin: 1rem 0;
}
.actions button {
  margin-right: 1rem;
  margin-bottom: 1rem;
  padding: 0.5rem 1.2rem;
  border: none;
  border-radius: 4px;
  background: #1976d2;
  color: #fff;
  cursor: pointer;
}
.actions button:last-child {
  background: #757575;
}
.dialog {
  background: #fff;
  border: 1px solid #ddd;
  border-radius: 6px;
  padding: 1rem;
  margin-top: 1rem;
}
</style>
