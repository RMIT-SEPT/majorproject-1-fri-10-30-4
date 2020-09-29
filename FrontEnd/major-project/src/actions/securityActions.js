import axios from "axios";
import {SET_CURRENT_USER} from "./types"
import setJwtToken from "../security/setJwtToken"
import jwt_decode from "jwt-decode"


export const login = (loginRequest, history) => async dispatch => {
    const response = await axios.post("http://localhost:8080/customer/login", loginRequest);
    if(response.data.success){
        const {token} = response.data;
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