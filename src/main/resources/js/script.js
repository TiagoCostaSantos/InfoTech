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