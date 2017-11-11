<%-- 
    Document   : unidade
    Created on : 10/11/2017, 14:39:55
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            section{width:100%;height:100%;}
            #conteudo-left{width:20%;height:100%;float: left;}
            #conteudo-right{width:50%;height:100%;float: left;}
        </style>
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../js/jsutil.js"></script>
        <script type="text/javascript" src="js/unidade.js"></script>
    </head>
    <body>
        <%@include file= "../menu.jsp" %>
        <section>
            <div id="conteudo-left">
                <h3>Cadastro</h3>

                <input id="id" type="hidden"/>

                Nome unidade<br/>
                <input id="nomeUnidade" type="text"/><br/>
                <br/>
                <input id="btnSalvar" type="button" value="Salvar"/>
            </div>
            <div id="conteudo-right">
                <h3>lista de unidades</h3><br/>
                <table id="tabela" border="1"></table>
            </div>

        </section>

    </body>
</html>
