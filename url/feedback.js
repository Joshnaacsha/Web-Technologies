document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const confirmationMessage = document.createElement("div");
    confirmationMessage.classList.add("confirmation-message");
  
    form.addEventListener("submit", function (e) {
      e.preventDefault();
      
      // Perform form validation here
      const name = form.querySelector("#name").value;
      const email = form.querySelector("#email").value;
      const feedback = form.querySelector("#feedback").value;
  
      if (!name || !email || !feedback) {
        confirmationMessage.textContent = "Please fill in all fields.";
        confirmationMessage.classList.add("error");
      } else {
        // You can submit the form data to your server using AJAX
        // For simplicity, we'll just display a success message
        confirmationMessage.textContent = "Feedback submitted successfully!";
        confirmationMessage.classList.remove("error");
        
        // You can reset the form if needed
        form.reset();
      }
  
      // Append the confirmation message to the form
      form.appendChild(confirmationMessage);
    });
  });
  