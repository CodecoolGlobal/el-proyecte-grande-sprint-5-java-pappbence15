const submitButton = document.querySelector(".submitButton")

submitButton.addEventListener('click', handleRegistration)


function apiPost(url, payload) {
    fetch(url, {
        headers: {
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(payload)
    })
        // .then(res => res.json())
        // .then(data => console.log(data))
}

function handleRegistration() {
    const userType = document.querySelector('#userType').value
    const uName = document.querySelector('#name').value
    const userName = document.querySelector('#username').value
    const password = document.querySelector('#password').value
    const email = document.querySelector('#email').value

    console.log(userType)

    const payload = {
        "userType": userType,
        "name": uName,
        "userName": userName,
        "password": password,
        "email": email
    }

    apiPost('http://localhost:8080/register', payload)

}
