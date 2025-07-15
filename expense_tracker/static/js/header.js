let navCancel = document.getElementById("nav-cancel");
let userOpBx = document.getElementById("user-op-box");
let userOption = document.getElementById("user-option");

userOption.addEventListener('click',()=>{
    userOpBx.style.display = "flex";
})

navCancel.addEventListener('click',()=>{
    userOpBx.style.display = "none";
})