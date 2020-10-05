import React, { Component } from 'react';
import {Provider} from "react-redux"
import store from "./store"
import LoginHandler from './LoginHandler';


class App extends Component { 
    render() {
        return (
            <div>
                <Provider store={store}>
                  <LoginHandler/>
                </Provider>
            </div>
        )
    }
}

export default App
