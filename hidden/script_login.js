document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("loginForm");

    loginForm.addEventListener("submit", function (event) {
        event.preventDefault();
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        if (!username || !password) {
            alert("Please enter both username/email and password.");
            return;
        }

        simulateLogin(username, password);
    });

    function simulateLogin(username, password) {

        if (username && password) {
            alert("Login successful!");
        } else {
            alert("Login failed. Please check your credentials.");
        }
    }
});
