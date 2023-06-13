document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("SignUpFormSchool").addEventListener("submit", function(event) {
        event.preventDefault();

        // Récupérer les valeurs du formulaire
        var name = document.getElementById("name").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var address = document.getElementById("address").value;

        // Vérifier si des champs sont manquants
        if (!name || !email || !password || !address) {
            alert("Veuillez remplir tous les champs du formulaire.");
            return; // Arrêter l'exécution du code si des champs sont manquants
        }

        // Créer un objet contenant les données de l'utilisateur
        var school = {
            name: name,
            email: email,
            password: password,
            address: address
        };

        console.log(school)

        // Effectuer une requête POST pour enregistrer l'ecole
        fetch("http://localhost:8080/api/school/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(school)
        })
            .then(function(response) {
                if (response.ok) {
                    alert("Inscription réussie !");
                    window.location.href = "../html/signIn_page.html";
                } else {
                    alert("Une erreur s'est produite lors de l'inscription.");
                }
            })
            .catch(function(error) {
                console.error("Erreur lors de la requête d'inscription:", error);
            });
    });
});