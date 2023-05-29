

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
            document.getElementById("name").textContent = user.firstName + " " + user.lastName
            document.getElementById("address").textContent =user.address
            document.getElementById("first-name-input").value =user.firstName
            document.getElementById("last-name-input").value =user.lastName
            document.getElementById("address-input").value =user.address
        })
        .catch(error => {console.log(error)});

    document.getElementById("form-profile").addEventListener("submit", async (event)=>{
        var matieresCoches = document.querySelectorAll('input[name="matieres"]:checked');
        var matieresSelectionnees = [];

        for (var i = 0; i < matieresCoches.length; i++) {
            matieresSelectionnees.push(matieresCoches[i].value);
        }
        console.log(matieresSelectionnees)

        var firstName = document.getElementById("first-name-input").value;
        var lastName = document.getElementById("last-name-input").value;
        var address = document.getElementById("address-input").value;
        await axios.put("http://localhost:8080/api/user/profile", {
            firstName: firstName,
            lastName: lastName,
            address: address
        }).then(response =>{
            console.log(response)
        })
            .catch(error => { console.log(error)})

    });
});

