import { combineReducers } from "redux";
import { productReducer } from "./productReducer";
import { userReducer } from "./userReducer";

export const reducer = combineReducers({
    userReducer: userReducer,
    productReducer: productReducer
});