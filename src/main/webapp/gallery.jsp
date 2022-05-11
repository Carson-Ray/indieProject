<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<div class="container-fluid">
    <main class="flex-fill">

        <div class="mx-auto p-5">
            <div class="row row-cols-1 row-cols-md-2 g-4">
                <c:forEach items="${allPokemon}" var="i">
                    <div class="col">
                        <div class="card bg-dark text-light w-100 align-items-stretch">
                            <div class="card-header">
                                <c:if test="${userName != null}">
                                    <form class="align-self-end" name="addPoke" action="/addToUser" method="post">
                                        <button type="submit" class="btn btn-outline-secondary btn-sm">
                                            <i class="bi bi-heart"></i>  Add to Favorites
                                        </button>
                                    </form>
                                </c:if>
                            </div>
                            <div class="card-body">
                                <h1 class="card-title"><strong>${i.pokemon}</strong></h1>
                                <h6 class="card-subtitle mb-2 mb-3 text-muted"><em>${i.role}</em></h6>
                                <div class="table-responsive">
                                    <table class="card-table table-striped text-center">
                                        <tbody>
                                        <tr>
                                            <th scope="row">Attack</th>
                                            <td>${i.attack}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">Defense</th>
                                            <td>${i.defense}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">HP</th>
                                            <td>${i.getHP()}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">SpAttack</th>
                                            <td>${i.spAttack}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">SpDefense</th>
                                            <td>${i.spDefense}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
</main>
</div>
<c:import url="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>