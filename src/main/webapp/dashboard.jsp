<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
  <div>
    <h1>Receitas</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="receita" items="${receitas}">
            <tr>
                <td>${receita.id}</td>
                <td>${receita.name}</td>
                <td>
                    <form action='/delete-receita' method="post">
                        <input type="hidden" id="id" name="id" value="${receita.id}">
                        <button type="submit">Delete</button>
                        <span> | </span>
                        <a href="index.jsp?id=${receita.id}&name=${receita.name}">Update</a>
                    </form>
            </tr>
        </c:forEach>
    </table>
  </div>
</body>
</html>