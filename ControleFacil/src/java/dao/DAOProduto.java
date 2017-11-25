/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import fw.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import to.TOProduto;


/**
 *
 * @author gabri
 */
public class DAOProduto {
    public static void inserir(Connection c, TOProduto t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" insert into produto (nomeProduto, fornecedor_idFornecedor, categoria_idCategoria,"
                + " unidadeMedida_idUnidadeMedida,qtdAtual,qtdMinima,valorCusto,valorVenda,observacao) ");
        sql.append(" values (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

        Data.executeUpdate(c, sql.toString(),
                t.getNomeProduto(), t.getFornecedor_idFornecedor(), t.getCategoria_idCategoria(), t.getUnidadeMedida_idUnidadeMedida(),
                t.getQtdAtual(),t.getQtdMinima(),t.getValorCusto(),t.getValorVenda(),t.getObservacao());
    }

    
    public static void excluir(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" delete from produto ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(), id);
    }

    public static TOProduto obter(Connection c, int id) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeProduto, fornecedor_idFornecedor, categoria_idCategoria,"
                + " unidadeMedida_idUnidadeMedida, qtdAtual, qtdMinima, valorCusto, valorVenda, observacao from produto ");
        sql.append(" where id = ? ");

        try (ResultSet rs = Data.executeQuery(c, sql.toString(), id)) {

            if (rs.next()) {
                return new TOProduto(rs);
            } else {
                return null;
            }

        }

    }

    public static void alterar(Connection c, TOProduto t) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" update produto ");
        sql.append(" set nomeProduto = ?, fornecedor_idFornecedor = ?, categoria_idCategoria = ?, unidadeMedida_idUnidadeMedida = ?, qtdAtual = ? ,"
                + " qtdMinima = ?, valorCusto = ?, valorVenda = ?, observacao = ? ");
        sql.append(" where id = ? ");

        Data.executeUpdate(c, sql.toString(),           
                t.getNomeProduto(), t.getFornecedor_idFornecedor(), t.getCategoria_idCategoria(), t.getUnidadeMedida_idUnidadeMedida(),
                t.getQtdAtual(),t.getQtdMinima(),t.getValorCusto(),t.getValorVenda(),t.getObservacao(),t.getId());
    }

    public static List<TOProduto> lista(Connection c, String filtro) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append(" select id, nomeProduto, fornecedor_idFornecedor, categoria_idCategoria,"
                + " unidadeMedida_idUnidadeMedida,qtdAtual,qtdMinima,valorCusto,valorVenda,observacao from produto ");
        sql.append(" order by nomeProduto ");

        List<TOProduto> l = new ArrayList<>();

        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
            while (rs.next()) {
                l.add(new TOProduto(rs));
            }
        }
        return l;
    }
    
//    public static List<TOProduto> lista(Connection c, String filtro) throws Exception {
//        StringBuilder sql = new StringBuilder();
//        sql.append(" select a.id, a.nomeProduto, b.nomeFornecedor, c.nomeCategoria, d.nomeUnidade, a.qtdAtual,a.qtdMinima,a.valorCusto,valorVenda,a.observacao ");
//        sql.append(" from produto as a ");
//        sql.append(" inner join fornecedor as b on b.id = a.fornecedor_idFornecedor ");
//        sql.append(" left join categoria as c on c.id =  a.fornecedor_idFornecedor ");
//        sql.append(" left join unidadeMedida as d on d.id =  a.fornecedor_idFornecedor; "); 
//        sql.append(" order by a.nomeProduto ");
//
//        List<TOProduto> l = new ArrayList<>();
//
//        try (ResultSet rs = Data.executeQuery(c, sql.toString())) {
//            while (rs.next()) {
//                l.add(new TOProduto(rs));
//            }
//        }
//        return l;
//    }


}
