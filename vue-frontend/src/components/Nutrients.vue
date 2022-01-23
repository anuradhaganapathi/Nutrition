<template>
    <div ref = "content">

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

        <button @click="download">Download PDF</button>
</template>

<script>
import html2pdf from 'html2pdf.js';
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
        },
        download() {
            console.log("Enters here");
            html2pdf(this.$refs.content, {
                margin: 1,
                filename: 'document.pdf',
                image: { type: 'jpeg', quality: 0.98 },
                html2canvas: { dpi: 192, letterRendering: true },
                jsPDF: { unit: 'in', format: 'letter', orientation: 'landscape' }
            })
        },
    },
    created() {
        this.symptomlist = this.$route.query.symptom;
        this.getNutrientsFromSymptom(this.symptomlist);
    }
}
</script>
