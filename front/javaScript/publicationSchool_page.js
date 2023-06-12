
    // Fonction pour ajouter une nouvelle publication
function addPublication() {
    // Récupérez les données du formulaire
    var title = document.getElementById('first-name-input').value;
    var photo = document.getElementById('photo').value;
    var content = document.getElementById('description').value;

    // Créez un objet Publication avec les données
var publication = {
    title: title,
    photo: photo,
    content: content
};

    // Envoyez la publication au serveur en utilisant Axios
axios.post('/publications', publication)
.then(function (response) {
    // En cas de succès, récupérez toutes les publications mises à jour
    axios.get('/publications')
.then(function (response) {
    // Appel de la fonction pour mettre à jour l'affichage
    updatePublications(response.data);
})
.catch(function (error) {
    console.log(error);
});
})
.catch(function (error) {
    console.log(error);
});
}

    // Fonction pour mettre à jour l'affichage des publications
function updatePublications(publications) {
    var profileDiv = document.querySelector('.profile');
    profileDiv.innerHTML = '';

    for (var i = 0; i < publications.length; i++) {
    var publication = publications[i];

    // Créez les éléments HTML pour représenter la publication
    var publicationDiv = document.createElement('div');
    var titleElement = document.createElement('h4');
    var photoElement = document.createElement('img');
    var contentElement = document.createElement('p');

    titleElement.textContent = publication.title;
    photoElement.src = publication.photo;
    contentElement.textContent = publication.content;

    publicationDiv.appendChild(titleElement);
    publicationDiv.appendChild(photoElement);
    publicationDiv.appendChild(contentElement);

    profileDiv.appendChild(publicationDiv);
}
}
function closePopup() {
    document.getElementById('popupEvent').style.display = 'none';
}
