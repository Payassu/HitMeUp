// Get references to elements
const signUpLink = document.querySelector('a[href="#"]');
const signUpFormContainer = document.getElementById('signup-form-container');
const backdrop = document.getElementById('backdrop');
const closeButton = document.getElementById('close-button'); // Add a close button in the form if needed

// Show the sign-up form and backdrop
signUpLink.addEventListener('click', () => {
    signUpFormContainer.classList.remove('hidden');
    backdrop.classList.remove('hidden');
});

// Close the sign-up form and backdrop
backdrop.addEventListener('click', () => {
    signUpFormContainer.classList.add('hidden');
    backdrop.classList.add('hidden');
});

// Show the login form and hide the sign-up form
document.querySelector('#signup-form').addEventListener('submit', (e) => {
    e.preventDefault(); // Prevent form submission for now
    // You can add your own logic here to handle form submission

    // For now, let's just hide the sign-up form and backdrop
    signUpFormContainer.classList.add('hidden');
    backdrop.classList.add('hidden');
});

closeButton.addEventListener('click', () => {
    signUpFormContainer.classList.add('hidden');
    backdrop.classList.add('hidden');
});
