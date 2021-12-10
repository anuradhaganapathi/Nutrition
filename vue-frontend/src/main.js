import {createApp} from 'vue';
import App from './App.vue';
import PrimeVue from 'primevue/config';
import Dialog from 'primevue/dialog';
import 'bootstrap/dist/css/bootstrap.min.css';
const app = createApp(App);

app.use(PrimeVue);

app.component('Dialog', Dialog);

createApp(App).mount('#app')
