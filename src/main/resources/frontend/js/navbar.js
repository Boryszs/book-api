let navBar = '<ul class="navbar-nav mr-auto mt-2 mt-lg-0">';
navBar += '<li class="nav-item active">';
navBar += '<a class="nav-link font-weight-bold" href="books.html">Książki<span class="sr-only">(current)</span></a>';
navBar += '</li>';
navBar += '<li class="nav-item active">';
navBar += '<a class="nav-link font-weight-bold" href="reservations.html">Moje wypożyczenia</a>';
navBar += '</li>';
navBar += '</ul>';
navBar += '<form class="form-inline my-2 my-lg-0"><button type="button" class="btn btn-light font-weight-bold" onclick="logOut()">Log out</button></form>';
document.getElementById("navigation").innerHTML = navBar;

