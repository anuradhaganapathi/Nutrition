<template>
    <div class = "container">

            <h1 class = "text-center"> Nutrients List </h1>

                       <table class = "table table-striped">
                           <thead>
                               <tr>
                                   <th> Nutrient </th>
                                   <th> Count </th>
                               </tr>
                           </thead>
                           <tbody>
                               <tr v-for="(nutrient,count) in nutrients" v-bind:key="nutrient">
                                   <td> {{count }}</td>
                                   <td> {{nutrient }}</td>
                               </tr>
                           </tbody>
                       </table>
        </div>
</template>

<script>
import SymptomService from '../services/SymptomService';
export default {
    name: 'Nutrients',
    data(){
        return {
            nutrients: [],
            symptomlist: []
        }
    },
    methods: {
        getNutrientsFromSymptom(symptomlist){
            console.log("symptom" + symptomlist);
            SymptomService.getNutrientsFromSymptom(symptomlist).then((response) => {
            console.log("Response", response.data);
                this.nutrients = response.data;
            });
        }
    },
    created() {
        this.symptomlist = this.$route.query.symptom;
        this.getNutrientsFromSymptom(this.symptomlist);
    }
}
</script>
