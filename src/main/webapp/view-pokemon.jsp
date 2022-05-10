<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<main>
    <h1>Hello, world!</h1>
    <c:out value="${value}"/>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Pokemon</th>
            <th scope="col">Role</th>
            <th scope="col">Attack</th>
            <th scope="col">Defense</th>
            <th scope="col">HP</th>
            <th scope="col">SpAttack</th>
            <th scope="col">SpDefense</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${allPokemon}" var="i">
                <c:if test="${i.pokemon == value}">



                            <tr>${i.role}</tr>
                            <tr>${i.pokemon}</tr>


                </c:if>
            </c:forEach>
        </tbody>
    </table>
<%--        <table class="table">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th scope="col">Pokemon</th>--%>
<%--            <th scope="col">Role</th>--%>
<%--            <th scope="col">Attack</th>--%>
<%--            <th scope="col">Defense</th>--%>
<%--            <th scope="col">HP</th>--%>
<%--            <th scope="col">SpAttack</th>--%>
<%--            <th scope="col">SpDefense</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--            <tbody>--%>
<%--            <c:forEach items="${allPokemon}" var="i">--%>
<%--                <c:set var="current" value="${i}"/>--%>
<%--                <c:if test="${current.pokemon == value}">--%>



<%--                        <tr>--%>
<%--                            <td>${current.pokemon}</td>--%>
<%--                            <td>${current.role}</td>--%>
<%--                            <td>${current.attack}</td>--%>
<%--                            <td>${current.defense}</td>--%>
<%--                            <td>${current.hp}</td>--%>
<%--                            <td>${current.spAttack}</td>--%>
<%--                            <td>${current.spDefense}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <th scope="row">2</th>--%>
<%--                            <td>Jacob</td>--%>
<%--                            <td>Thornton</td>--%>
<%--                            <td>@fat</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <th scope="row">3</th>--%>
<%--                            <td>Larry</td>--%>
<%--                            <td>the Bird</td>--%>
<%--                            <td>@twitter</td>--%>
<%--                        </tr>--%>

<%--                </c:if>--%>
<%--            </c:forEach>--%>
<%--            </tbody>--%>
<%--        </table>--%>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>