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
        <style>
            section{width:100%;height:100%;}
            #conteudo-left{width:20%;height:100%;float: left;}
            #conteudo-right{width:50%;height:100%;float: left;}
        </style>
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../js/jsutil.js"></script>
        <script type="text/javascript" src="js/index.js"></script>

    </head>
    <body>
        <%@include file= "../menu.jsp" %>
        <div>
            <h2> DESPESAS</h2>
        </div>
        <section>
            <div id="conteudo-left">
                <h3>Cadastro</h3>

                <input id="id" type="hidden"/>

                Descricão<br/>
                <input id="descricao" type="text"/><br/>
                Data<br/>
                <input id="dataDespesa" type="date"/><br/>
                Valor<br/>
                <input id="valor" type="text" placeholder="R$"/><br/>
                Observação<br/>
                <input id="observacao" type="text"/><br/><br/>


                <input id="btnSalvar" type="button" value="Salvar"/>
            </div>
            <div id="conteudo-right">
                <h3>lista de Despesas</h3><br/>
                <table id="tabela" border="1"></table>
            </div>

        </section>

    </body>
</html>
