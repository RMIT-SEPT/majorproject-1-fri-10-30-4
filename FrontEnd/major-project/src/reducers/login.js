import { initialState } from "../initialState"
import * as t from "../actions/types"

export const loginReducer = (state = initialState, action) => {
    switch (action.type) {
        case t.SET_LOGIN_STATE:
            return {
                ...state,
                ...action.payload,
                isLoggedIn:true,
            };
        default:
            return state;
    }
}