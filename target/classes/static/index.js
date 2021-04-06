// Authors: Liplan Lekipising and catherine Muthoni

var slideIndex = 0;

showSlides();

function showSlides() {

    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");

    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";  
    }

    slideIndex++;

    if (slideIndex > slides.length) {slideIndex = 1}    
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }

    slides[slideIndex-1].style.display = "block";  
    dots[slideIndex-1].className += " active";

    setTimeout(showSlides, 4000); // Change image every 2 seconds

}

function showProductMessage(){
    alert("Product added successfully!");
}

function showAccountMessage(){
    alert("Account created successfully!");
}


function showOrders(){
    var x = document.getElementById("myorders");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else if (x.style.display === "block"){
        x.style.display = "none";
    }
    document.getElementById("details").style.display = "none";

}

function showAccount(){
    var x = document.getElementById("details");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else if (x.style.display === "block"){
        x.style.display = "none";
    }
    document.getElementById("myorders").style.display = "none";
    
}

function addCart(){
    // get product details
    // add to cart div
    alert("Added to cart!")
}

