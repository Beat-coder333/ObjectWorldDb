<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country List</title>
</head>
<body>
	<div class=navigazone>
		<p>
			<a href="/ObjectWebDatabase/pages/city-info.jsp">City</a>
		</p>
		<p>
			<a href="/ObjectWebDatabase/pages/country-list.jsp">Country</a>
		</p>
		<p>
			<a href="/ObjectWebDatabase/pages/continent-select.jsp">Continent</a>
		</p>
	</div>
	<div class=user>
		<h2>${logged_user}</h2>
	</div>
	<form action="/ObjectWebDatabase/country-list" method="get">
		<h1>Nation / Country</h1>
		<div>
			<label>Insert Nation</label> <input type="text" name="findNation" />
		</div>
		<br>
		<div>
			<label>Insert Continent</label> <input type="text"
				name="findContinent" />
		</div>
		<div>
			<input type="submit" value="Find" name="Find">
		</div>

	</form>
	<div>
		<h1>List:</h1>

		<c:forEach items="${countryList}" var="listCo">
			<p>
				Nation code: ${listCo.code} | Nation: ${listCo.name} | Continent: ${listCo.continent} |
				Population: ${listCo.population} | Surface Area:
				${listCo.surfaceArea}
			</p>
		</c:forEach>

	</div>

</body>
</html>