document.addEventListener("DOMContentLoaded", async function (response) {

    const token = localStorage.getItem("accessToken");

    await axios.get("http://localhost:8080/api/user/profile", {
        headers: {
            Authorization: "Bearer " + token
        }
    })
    function getNameOnClick(div) {
        div.addEventListener('click', function() {
            var divName = div.getAttribute('name');
            console.log('Clicked div name:', divName);
            return divName;
        });
    }
});

