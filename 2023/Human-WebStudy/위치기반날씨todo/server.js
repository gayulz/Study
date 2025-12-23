const express = require('express');
const app = express();
const port = 3000;

require('dotenv').config();

app.get('/', (req, res) => {
  res.send('Hello World!');
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});


const fetch = require('node-fetch');

app.get('/weather', async (req, res) => {
  const { latitude, longitude } = req.query;
  const apiKey = process.env.API_KEY;
  const url = `https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${apiKey}`;

  try {
    const response = await fetch(url);
    const data = await response.json();
    res.json(data);
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
});
