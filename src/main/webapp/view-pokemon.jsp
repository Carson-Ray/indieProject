<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<main>
    <h1>Hello, world!</h1>
    <c:out value="${current.pokemon}"/>
    <c:forEach items="${allPokemon}" var="i">
        <c:when test="${i.pokemon == current}">
            <p>${i.pokemon}</p>
            <p>${i.role}</p>
            <p>${i.attack}</p>
            <p>${i.defense}</p>
        </c:when>
    </c:forEach>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>