document.addEventListener("DOMContentLoaded", function () {
    const contentDiv = document.querySelector(".content");

    function loadContent(menuItem) {
        const content = document.createElement("div");
        content.classList.add("menu-content");

        while (contentDiv.firstChild) {
            contentDiv.removeChild(contentDiv.firstChild);
        }

        switch (menuItem) {
            case "login":
                content.innerHTML = "<h2>Login</h2><p>Login form goes here.</p>";
                break;
            case "signup":
                content.innerHTML = "<h2>Sign Up</h2><p>Sign up form goes here.</p>";
                break;
            case "recipes":
                content.innerHTML = "<h2>Recipes</h2><p>List of recipes goes here.</p>";
                break;
            case "about":
                content.innerHTML = "<h2>About Us</h2><p>About us content goes here.</p>";
                break;
            default:
                content.innerHTML = "<p>Select a menu item to display content.</p>";
                break;
        }

        contentDiv.appendChild(content);
    }

    const menuItems = document.querySelectorAll(".left-menu a");
    menuItems.forEach((menuItem) => {
        menuItem.addEventListener("click", function (e) {
            e.preventDefault();
            loadContent(menuItem.id);
        });
    });
});
