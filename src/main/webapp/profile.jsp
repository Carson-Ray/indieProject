<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<main>
    <h1>Profile Page</h1>
    <br>
    <C:choose>
        <c:when test="${empty user}">
                <h3>New User Information</h3>
        </c:when>
        <c:otherwise>
            <h5>Signed in as ${user.firstName} ${user.lastName}</h5>
        </c:otherwise>
    </C:choose>
    <c:if test="${userForm == true}">
        <form>
            <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </c:if>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>