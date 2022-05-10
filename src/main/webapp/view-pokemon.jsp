<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<main>
    <div class="container-fluid">
        <div class="card bg-dark text-light">
            <div class="card-header">
                Learn more about ${value}
            </div>
            <div class="card-body">
                <c:forEach items="${allPokemon}" var="i">
                    <c:if test="${i.pokemon == value}">
                        <h5 class="card-title"><strong>${i.pokemon}</strong></h5>
                        <h6 class="card-subtitle mb-2 text-muted"><em>the ${i.role}</em></h6>
                        <c:if
                        <form name="addPoke" action="/addToUser" method="post">
                            <button type="submit" class="btn btn-outline-secondary btn-sm">
                                <i class="bi bi-heart"></i>Add to Favorites
                            </button>
                        </form>
                        <table class="table table-responsive">
                            <thead>
                            <tr>
                                <th>

                                </th>
                            </tr>
                            </thead>
                        </table>
                    </c:if>
                </c:forEach>
            </div>
        </div>




        <c:forEach items="${allPokemon}" var="i">
                <c:if test="${i.pokemon == value}">
                    <tr>
                        <td>${i.role}</td>
                        <td>${i.pokemon}</td>
                        <td>${i.attack}</td>
                        <td>${i.defense}</td>
                        <td>${i.getHP()}</td>
                        <td>${i.spAttack}</td>
                        <td>${i.spDefense}</td>
                    </tr>
                </c:if>
            </c:forEach>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>