document.addEventListener("DOMContentLoaded", async function () {

    const token = localStorage.getItem("accessToken");

    await axios.get("http://localhost:8080/api/user/profile", {
        headers: {
            Authorization: "Bearer " + token
        }
    })
        .then(response => {
            user = response.data
            document.getElementById("profilePic").setAttribute("src",user.imageLink)
            document.getElementById("firstName").textContent = user.firstName
            document.getElementById("lastName").textContent = user.lastName
            document.getElementById("address").textContent =user.address
        })
        .catch(error => {
            console.log(error)
        });

});