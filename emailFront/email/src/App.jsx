import React from 'react'
import EmailSender from './components/EmailSender'
import {Toaster} from "react-hot-toast"

const App = () => {
  return (
    <div>
      <EmailSender></EmailSender>
      <Toaster></Toaster>
    </div>
  )
}

export default App

