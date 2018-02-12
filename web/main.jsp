<%@ page import="Beans.User" %>
<%@ page import="Beans.UserList" %>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<title>Game</title>
<script src="script.js"></script>
</head>

<body>

	<div class="krestiki_noliki">
		<p class="result">Your move!</p>	
		<div class="block cell1"></div>
		<div class="block cell2"></div>
		<div class="block cell3"></div>
		<div class="block cell4"></div>
		<div class="block cell5"></div>
		<div class="block cell6"></div>
		<div class="block cell7"></div>
		<div class="block cell8"></div>
		<div class="block cell9"></div>	
	</div>

	<div class="button new">
		<a class="link" id="first" href="/GameServlet">New game</a>
	</div>

	<div class="button exit">
		<a class="link" href="loginPage.jsp">Exit</a>
	</div>

	<div class="res">
		<p>Name = <%=request.getSession().getAttribute("player")%></p>
	<table>
		<tr>
			<td>Player</td>
			<td>Victories</td>
			<td>Loses</td>
		</tr>
		<%for(User temp: new UserList().getData()){%>
		<tr>
			<td><%=temp.getName()%></td>
			<td><%=temp.getVictories()%></td>
			<td><%=temp.getLosses()%></td>
		</tr>
		<%}%>
	</table>
	</div>

</body>
</html>