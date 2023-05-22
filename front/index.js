const express = require('express');
const cors = require('cors');

const app = express();

// Appliquer le middleware CORS à toutes les routes
app.use(cors());

// Vos autres configurations et routes

// Démarrer le serveur
app.listen(8081, () => {
    console.log('Serveur en cours d\'exécution sur le port 8081');
});