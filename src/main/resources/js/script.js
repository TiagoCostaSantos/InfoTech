const registrarBtnLink = document.querySelector('.registrarBtn-link');
const loginBtnLink = document.querySelector('.LoginBtn-link');
const wrapper = document.querySelector('.wrapper');

registrarBtnLink.addEventListener('click', () => {
    console.log("entrou aqui")
    wrapper.classList.add('active');
});

loginBtnLink.addEventListener('click', () => {
    console.log("login")
    wrapper.classList.remove('active');
});

let button = document.getElementById("button");

button.addEventListener('mousemove', (e) => {
    x = e.offsetX;
    y = e.offsetY;
    button.style.setProperty('--mouse-x', x + "px");
    button.style.setProperty('--mouse-y', y + "px");
});