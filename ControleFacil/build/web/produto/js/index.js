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

        this._obterUsuarios();
    },
    _novoCategoriaClick: function () {
        
       location.href="categoria.jsp"; 
    },
    _novoFornecedorClick: function () {
        
       location.href="/fornecedor/index.jsp"; 
    },
    _novoUnidadeClick: function () {
        
       location.href="unidade.jsp"; 
    },
    _obterUsuarios: function () {
        
        debugger;
        this.dataBind(
                'GET',
                '',
                '/api/cliente',
                this._obterUsuariosSuccess,
                this._obterUsuariosError);
    },
    _obterUsuariosSuccess: function (value) {
            
            
        $('#tabela').html('');

        var tabela = '<tr>';
        tabela += '<td>Id</td>';
        tabela += '<td>Nome</td>';
        tabela += '<td>E-mail</td>';
        tabela += '<td>Endereço</td>';
        tabela += '<td>Telefone</td>';
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
            tabela += value[i].nome;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].email;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].endereco;
            tabela += '</td>';
            tabela += '<td>';
            tabela += value[i].telefone;
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
    
    _obterUsuariosError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },
    
    _alterarClick: function (value) {

        this.dataBind('GET', null,
                '/api/cliente/' + value.data.id,
                this._alterarClickSuccess,
                this._alterarClickError);

    },
    _alterarClickSuccess: function (value) {
        $('#id').val(value.id);
        $('#nome').val(value.nome);
        $('#email').val(value.email);
        $('#endereco').val(value.endereco);
        $('#telefone').val(value.telefone);
        $('#observacao').val(value.observacao);
        
        
    },
    _alterarClickError: function (value) {
        
        
    },
    _excluirClick: function (value) {

        this.dataBind(
                'DELETE',
                '',
                '/api/cliente/' + value.data.id,
                this._obterUsuarios,
                this._obterUsuariosError);

    },
    
    _salvarClick: function () {

        var data = {
            id: $('#id').val(),
            nome: $('#nome').val(),
            email: $('#email').val(),
            endereco: $('#endereco').val(),
            telefone: $('#telefone').val(),
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
                    '/api/cliente',
                    this._salvaClickSuccess,
                    this._salvaClickError);

        } else {

            this.dataBind(
                    'PUT',
                    datastr,
                    '/api/cliente',
                    this._salvaClickSuccess,
                    this._salvaClickError);

        }

    },
    _salvaClickSuccess: function (value) {
        
        $('#id').val('');
        $('#nome').val('');
        $('#email').val('');
        $('#endereco').val('');
        $('#telefone').val('');
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