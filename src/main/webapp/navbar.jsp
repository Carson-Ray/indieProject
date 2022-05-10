<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">P.U.B</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Battle</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Pokemon
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/viewAllPokemon">View All Pokemon</a>
                        <div class="dropdown-divider"></div>
                        <c:forEach items="${allPokemon}" var="i">
                            <a class="dropdown-item" href="/viewPokemon?value=${i.pokemon}">${i.pokemon}</a>
                            <div class="dropdown-divider"></div>
                        </c:forEach>
                    </div>
                </li>
                <c:choose>
                    <c:when test="${userName == null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/logIn">Log In</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="/viewProfile"><c:out value=" ${userName}"/> </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logOut">Log Out</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
