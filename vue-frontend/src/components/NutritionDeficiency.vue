<template>
    <div class = "container">

            <h1 class = "text-center"> Symptom List</h1>

            <table class = "table table-striped">
                <thead>
                    <tr>
                        <th><input type="checkbox" class="checkbox" :checked="allSelected" @click="selectAll"/></th>
                        <th> Symptom </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="symptom in symptoms" v-bind:key="symptom.id">
                        <td><input type="checkbox" class="checkbox" :value="symptom.symptom" v-model="selected"/></td>
                        <td> {{symptom.symptom }}</td>
                    </tr>
                </tbody>
            </table>
            <button v-on:click="submit">Submit</button>
        </div>
</template>

<script>
import SymptomService from '../services/SymptomService';
export default {
    name: 'Symptoms',
    data(){
        return {
            symptoms: [],
            selected: [],
            singleValue: String
        }
    },
    methods: {
        getSymptoms(){
            SymptomService.getSymptoms().then((response) => {
                this.symptoms = response.data;
            });
        },
        submit() {
            this.singleValue = this.selected[0];
            this.$router.push({path:'/symptomlist/symptom', query:{symptom: this.selected}});

        },
    },
    created() {
        this.getSymptoms();
    }
}
</script>