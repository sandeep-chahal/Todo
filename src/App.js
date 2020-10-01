import React from 'react';
import './App.css';
import DisplayTodos from './Components/DisplayTodos';
import {BrowserRouter as Router , Route , Switch} from "react-router-dom";
import Header from './Components/Header'

function App() {
    return (
      <div>
      <Router>
        <div className="container">
          <header> 
          <Header/> 
            <Switch>
              <Route path="/" exact component= {DisplayTodos}></Route>
            </Switch>
          </header>
        </div>
      </Router>
      </div>
    );
}

export default App;
