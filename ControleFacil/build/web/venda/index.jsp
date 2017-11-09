<%-- 
    Document   : index
    Created on : 28/10/2017, 15:27:03
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file= "../menu.jsp" %>
        <h3>Vendas</h3>
        
        <input value="Novo Cliente" type="button" ><br/><br/>
        
        <form method="POST" action="">
            Busca:<input name="filtro" value=""/> <input type="submit" value="Buscar"/>
        </form>
    </body>
</html>
