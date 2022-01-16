import axios from 'axios';

const SYMPTOM_API_BASE_URL = '/symptomlist';

class SymptomService{

    getSymptoms(){
        return axios.get(SYMPTOM_API_BASE_URL);
    }

    getNutrientsFromSymptom(symptomlist) {
        console.log("Symptom" + symptomlist);
        return axios.get('/symptomlist/symptom?symptom=' + symptomlist);
    }
}

export default new SymptomService();