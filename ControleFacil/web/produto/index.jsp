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
        <section>
            <div id="conteudo-left">
                <h3>Cadastro Produto</h3>

                <input id="id" type="hidden"/>

                Nome<br/>
                <input id="nomeProduto" type="text"/><br/>
                Fornecedor<br/> 
                <select class="basic"> 
                    <option id="selectFornecedor" ></option>
                    
                </select> <input id="btnNovoFornecedor" type="button" value="+"/><br/>
                Categoria<br/>
                <select class="basic">
                    <option id="selectCategoria" ></option>
                    
                </select> <input id="btnNovoCategoria" type="button" value="+"/><br/>
                Unidade medida<br/>
                <select id="selectUnidade" class="basic">
                    
                    
                </select> <input id="btnNovoUnidade" type="button" value="+"/><br/>
                Quantidade atual <br/>
                <input id="qtd_atual" type="text"/><br/>
                Quantidade minima <br/>
                <input id="qtd_minima" type="text"/><br/>
                Valorde custo<br/>
                <input id="valor_custo" type="text"/><br/>
                Valor de venda<br/>
                <input id="valor_venda" type="text"/><br/>
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
