<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyCars</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-6">
            <h4>Добавьте машину</h4><br>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <form method="post" action="/garage">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInput" name="name">
                    <label for="floatingInput">Название машины</label>
                </div>
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingID" name="id">
                    <label for="floatingID">ID машины</label><br>
                </div>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingColor" name="color">
                    <label for="floatingColor">Цвет машины</label>
                </div>
                <button type="submit" class="btn btn-outline-primary">Подтвердить</button>
            </form>

        </div>
    </div>

    <div class="row">
        <div class="col-6" class="form-floating">
            <h4>Найдите машину по ID или получите весь список машин</h4>
            <form method="get" action="/garage">
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingSearch" name="id">
                    <label for="floatingID">Введите ID машины для поиск</label><br>
                </div>
                <button type="submit" class="btn btn-outline-primary">Подтвердить</button>


            </form>


            <table class="table table-striped">
                <tr>
                    <th> ID</th>
                    <th> Car</th>
                    <th>Color</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>

                <c:forEach var="car" items="${cars}">
                <tr>
                    <td>
                        <c:out value="${car.id}"/>
                    </td>
                    <td>
                        <c:out value="${car.name}"/>
                    </td>
                    <td>
                        <c:out value="${car.color}"/>
                    </td>
                    <td>
                        <form action="/delete" method="post">
                            <input type="hidden" name="carId" value="${car.id}">
                            <button type="submit" class="btn btn-outline-primary">Удалить</button>
                        </form>
                    </td>
                    <td>
                        <form action="/update" method="post">
                            <input type="hidden" name="idUp" value="${car.id}">
                            <input type="hidden" name="nameUp" value="${car.name}">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="floatingColorCar" name="colorUp">
                                <label for="floatingColor">Новый цвет машины</label>
                            </div>
                            <button type="submit" class="btn btn-outline-primary">Обновить</button>

                        </form>
                    </td>

                </tr>
                </c:forEach>

        </div>

    </div>

    <div class="row">
        <div class="col-6">
            <h4>Удалите машину</h4>
            <form action="/delete" method="post">
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingDelete" name="carId">
                    <label for="floatingDelete">Введите ID машины для удаления</label><br>
                </div>
                <button type="submit" class="btn btn-outline-primary">Подтвердить</button>

            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-6">

        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <h4>Обновите машину</h4>
            <form action="/update" method="post">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="floatingInputUp" name="nameUp">
                    <label for="floatingInputUp">Название машины</label>
                </div>
                <div class="form-floating">
                    <input type="number" class="form-control" id="floatingIDUp" name="idUp">
                    <label for="floatingID">ID машины</label><br>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingColorUp" name="colorUp">
                    <label for="floatingID">Цвет машины</label><br>
                </div>
                <button type="submit" class="btn btn-outline-primary">Подтвердить</button>
                <br>
            </form>
        </div>
    </div>
</div>
<br>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
