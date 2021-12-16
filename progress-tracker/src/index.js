import * as React from 'react';
import ReactDOM from 'react-dom';
import './style/index.css';
import App from './App';
import { StyledEngineProvider } from '@mui/material/styles';

ReactDOM.render(
  <StyledEngineProvider injectFirst>
      <App />
  </StyledEngineProvider>,
  document.getElementById('root')
);
