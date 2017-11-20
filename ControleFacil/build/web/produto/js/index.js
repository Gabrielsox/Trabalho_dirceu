Index = function () {

};

Index.Load = function () {
    var index = new Index();
    index.initialize();
    return index;
};

Index.prototype = {
    initialize: function () {

        $('#btnSalvar').bind('click', '', $.createDelegate(this, this._salvarClick));
        $('#btnNovoUnidade').bind('click', '', $.createDelegate(this, this._novoUnidadeClick));
        $('#btnNovoFornecedor').bind('click', '', $.createDelegate(this, this._novoFornecedorClick));
        $('#btnNovoCategoria').bind('click', '', $.createDelegate(this, this._novoCategoriaClick));


        this._obterSelectUnidade();
        this._obterSelectCategoria();
        this._obterSelectFornecedor();


        this._obterProdutos();
    },
    _novoCategoriaClick: function () {

        location.href = "categoria.jsp";
    },
    _novoFornecedorClick: function () {

        location.href = "/fornecedor/index.jsp";
    },
    _novoUnidadeClick: function () {

        location.href = "unidade.jsp";
    },
    _obterSelectUnidade: function () {

        this.dataBind(
                'GET', null,
                '/api/unidade',
                this._obterSelectUnidadeSuccess,
                this._obterSelectUnidadeError);
    },
    _obterSelectUnidadeSuccess: function (value) {


        $('#unidadeMedida_idUnidadeMedida').html('');
        var select = '<option value"">selecione uma unidade</option>';

        $('#unidadeMedida_idUnidadeMedida').append(select);

        for (var i = 0; i < value.length; i++) {

            select = '<option value="' + [i].id + '">' + value[i].nomeUnidade + '</option>';

            $('#unidadeMedida_idUnidadeMedida').append(select);

        }
    },

    _obterSelectUnidadeError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },

    _obterSelectCategoria: function () {

        this.dataBind(
                'GET', null,
                '/api/categoria',
                this._obterSelectCategoriaSuccess,
                this._obterSelectCategoriaError);
    },

    _obterSelectCategoriaSuccess: function (value) {


        $('#categoria_idCategoria').html('');
        var select = '<option value"">selecione uma categoria</option>';

        $('#categoria_idCategoria').append(select);

        for (var i = 0; i < value.length; i++) {


            select = '<option value="' + [i].id + '">' + value[i].nomeCategoria + '</option>';

            $('#categoria_idCategoria').append(select);


        }
    },

    _obterSelectCategoriaError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },

    _obterSelectFornecedor: function () {

        this.dataBind(
                'GET', null,
                '/api/fornecedor',
                this._obterSelectFornecedorSuccess,
                this._obterSelectFornecedorError);
    },

    _obterSelectFornecedorSuccess: function (value) {


        $('#fornecedor_idFornecedor').html('');
        var select = '<option value"">selecione uma fornecedor</option>';

        $('#fornecedor_idFornecedor').append(select);

        for (var i = 0; i < value.length; i++) {


            select = '<option value="' + [i].id + '">' + value[i].nomeFornecedor + '</option>';

            $('#fornecedor_idFornecedor').append(select);


        }
    },

    _obterSelectFornecedorError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },

    _obterProdutos: function () {

        
        this.dataBind(
                'GET',
                '',
                '/api/produto',
                this._obterProdutosSuccess,
                this._obterProdutosError);
    },
    _obterProdutosSuccess: function (value) {


        $('#tabela').html('');

        var tabela = '<tr>';
        tabela += '<td>Id</td>';
        tabela += '<td>Produto</td>';
        tabela += '<td>Fornecedor</td>';
        tabela += '<td>Categoria</td>';
        tabela += '<td>Unidade</td>';
        tabela += '<td>QTD atual</td>';
        tabela += '<td>QTD minima</td>';
        tabela += '<td>Valor custo </td>';
        tabela += '<td>Valor venda</td>';
        tabela += '<td>Observação</td>';
        tabela += '<td>-</td>';
        tabela += '</tr>';

        $('#tabela').append(tabela);

        for (var i = 0; i < value.length; i++) {

            tabela = '<tr>';
            tabela += '<td>';
            tabela += value[i].id;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].nomeProduto;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].fornecedor_idFornecedor;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].categoria_idCategoria;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].unidadeMedida_idUnidadeMedida;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].qtdAtual;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].qtdMinima;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].valorCusto;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].valorVenda;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].observacao;
            tabela += '</td>';
            tabela += '<td><input type="button" id="btnExcluir' + value[i].id + '" value="Excluir"/>';
            tabela += '<input type="button" id="btnAlterar' + value[i].id + '" value="Alterar"/></td>';
            tabela += '</tr>';

            $('#tabela').append(tabela);
            
            // criando um objeto item para passar como parâmetro no método de exclusão

            var item = {
                id: value[i].id
            };

            $('#btnExcluir' + value[i].id).bind('click', item, $.createDelegate(this, this._excluirClick));
            $('#btnAlterar' + value[i].id).bind('click', item, $.createDelegate(this, this._alterarClick));
        }
    },

    _obterProdutosError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },

    _alterarClick: function (value) {

        this.dataBind('GET', null,
                '/api/produto/' + value.data.id,
                this._alterarClickSuccess,
                this._alterarClickError);

    },
    _alterarClickSuccess: function (value) {
        $('#id').val(value.id);
        $('#nomeProduto').val(value.nomeProduto);
        $('#fornecedor_idFornecedor').val(value.fornecedor_idFornecedor);
        $('#categoria_idCategoria').val(value.categoria_idCategoria);
        $('#selectUnidade').val(value.unidadeMedida_idUnidadeMedida);
        $('#qtdAtual').val(value.qtdAtual);
        $('#qtdMinima').val(value.qtdMinima);
        $('#valorCusto').val(value.valorCusto);
        $('#valorVenda').val(value.valorVenda);
        $('#observacao').val(value.observacao);


    },
    _alterarClickError: function (value) {


    },
    _excluirClick: function (value) {

        this.dataBind(
                'DELETE',
                '',
                '/api/produto/' + value.data.id,
                this._obterProdutos,
                this._obterProdutosError);

    },

    _salvarClick: function () {

        var data = {
            id: $('#id').val(),
            nomeProduto: $('#nomeProduto').val(),
            fornecedor_idFornecedor: $('#fornecedor_idFornecedor').val(),
            categoria_idCategoria: $('#categoria_idCategoria').val(),
            unidadeMedida_idUnidadeMedida: $('#unidadeMedida_idUnidadeMedida').val(),
            qtdAtual: $('#qtdAtual').val(),
            qtdMinima: $('#qtdMinima').val(),
            valorCusto: $('#valorCusto').val(),
            valorVenda: $('#valorVenda').val(),
            observacao: $('#observacao').val()
        };

        // atenção que esta estrutura em javascript precisa respeitar a mesma estrutura
        // do modelo criado no java.
        // os valores que estão sendo passado via JQUERY $('#xxx') precisam ter o mesmo
        // nome do id no input, div, textarea, etc

        var datastr = JSON.stringify(data);

        // JSON.stringify - método que transforma o modelo javascript em string

        if (data.id == '' || data.id == undefined) {

            this.dataBind(
                    'POST',
                    datastr,
                    '/api/produto',
                    this._salvaClickSuccess,
                    this._salvaClickError);

        } else {

            this.dataBind(
                    'PUT',
                    datastr,
                    '/api/produto',
                    this._salvaClickSuccess,
                    this._salvaClickError);

        }

    },
    _salvaClickSuccess: function (value) {

        $('#id').val('');
        $('#nomeProduto').val('');
        $('#fornecedor_idFornecedor').val('');
        $('#categoria_idCategoria').val('');
        $('#unidadeMedida_idUnidadeMedida').val('');
        $('#qtdAtual').val('');
        $('#qtdMinima').val('');
        $('#valorCusto').val('');
        $('#valorVenda').val('');
        $('#observacao').val('');

        this._obterProdutos();

    },
    _salvaClickError: function (value) {

        alert(value);

    },

    dataBind: function (type, data, url, success, error) {
        $.ajax({
            type: type,
            cache: false,
            data: data,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: url,
            success: $.createDelegate(this, success),
            error: $.createDelegate(this, error)
        });
    }
};

$(document).ready(function () {
    Index.Load();
});