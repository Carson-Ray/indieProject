<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<main>
    <h1>Profile Page</h1>

    <c:choose>
        <c:when test="${newUserForm == true}">
            <h3>New User Information</h3>
            <form method="post" action="/updateProfile">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${firstName}">
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${lastName}">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" class="form-control" id="email" name="email" value="${email}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </c:when>
        <c:otherwise>
            <c:out value="${sessionScope.user.firstName} ${sessionScope.user.lastName}"/>
            <br>
            <h3>User Information</h3>
            <form method="post" action="/editProfile">
                <button type="submit" class="btn btn-success">Edit Profile</button>
            </form>
        </c:otherwise>
    </c:choose>
    <c:out value="${users}"/>
    <c:out value="${allPokemon}"/>



</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>