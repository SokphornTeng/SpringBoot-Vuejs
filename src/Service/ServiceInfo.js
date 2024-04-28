import axios from 'axios'

const INFO_URL = 'http://localhost:9090/api/info'

class ServiceInfo {
    getInfo(){
        return axios.get(INFO_URL)
    }
}

export default new ServiceInfo()