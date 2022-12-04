import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom'
import ListStudentComponent from './components/ListStudentComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateStudentComponent from './components/CreateStudentComponent';
import UpdateStudentComponent from './components/UpdateStudentComponent';
import ViewStudentComponent from './components/ViewStudentComponent';

function App() {
  return (
    <div>
        
        <Router>
              <HeaderComponent />
              
                <div className="container">
                    <Routes> 
                    
                          <Route path = "/" exact component = {<ListStudentComponent/>}></Route>
                          <Route path = "/student" component = {ListStudentComponent}></Route>
                          <Route path = "/student/:id" component = {CreateStudentComponent}></Route>
                          <Route path = "/student/:id" component = {ViewStudentComponent}></Route>
                          {/* <Route path = "/student/:id" component = {UpdateStudentComponent}></Route> */}
                    </Routes>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;
