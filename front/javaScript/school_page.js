document.addEventListener("DOMContentLoaded", async function () {

    console.log("coucou")
    const token = localStorage.getItem("accessToken");
    await axios.get("http://localhost:8080/api/search/school", {
        headers: {
            Authorization: "Bearer " + token
        }
    })
        .then(response => {
            console.log(response)

            const schoolCardsContainer = document.getElementById("schoolCardsContainer");

            response.data.forEach(school => {

                const schoolCard = document.createElement("div");
                schoolCard.classList.add("profil-ecole");

                const formations = school.formations.map(formation => formation.subjectOfInterest.name).join(', ');

                // Code pour générer le contenu de la carte de l'école
                const cardContent = `
                <div class="frame-8">
                    <div class="frame-50">
                        <img class="rectangle-4" src="${school.bannerUrl}" alt="Rectangle 4" />
                        <img class="ellipse-6 rounded-circle" src="${school.imageUrl}" alt="Ellipse 6"/>
                    </div>
                    <div class="frame-51">
                        <div class="frame-47">
                            <div class="nom-de-lecole valign-text-middle inter-normal-black-12px">${school.name}</div>
                            <div class="information-generale valign-text-middle">
                                ${school.info}<br />
                                Address: ${school.address}<br/>
                                Formations: ${formations}
                            </div>
                        </div>
                        <div class="frame-49">
                            <div class="follow valign-text-middle inter-normal-black-12px">Follow</div>
                        </div>
                    </div>
                </div>
            `;

                schoolCard.innerHTML = cardContent;
                schoolCardsContainer.appendChild(schoolCard);



                const followButton = schoolCard.querySelector(".follow-button");
                followButton.addEventListener("click", function () {
                    if (followButton.innerText === "Follow") {
                        followButton.innerText = "Unfollow";

                        const followedSchool = { name: schoolName };

                        axios
                            .post("http://localhost:8080/api/follow/add", followedSchool, {
                                headers: {
                                    Authorization: "Bearer " + token,
                                },
                            })
                            .then((response) => {
                                console.log("School added to followed schools:", response.data);
                                // Additional actions if needed
                            })
                            .catch((error) => {
                                console.log("Error adding school to followed schools:", error);
                            });
                    } else if (followButton.innerText === "Unfollow") {
                        followButton.innerText = "Follow";

                        const unfollowedSchool = { name: schoolName };
                        axios
                            .delete("http://localhost:8080/api/follow/delete", {
                                headers: {
                                    Authorization: "Bearer " + token,
                                },
                                data: unfollowedSchool,
                            })
                            .then((response) => {
                                console.log("School removed from followed schools:", response.data);
                                // Additional actions if needed
                            })
                            .catch((error) => {
                                console.log("Error removing school from followed schools:", error);
                            });
                    }
                });
            });
        })
        .catch((error) => {
            console.log(error);
        })
        .finally(() => {

        });

})