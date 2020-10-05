import {combineReducers} from "redux"
import securityReducer from "../reducers/securityReducer"

export default combineReducers({
    security: securityReducer
});