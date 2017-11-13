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
    _obterSelectUnidade: function () {
        
        this.dataBind(
                'GET',null,
                '/api/unidade',
                this._obterSelectUnidadeSuccess,
                this._obterSelectUnidadeError);
    },
    _obterSelectUnidadeSuccess: function (value) {
            
            
        $('#selectUnidade').html('');
        var select = '<option value"">selecione uma unidade</option>';
        
        $('#selectUnidade').append(select);
                
        for (var i = 0; i < value.length; i++) {
            
            
            select = '<option value="' + [i].id + '">' +value[i].nomeUnidade + '</option>';

            $('#selectUnidade').append(select);

           
        }
    },
    
    _obterSelectUnidadeError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },
    
    
    
    
    
    
    
    
    
    
    
    _obterSelectCategoria: function () {
        
        this.dataBind(
                'GET',null,
                '/api/categoria',
                this._obterSelectCategoriaSuccess,
                this._obterSelectCategoriaError);
    },

    
    _obterSelectCategoriaSuccess: function (value) {
            
            
        $('#selectCategoria').html('');
        var select = '<option value"">selecione uma categoria</option>';
        
        $('#selectCategoria').append(select);
                
        for (var i = 0; i < value.length; i++) {
            
            
            select = '<option value="' + [i].id + '">' +value[i].nomeCategoria + '</option>';

            $('#selectCategoria').append(select);

           
        }
    },
    
    _obterSelectCategoriaError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
    },
    
    
    
    
    
    
    
    
    
    
    
    
    _obterSelectFornecedor: function () {
        
        this.dataBind(
                'GET',null,
                '/api/fornecedor',
                this._obterSelectFornecedorSuccess,
                this._obterSelectFornecedorError);
    },

    
    _obterSelectFornecedorSuccess: function (value) {
            
            
        $('#selectFornecedor').html('');
        var select = '<option value"">selecione uma fornecedor</option>';
        
        $('#selectFornecedor').append(select);
                
        for (var i = 0; i < value.length; i++) {
            
            
            select = '<option value="' + [i].id + '">' +value[i].nomeFornecedor + '</option>';

            $('#selectFornecedor').append(select);

           
        }
    },
    
    _obterSelectFornecedorError: function () {
        alert('Ops... algo deu errado. Tente novamente.');
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