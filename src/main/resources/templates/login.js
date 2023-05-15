$(document).ready(function() {
    $('#login-form').submit(function(event) {
        event.preventDefault(); // Empêche la soumission du formulaire

        var email = $('#email').val();
        var password = $('#password').val();

        // soumettre le formulaire via AJAX
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/auth/login',
            data: {
                email: email,
                password: password
            },
            success: function(response) {
                // stocker le jeton JWT dans le stockage local ou la session du navigateur
                localStorage.setItem('jwt_token', response.accessToken);
                console.log(response.accessToken)

                // effectuer un appel GET à votre homeController en utilisant le token JWT dans l'en-tête d'autorisation
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/home",
                    headers: {
                        'Authorization': 'Bearer ' + response.accessToken
                    },
                    success: function() {
                        // rediriger vers la page souhaitée en utilisant le token JWT dans l'en-tête d'autorisation
                        window.location.href = "/ma-page";
                    }
                });
            },
            error: function(xhr, status, error) {
                // afficher un message d'erreur à l'utilisateur
                $('#erreur-connexion').text('Identifiants incorrects');
            }
        });
    });
});