import axios from 'axios';

const SYMPTOM_API_BASE_URL = '/symptomlist';

class SymptomService{

    getSymptoms(){
        return axios.get(SYMPTOM_API_BASE_URL);
    }

    findNutrientBySymptom(symptom) {
    console.log("Enters here");
        return axios.get(`/symptomlist`,{
            params: {
                symptom: symptom
            }
        });
      }
}

export default new SymptomService();