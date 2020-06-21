<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>TPO_ZAD</title>
  </head>
  <body>
  <p>Hej</p>
  <form action="http://localhost:8080/web_war_exploded/api/book">
    <label for="name">Tytuł książki:</label><br>
    <input type="text" id="name" name="name"><br>
    <input style="margin: 20px" type="submit" value="Pobierz książki o takim tytule">
  </form>
  <form action="http://localhost:8080/web_war_exploded/api/book">
    <label for="name">ID książki:</label><br>
    <input type="text" id="id" name="id"><br>
    <input style="margin: 20px" type="submit" value="Pobierz książki o takim ID">
  </form>
  <form action="http://localhost:8080/web_war_exploded/api/book">
    <input style="margin: 20px" type="submit" value="Pobierz wszystkie książki">
  </form>

  </body>
</html>