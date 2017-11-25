<%-- 
    Document   : produto
    Created on : 28/10/2017, 15:26:47
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
            select.basic {width: 173px;height: 21px;}
        </style>
        <script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="../js/jsutil.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
    </head>
    <body>
        <%@include file= "../menu.jsp" %>
        <div>
            <h2> PRODUTOS</h2>
        </div>
        <section>
            <div id="conteudo-left">
                <h3>Cadastro</h3>

                <input id="id" type="hidden"/>

                Nome<br/>
                <input id="nomeProduto" type="text"/><br/>
                Fornecedor<br/> 
                <select id="fornecedor_idFornecedor" class="basic"> 


                </select> <input id="btnNovoFornecedor" type="button" value="+"/><br/>
                Categoria<br/>
                <select id="categoria_idCategoria" class="basic">


                </select> <input id="btnNovoCategoria" type="button" value="+"/><br/>
                Unidade medida<br/>
                <select id="unidadeMedida_idUnidadeMedida" class="basic">


                </select> <input id="btnNovoUnidade" type="button" value="+"/><br/>
                Quantidade atual <br/>
                <input id="qtdAtual" type="text"/><br/>
                Quantidade minima <br/>
                <input id="qtdMinima" type="text"/><br/>
                Valorde custo<br/>
                <input id="valorCusto" type="text"/><br/>
                Valor de venda<br/>
                <input id="valorVenda" type="text"/><br/>
                Observação<br/>
                <input id="observacao" type="text"/><br/><br/>

                <input id="btnSalvar" type="button" value="Salvar"/>
            </div>
            <div id="conteudo-right">
                <h3>lista de Produtos</h3><br/>
                <table id="tabela" border="1"></table>
            </div>

        </section>

    </body>
</html>
