const initialState = {
    bills: []
}

export const billReducer = (state = initialState, action) => {
    switch(action.type){
        case "addBill":
            const bills = ([...state.bills, action.payload]);
            return { ...state, bills: bills }
        default: 
            return state;
    }
}