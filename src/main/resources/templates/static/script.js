document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    axios.post('/auth/login', { email, password })
        .then(function(response) {
            const token = response.data.accessToken;
            localStorage.setItem('accessToken', token);
            window.location.href = '/home'; // Rediriger vers la page d'accueil sécurisée
        })
        .catch(function(error) {
            console.error(error);
            alert('Adresse e-mail ou mot de passe incorrect');
        });
});