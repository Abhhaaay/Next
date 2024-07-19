
import {
    createBrowserRouter,
    RouterProvider,
  } from "react-router-dom";
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import Show from './components/show/show'
import './index.css'

const router = createBrowserRouter([
    {
      path: "/",
      element: <App />,
    },
    {
      path: "/show/:id",
      element: <Show />
    }
  ]);

ReactDOM.createRoot(document.getElementById('root')).render(
    <RouterProvider router={router}/>
)
