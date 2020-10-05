import {combineReducers} from "redux"
import securityReducer from "../reducers/securityReducer"
import errorReducer from "./errorReducer";

export default combineReducers({
    security: securityReducer,
    error: errorReducer
});