//const img = document.querySelector("img");
//img.src = "images/bi1.jpg";

const img = document.createElement("img");
img.src = "images/" + localStorage.getItem('imageSource');
img.width = 800;
img.height = 600;
document.body.appendChild(img);
