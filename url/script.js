document.addEventListener("DOMContentLoaded", function () {
    const signupForm = document.getElementById("signup-form");
    const successMessage = document.getElementById("success-message");

    signupForm.addEventListener("submit", function (e) {
        e.preventDefault(); // Prevent the form from submitting via HTTP request

        // Get the form data
        const name = document.getElementById("name").value;
        const dob = document.getElementById("dob").value;
        const address = document.getElementById("address").value;
        const email = document.getElementById("email").value;

        // Perform client-side validation
        if (name === "" || dob === "" || address === "" || email === "") {
            // Display an error message if any field is empty
            successMessage.innerHTML = "All fields are required.";
            successMessage.style.color = "red";
        } else {
            // If validation passes, you can perform additional actions here
            // For example, you can send the data to the server for further processing
            // In this example, we just display a success message
            successMessage.innerHTML = "Signup Successful!";
            successMessage.style.color = "green";
        }
    });
});
