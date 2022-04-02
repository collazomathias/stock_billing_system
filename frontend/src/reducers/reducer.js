import { combineReducers } from "redux";
import { productReducer } from "./productReducer";
import { userReducer } from "./userReducer";
import { billReducer } from "./billReducer";

export const reducer = combineReducers({
    userReducer: userReducer,
    productReducer: productReducer,
    billReducer: billReducer
});