//const img = document.querySelector("img");
//img.src = "images/bi1.jpg";

const img = document.createElement("img");
img.src = "images/" + localStorage.getItem('imageSource');
document.body.appendChild(img);
