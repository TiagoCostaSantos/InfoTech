const registrarBtnLink = document.querySelector('.registrarBtn-link');
const loginBtnLink = document.querySelector('.LoginBtn-link');
const wrapper = document.querySelector('.wrapper');

registrarBtnLink.addEventListener('click', () => {
    wrapper.classList.add('active');
});

loginBtnLink.addEventListener('click', () => {
    wrapper.classList.add('active');
});