<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<main>
    <div class="container">
        <div class="tbodyDiv">
            <table class="table table-dark table-striped table-hover text-center myTable">
                <thead class="sticky-top allHeader">
                    <tr>
                        <th class="align-middle" scope="col">Pokemon</th>
                        <th class="align-middle" scope="col">Role</th>
                        <th class="align-middle" scope="col">Attack</th>
                        <th class="align-middle" scope="col">Defense</th>
                        <th class="align-middle" scope="col">HP</th>
                        <th class="align-middle" scope="col">SpAttack</th>
                        <th class="align-middle" scope="col">SpDefense</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allPokemon}" var="i">
                        <tr>
                            <td><a class="link-light" href="/viewPokemon?value=${i.pokemon}"><strong>${i.pokemon}</strong></a></td>
                            <td>${i.role}</td>
                            <td>${i.attack}</td>
                            <td>${i.defense}</td>
                            <td>${i.getHP()}</td>
                            <td>${i.spAttack}</td>
                            <td>${i.spDefense}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<c:import url="footer.jsp"/>
</body>
</html>