<%@page contentType="text/html" import="java.util.*, java.text.*"
pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
        charset=ISO-8859-1">
        <title>Teste do KRL</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            int dia = Integer.parseInt((new SimpleDateFormat("dd")).format(new Date()));
            out.println("<br>Hoje é dia" + dia);
        %>
    </body>
</html>