const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();

// Appliquer le middleware CORS à toutes les routes
app.use(cors());

// Définir la route pour la page d'accueil
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'loginPage.html'));
});

// Autres routes et configurations

// Démarrer le serveur
app.listen(8081, () => {
    console.log('Serveur en cours d\'exécution sur le port 8081');
});