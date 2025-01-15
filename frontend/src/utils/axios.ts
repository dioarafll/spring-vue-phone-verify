

import axios from 'axios';

/**
 * Create an Axios instance with default configuration.
 * 
 */
const apiClient = axios.create({
  baseURL: 'http://localhost:8080', // Change this to your API base URL
  timeout: 10000, // Optional timeout in milliseconds
  headers: {
    'Content-Type': 'application/json',
  },
});

export default apiClient;
