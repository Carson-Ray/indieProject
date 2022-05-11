<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <c:import url="head.jsp"/>
    <c:import url="navbar.jsp"/>
<body>
<div class="container-fluid">
    <main class="flex-fill">
        <div class="p-5 mb-4 bg-light rounded-3">
            <div class="container-fluid py-5">
                <h1 class="display-5 fw-bold">Welcome to P.U.B</h1>
                <p class="col-md-8 fs-4">Pokemon Unite Battler is a custom resource that allows players to view the stats of the current playable characters in Pokemon Unite and add to their custom team.</p>
                <c:choose>
                    <c:when test="${userName == null}">
                        <div class="btn-group">
                            <form method="post" action="/logIn">
                                <button class="btn btn-outline-secondary" type="submit">Sign Up</button>
                            </form>
                            <form method="post" action="/viewGallery">
                                <button class="btn btn-outline-secondary" type="submit">View Gallery</button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="btn-group">
                            <form method="post" action="/viewProfile">
                                <button class="btn btn-outline-secondary" type="submit">My Team</button>
                            </form>
                            <form method="post" action="/viewGallery">
                                <button class="btn btn-outline-secondary" type="submit">View Gallery</button>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="row mb-5 align-items-md-stretch">
            <div class="col-md-6">
                <div class="h-100 p-5 text-white bg-dark rounded-3">
                    <h2>Interested in Stats?</h2>
                    <p>Our Stat Table allows you to easily find the Pokemon stats you're looking for.</p>
                    <form method="post" action="/viewAllPokemon">
                        <button class="btn btn-outline-light" type="submit">View Stats</button>
                    </form>
                </div>
            </div>
            <div class="col-md-6">
                <div class="h-100 p-5 bg-light border rounded-3">
                    <h2>P.U.B v.1</h2>
                    <p>P.U.B is currently in development, with this release being the first of the application's life. Keep an eye out for v.2, and stay classy gamers!</p>
                </div>
            </div>
        </div>
    </main>
</div>
<c:import url="footer.jsp"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>