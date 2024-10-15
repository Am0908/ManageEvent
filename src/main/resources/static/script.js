async function fetchEvents() {
    const response = await fetch('/api/events');
    const events = await response.json();
    const eventList = document.getElementById('eventList');
    eventList.innerHTML = '';

    events.forEach(event => {
        const eventDiv = document.createElement('div');
        eventDiv.className = 'event';
        eventDiv.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.description}</p>
            <p>${event.date}</p>
            <button onclick="registerForEvent(${event.id})">Register</button>
        `;
        eventList.appendChild(eventDiv);
    });
}

async function registerForEvent(eventId) {
    const userName = prompt("Please enter your name:"); // Get user name
    if (!userName) {
        alert("Registration cancelled.");
        return;
    }

    try {
        const response = await fetch(`/api/events/${eventId}/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userName),
        });

        if (response.ok) {
            const registration = await response.json();
            alert(`Successfully registered for event ID: ${registration.eventId}`);
        } else {
            alert("Registration failed. Please try again.");
        }
    } catch (error) {
        console.error("Error during registration:", error);
        alert("An error occurred. Please try again.");
    }
}


document.addEventListener('DOMContentLoaded', fetchEvents);
