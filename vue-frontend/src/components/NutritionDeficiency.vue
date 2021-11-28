<template>
    <div class = "container">

            <h1 class = "text-center"> Symptom List</h1>

            <table class = "table table-striped">
                <thead>
                    <tr>
                        <th> Id</th>
                        <th> Symptom </th>
                        <th> Nutrient </th>
                    </tr>

                </thead>
                <tbody>
                    <tr v-for="symptom in symptoms" v-bind:key="symptom.id">
                        <td> {{symptom.id }}</td>
                        <td> {{symptom.symptom }}</td>
                        <td> {{symptom.nutrient}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
</template>

<script>

import SymptomService from '../services/SymptomService';

export default {
    name: 'Symptoms',
    data(){
        return {
            symptoms: []
        }
    },
    methods: {
        getSymptoms(){
            SymptomService.getSymptoms().then((response) => {
                this.symptoms = response.data;
            });
        }
    },
    created() {
        this.getSymptoms();
    }
}

</script>