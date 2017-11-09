/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to;

import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class TODespesa {
    private int id;
    private String descricao;
    private Date dataDespesa;
    private double valor;
    private String observacao;
    
    public TODespesa(ResultSet rs) throws Exception {
        this.id = rs.getInt("id");
        this.descricao = rs.getString("descricao");
        this.dataDespesa = rs.getDate("dataDespesa");
        this.valor = rs.getDouble("valor");
        this.observacao = rs.getString("observacao");
        
    }
    
    public TODespesa() {
    }

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dataDespesa
     */
    public Date getDataDespesa() {
        return dataDespesa;
    }

    /**
     * @param dataDespesa the dataDespesa to set
     */
    public void setDataDespesa(Date dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
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
