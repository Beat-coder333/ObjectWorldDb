<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continents</title>
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
	<h2>Continents</h2>

	<form action="/ObjectWebDatabase/continent-select" method="get">
		<div>
			<input type="submit" value="get" name="get">
		</div>
	</form>
	<div>
		<c:forEach items="${ContinentList}" var="continent">
			<p>
				Continent:<a
					href="/ObjectWebDatabase/nation-list?continentValue=${continent.name}">${continent.name}</a>
			</p>
		</c:forEach>
	</div>
	<div>

		<c:forEach items="${nationList}" var="nation">
			<p>
				Nation: <a
					href="/ObjectWebDatabase/city-list?continentValue=${nation.name}">
					${nation.name}</a> | Population: ${nation.population}
			</p>

		</c:forEach>
	</div>

	<div>

		<c:forEach items="${cityList}" var="city">
			<p>City: ${city.name} | Population: ${city.population}</p>

		</c:forEach>
	</div>

</body>
</html>


