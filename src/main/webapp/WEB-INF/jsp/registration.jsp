<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>

<body>
<div>
    <form:form method="POST" modelAttribute="userForm">
        <h2>Регистрация</h2>

        <div>
            <form:input type="text" path="username" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
                ${usernameError}
        </div>

        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>

        <div>
            <form:input type="password" path="passwordConfirm"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>
                ${passwordError}
        </div>


        <div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="myStatus" id="OWNER" checked value="OWNER">
                <label class="form-check-label" for="OWNER">
                    OWNER
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="myStatus" id="WORKER" checked value="WORKER">
                <label class="form-check-label" for="WORKER">
                    WORKER
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="myStatus" id="VISITOR" checked value="VISITOR">
                <label class="form-check-label" for="VISITOR">
                    VISITOR
                </label>
            </div>
        </div>
        <button type="submit">Зарегистрироваться</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>