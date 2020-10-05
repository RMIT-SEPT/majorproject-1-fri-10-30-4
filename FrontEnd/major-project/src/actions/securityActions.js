import axios from "axios";
import {SET_CURRENT_USER} from "./types"
import setJwtToken from "../security/setJwtToken"
import jwt_decode from "jwt-decode"


export const login = (loginRequest, history) => async dispatch => {
    const response = await axios.post("http://localhost:8080/login", loginRequest);
    const {success} = response.data;
    if(success){
        const {token} = response.data;
        console.log(token);
        localStorage.setItem("jwtToken", token);
        setJwtToken(token);
        const decoded = jwt_decode(token);
        dispatch({
            type: SET_CURRENT_USER,
            payload: decoded
        })
        history.push("/")
    }
    

}