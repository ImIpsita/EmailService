import axios from "axios"

const baseURL='http://localhost:9008/email'

export const customeAxios=axios.create({
    baseURL:baseURL,
    });
