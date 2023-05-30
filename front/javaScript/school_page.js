document.addEventListener("DOMContentLoaded", async function () {
    console.log("coucou");
    const token = localStorage.getItem("accessToken");
    await axios
        .get("http://localhost:8080/api/search/school", {
            headers: {
                Authorization: "Bearer " + token,
            },
        })
        .then((response) => {
            console.log(response);

            const schoolCardsContainer = document.getElementById("schoolCardsContainer");

            response.data.forEach((schoolName) => {
                const schoolCard = document.createElement("div");
                schoolCard.classList.add("profil-ecole");

                const cardContent = `
          <div class="frame-8">
            <div class="frame-50">
              <img class="rectangle-4" src="../img/landscape.jpg" alt="Rectangle 4" />
              <img class="ellipse-6 rounded-circle" src="../img/photo-de-profil.png" alt="Ellipse 6"/>
            </div>
            <div class="frame-51">
              <div class="frame-47">
                <div class="nom-de-lecole valign-text-middle inter-normal-black-12px" id="name">${schoolName}</div>
                <div class="information-generale valign-text-middle">
                  Information generales sur l'ecole<br />
                  olqhwdaold<br/>
                </div>
              </div>
              <div class="frame-49">
                <button class="follow-button valign-text-middle inter-normal-black-12px">Follow</button>
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
                            .post("http://localhost:8080/api/user/followed-schools", followedSchool, {
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
                            .delete("http://localhost:8080/api/user/followed-schools", {
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
        .finally(() => {});
});
