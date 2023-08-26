const problemIcon = document.getElementById("work_icon");
const relationshipIcon = document.getElementById("relationship_icon");
const workModalContainer = document.querySelectorAll(".modal-container")[0];
const relationshipModalContainer = document.querySelectorAll(".modal-container")[1];
const closeModalButton = document.querySelectorAll(".btnClose");

problemIcon.addEventListener("click", () => {
  workModalContainer.classList.add("active");
});

relationshipIcon.addEventListener("click", () => {
  relationshipModalContainer.classList.add("active");
});

closeModalButton.forEach(button => {
  button.addEventListener("click", () => {
    workModalContainer.classList.remove("active");
    relationshipModalContainer.classList.remove("active");
  });
});

