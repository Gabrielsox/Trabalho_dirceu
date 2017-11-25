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
        $('#btnNovoCliente').bind('click', '', $.createDelegate(this, this._salvarClienteClick));

        this._obterSelectCliente();
        this._obterUsuarios();
    },
    _salvarClienteClick: function () {
       location.href = "/cliente/index.jsp";
    },
    
    
    
    
    
    _obterSelectCliente: function () {

        this.dataBind(
                'GET', null,
                '/api/cliente',
                this._obterSelectClienteSuccess,
                this._obterSelectClienteError);
    },
    _obterSelectClienteSuccess: function (value) {
        

        $('#id_cliente').html('');
        var select = '<option value"">selecione um cliente</option>';

        $('#id_cliente').append(select);

        for (var i = 0; i < value.length; i++) {

            select = '<option value="' + value[i].id + '">' + value[i].nome + '</option>';

            $('#id_cliente').append(select);

        }
    },

    _obterSelectClienteError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    _obterUsuarios: function () {
        
        this.dataBind(
                'GET',
                '',
                '/api/receber/',
                this._obterUsuariosSuccess,
                this._obterUsuariosError);
    },
    _obterUsuariosSuccess: function (value) {
            
            
        $('#tabela').html('');

        var tabela = '<tr>';
        tabela += '<td>Id</td>';
        tabela += '<td>Id Cliente</td>';
        tabela += '<td>Descrição</td>';
        tabela += '<td>Valor R$</td>';
        tabela += '<td>Data vencimento</td>';        
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
            tabela += value[i].id_cliente;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].descricao;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].valor;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].dataVencimento;
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
    _alterarClick: function (value) {

        this.dataBind('GET', null,
                '/api/receber/' + value.data.id,
                this._alterarClickSuccess,
                this._alterarClickError);

    },
    _alterarClickSuccess: function (value) {
        $('#id').val(value.id);
        $('#id_cliente').val(value.id_cliente);
        $('#descricao').val(value.descricao);
        $('#valor').val(value.valor);
        $('#dataVencimento').val(value.dataVencimento);        
        $('#observacao').val(value.observacao);
    },
    _alterarClickError: function (value) {

    },
    _excluirClick: function (value) {

        this.dataBind(
                'DELETE',
                '',
                '/api/receber/' + value.data.id,
                this._obterUsuarios,
                this._obterUsuariosError);

    },
    _obterUsuariosError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },
    
    
    _salvarClick: function () {

        var data = {
            id: $('#id').val(),
            id_cliente: $('#id_cliente').val(),
            descricao: $('#descricao').val(),
            valor: $('#valor').val(),
            dataVencimento: $('#dataVencimento').val(),           
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
                    '/api/receber',
                    this._salvaClickSuccess,
                    this._salvaClickError);

        } else {

            this.dataBind(
                    'PUT',
                    datastr,
                    '/api/receber',
                    this._salvaClickSuccess,
                    this._salvaClickError);

        }

    },
    _salvaClickSuccess: function (value) {

        $('#id').val('');
        $('#id_cliente').val('');
        $('#descricao').val('');
        $('#valor').val('');
        $('#dataVencimento').val('');        
        $('#observacao').val('');

        this._obterUsuarios();

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