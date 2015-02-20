<html>
	<head>
		<title>Mosh Services Documentation</title>
	</head>
<body>
<div>
	<h1>API REFERENCE</h1>
	<div>
		<div>GET /concerts</div>
		<div>Returns all concerts found from the current date</div>
	</div>
	<div>
		<div> GET /concerts?name= </div>
		<div> Returns all concerts with name given as parameter, and all concerts from artists with the same name given as parameter</div>
	</div>
	
	<div>GET /concerts?date= </div>
	<div>GET /concerts?location= </div>
	<div>GET	/concerts?artists= </div>
	<div>POST /user POST /</div> 
</div>
	
<div>
	<h1>Model Reference</h1>
	<h2>Artist </h2>
	<div>-name</div><div> -country</div><div> -startDate</div>
	<div>-soloist (boolean)</div> <div>-artistsRelated (List of Artist - @ManyToMany)</div>

	<h2>Location</h2> 
	<div>-Address </div>
	<div>-Name </div>
	<div>-Type (ENUM) </div>
	<div>-City </div>
	
	<h2>LocationType (ENUM) </h2>
	<div>STADIUM</div>
	<div>-THEATER </div>
	
	<h2>CONCERT</h2>
	<div> -Artists (List of artists - @OneToMany)</div>
	<div> -Date (Can be	NULL - Concert to be confirmed)</div>
	<div> -Location (Can be NULL - To be confirmed)</div>
	</div>	
</body>
</html>