<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:import url="head.jsp"/>
<c:import url="navbar.jsp"/>
<body>
<div class="container-fluid">
    <main class="flex-fill">
    <c:choose>
        <c:when test="${newUserForm == true}">
            <h3>Edit User Information</h3>
            <div class="container rounded bg-white mt-5 mb-5">
                <div class="row">
                    <div class="col border-right">
                        <div class="p-3 py-5">
                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h4 class="text-right">Profile Settings</h4>
                            </div>
                            <form action="/updateProfile" method="post">
                                <div class="row mt-2">
                                    <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control" placeholder="first name" value="${firstName}"></div>
                                    <div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control" value="${lastName}" placeholder="surname"></div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control" placeholder="enter email" value="${email}"></div>
                                </div>
                                <div class="mt-5 text-center"><button class="btn btn-success" type="submit">Save Profile</button></div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
</div>
</div>
        </c:when>
        <c:otherwise>
            <section class="section about-section gray-bg" id="about">
                <div class="container">
                    <div class="row align-items-center mb-5">
                        <div class="col">
                            <div class="about-text go-to">
                                <h3 class="dark-color">My Profile</h3>
                                <div class="row about-list">
                                    <div class="col-md-6">
                                        <div class="media">
                                            <label>First Name</label>
                                            <p>${user.firstName}</p>
                                        </div>
                                        <div class="media">
                                            <label>Last Name</label>
                                            <p>${user.lastName}</p>
                                        </div>
                                        <div class="media">
                                            <label>Username</label>
                                            <p>${user.userName}</p>
                                        </div>
                                        <div class="media">
                                            <label>Email</label>
                                            <p>${user.email}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <c:if test="${not empty userPokemon}">
                        <div class="team">
                            <div class="row">
                                <c:forEach items="${userPokemon}" var="poke">
                                    <div class="col-6">
                                        <div class="count-data text-center">
                                            <h6>${poke.name}</h6>
                                            <p class="m-0px font-w-600">${poke.role}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:if>
                </div>
            </section>
        </c:otherwise>
    </c:choose>
</main>
</div>
<c:import url="footer.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>