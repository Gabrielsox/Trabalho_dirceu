<%-- 
    Document   : despesa
    Created on : 28/10/2017, 15:25:19
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../js/jsutil.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
        
        
    </head>
    <body>
        <%@include file= "../menu.jsp" %>
               
        
        <h1>Cadastro</h1>

        <input id="id" type="hidden"/>

        Descricão<br/>
        <input id="descricao" type="text"/><br/>
        Data<br/>
        <input id="data" type="date"/><br/>
        Valor<br/>
        <input id="valor" type="text"/><br/>
        Observação<br/>
        <input id="observacao" type="text"/><br/><br/>
        
        <input id="btnSalvar" type="button" value="Salvar"/>

        <br/><br/>

        <table id="tabela" border="1">



        </table>
    </body>
</html>
