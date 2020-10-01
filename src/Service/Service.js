import axios from 'axios'
import React from 'react'

const  GET_TODOS_URL =  'http://localhost:8080/todos'

class Service{
    getTodos(){
        return axios.get(GET_TODOS_URL);
    }
}

export default new Service();
