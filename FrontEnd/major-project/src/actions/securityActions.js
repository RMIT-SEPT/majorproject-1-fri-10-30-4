import axios from "axios";
import {ERROR, SET_CURRENT_USER} from "./types"
import setJwtToken from "../security/setJwtToken"
import jwt_decode from "jwt-decode"


export const login = (loginRequest, history) => async dispatch => {
    const data = JSON.stringify(loginRequest);
    const config = {
        headers: {'Content-Type': 'application/json'}
    }
    try {
        const response = await axios.post("http://localhost:8080/login", data, config);
        const {token} = response.data;
        console.log(token);
        localStorage.setItem("jwtToken", token);
        setJwtToken(token);
        const decoded = jwt_decode(token);
        dispatch({
            type: SET_CURRENT_USER,
            payload: decoded
        })
    } catch(error){
        
        dispatch({
            type: ERROR,
            payload: error.response.data
        })
      
    }

    
    

}