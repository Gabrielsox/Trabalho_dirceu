/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class TOProduto {

    private int id;
    private String nomeProduto;
    private int fornecedor_idFornecedor;
    private int categoria_idCategoria;
    private int unidadeMedida_idUnidadeMedida;
    private int qtdAtual;
    private int qtdMinima;
    private Double valorCusto;
    private Double ValorVenda;
    private String observacao;

    public TOProduto(ResultSet rs) throws Exception {
        this.id = rs.getInt("id");
        this.nomeProduto = rs.getString("nomeProduto");
        this.fornecedor_idFornecedor = rs.getInt("fornecedor_idFornecedor");
        this.categoria_idCategoria = rs.getInt("categoria_idCategoria");
        this.unidadeMedida_idUnidadeMedida = rs.getInt("unidadeMedida_idUnidadeMedida");
        this.qtdAtual = rs.getInt("qtdAtual");
        this.qtdMinima = rs.getInt("qtdMinima");
        this.valorCusto = rs.getDouble("valorCusto");
        this.ValorVenda = rs.getDouble("ValorVenda");
        this.observacao = rs.getString("observacao");

    }
    
    public TOProduto(){}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the fornecedor_idFornecedor
     */
    public int getFornecedor_idFornecedor() {
        return fornecedor_idFornecedor;
    }

    /**
     * @param fornecedor_idFornecedor the fornecedor_idFornecedor to set
     */
    public void setFornecedor_idFornecedor(int fornecedor_idFornecedor) {
        this.fornecedor_idFornecedor = fornecedor_idFornecedor;
    }

    /**
     * @return the categoria_idCategoria
     */
    public int getCategoria_idCategoria() {
        return categoria_idCategoria;
    }

    /**
     * @param categoria_idCategoria the categoria_idCategoria to set
     */
    public void setCategoria_idCategoria(int categoria_idCategoria) {
        this.categoria_idCategoria = categoria_idCategoria;
    }

    /**
     * @return the unidadeMedida_idUnidadeMedida
     */
    public int getUnidadeMedida_idUnidadeMedida() {
        return unidadeMedida_idUnidadeMedida;
    }

    /**
     * @param unidadeMedida_idUnidadeMedida the unidadeMedida_idUnidadeMedida to set
     */
    public void setUnidadeMedida_idUnidadeMedida(int unidadeMedida_idUnidadeMedida) {
        this.unidadeMedida_idUnidadeMedida = unidadeMedida_idUnidadeMedida;
    }

    /**
     * @return the qtdAtual
     */
    public int getQtdAtual() {
        return qtdAtual;
    }

    /**
     * @param qtdAtual the qtdAtual to set
     */
    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    /**
     * @return the qtdMinima
     */
    public int getQtdMinima() {
        return qtdMinima;
    }

    /**
     * @param qtdMinima the qtdMinima to set
     */
    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    /**
     * @return the valorCusto
     */
    public Double getValorCusto() {
        return valorCusto;
    }

    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    /**
     * @return the ValorVenda
     */
    public Double getValorVenda() {
        return ValorVenda;
    }

    /**
     * @param ValorVenda the ValorVenda to set
     */
    public void setValorVenda(Double ValorVenda) {
        this.ValorVenda = ValorVenda;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
