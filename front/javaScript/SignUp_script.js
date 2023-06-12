document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("SignUpForm").addEventListener("submit", function(event) {
        event.preventDefault();

        // Récupérer les valeurs du formulaire
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var address = document.getElementById("address").value;
        var firstNameDiv = document.getElementById("first-name-div");
        var schoolSwitch = document.getElementById("school-profile-switch").value

        // Vérifier si des champs sont manquants

        if (schoolSwitch == true){
            [firstNameDiv].style.visibility='hidden'
            if (!lastName || !email || !password || !address) {
                alert("Veuillez remplir tous les champs du formulaire.");
                return; // Arrêter l'exécution du code si des champs sont manquants
            }
            var school = {
                lastName : lastName,
                email: email,
                password: password,
                address: address,
            };
            // Effectuer une requête POST pour enregistrer l'utilisateur
            fetch("http://localhost:8080/api/auth/register/school_profile", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
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
            return;
        } else {
            if (!firstName || !lastName || !email || !password || !address) {
                alert("Veuillez remplir tous les champs du formulaire.");
                return; // Arrêter l'exécution du code si des champs sont manquants
            }
            // Créer un objet contenant les données de l'utilisateur
            var user = {
                firstName: firstName,
                lastName: lastName,
                email: email,
                password: password,
                address: address
            };

        console.log(user)

            // Effectuer une requête POST pour enregistrer l'utilisateur
            fetch("http://localhost:8080/api/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
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
            return;
        }
        return;
        })


});
