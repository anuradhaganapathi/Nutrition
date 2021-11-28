import axios from 'axios';

const SYMPTOM_API_BASE_URL = '/symptomlist';

class SymptomService{

    getSymptoms(){
        return axios.get(SYMPTOM_API_BASE_URL);
    }
}

export default new SymptomService();