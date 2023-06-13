document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById("SignUpForm");

    loginForm.addEventListener("submit", async (event) => {
        event.preventDefault();

        const login = document.getElementById("emailInput").value;
        const password = document.getElementById("passwordInput").value;



        try {
            const response = await axios.post("http://localhost:8080/api/auth/login", {
                email: login,
                password: password
            });

            if (response.data.success){
                localStorage.setItem("accessToken", response.data.accessToken);
                window.location.href = "../html/home_page.html";
            }else {
                const errorMessage = document.getElementById("errorMessage");
                errorMessage.textContent = "Identifiants invalides.";
            }

        } catch (error) {
            console.log(error)
        }
    });
});