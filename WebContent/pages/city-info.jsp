<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>City Info</title>
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
		<h2>Welcome: ${logged_user}</h2>
	</div>

	<form action="/ObjectWebDatabase/cityservlet" method="get">
		<div>
			<label>Find the city</label> <input type="text" name="findCity" />
		</div>
		<div>
			<input type="submit" value="Find" name="Find">
		</div>

	</form>
	<div>
		<h1>Selected city information:</h1>

		<p>Name: ${city.name} | Country Code: ${city.countryCode} | City
			District: ${city.district} | Population: ${city.population}</p>
	</div>

</body>
</html>