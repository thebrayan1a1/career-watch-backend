import React from 'react'
import './styles/App.css'
import Landing from './views/Landing'
import {Route, Routes } from 'react-router-dom'
import Header from './components/Header'
import Login  from './views/Example'
import Boards from './views/Board'


function App() {
  return (
   <> 
   <Header/>
    <Routes>
      <Route  element={<Landing/>} path='/'/>
      <Route element={<Login/>} path='login'/>
      <Route element={<Boards/>} path='board'/>
    </Routes>
  </>
  )
}

export default App
